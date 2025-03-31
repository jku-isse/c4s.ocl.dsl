package at.jku.isse.ide.assistance;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionKind;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.util.concurrent.AtomicDouble;

import at.jku.isse.oclx.Constraint;
import at.jku.isse.oclx.Context;
import at.jku.isse.oclx.Exp;
import at.jku.isse.oclx.InfixExp;
import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.MethodCallExp;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.NestedExp;
import at.jku.isse.oclx.PrefixExp;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.StringLiteralExp;
import at.jku.isse.oclx.TypeCallExp;
import at.jku.isse.oclx.VarReference;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.validation.ElementToTypeMap.TypeAndCardinality;
import at.jku.isse.validation.OclxASTUtils;
import at.jku.isse.validation.TypeExtractor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnknownPropertyQuickfixer {

	private final TypeExtractor typeExtractor;
	private final EObjectAtOffsetHelper eObjectAtOffsetHelper;
	private final Diagnostic diagnostics;
	private final XtextResource resource;
	
	
	public UnknownPropertyQuickfixer(TypeExtractor typeExtractor, EObjectAtOffsetHelper eObjectAtOffsetHelper, Diagnostic diagnostics, XtextResource resource) {
		this.typeExtractor = typeExtractor;
		this.eObjectAtOffsetHelper = eObjectAtOffsetHelper;
		this.diagnostics = diagnostics;
		this.resource = resource;
	}	
	
	
	public List<CodeAction> createReplaceWithSubtype(int offset, String partialName) {
		var subclasses = findSubclassWithProperty(partialName, resource, offset);
		if (subclasses.isEmpty()) return Collections.emptyList();		
		var selfAndPrecedingElement = getPrecedingElement(resource, offset);
		var selfElement = selfAndPrecedingElement.get(0);
		var precedingElement = selfAndPrecedingElement.get(1);
		
		if (precedingElement instanceof SelfExp selfExp) {
			return generateRepairForSelfExp(selfExp, subclasses);
		}
		if (precedingElement instanceof PropertyAccessExp accessExp) {
			return generateRepairForPropertyAccessExp(accessExp, subclasses, partialName);
		}
		if (precedingElement instanceof MethodCallExp methodExp) {
			return generateRepairForMethodCallExp(methodExp, subclasses, partialName);
		}
		if (precedingElement instanceof VarReference varRef) {
			return generateRepairForVarReference(varRef, subclasses, partialName);
		}
		log.warn("ERROR in QuickFixCodeActionService: Unexpected preceding element: "+precedingElement.toString());
		return Collections.emptyList();
	}		

	private List<PPEInstanceType> findSubclassWithProperty(String propertyName, XtextResource resource, int offset) {
		var completeWithType = resolvePropertyAccessOrMethodResourceToType(resource, offset);
		var matches = new ArrayList<PPEInstanceType>();
		if (completeWithType != null) {
			completeWithType.getType().getAllSubtypesRecursively().stream()
				.filter(subtype -> subtype.hasPropertyType(propertyName)) // found property
				.filter(subtype -> matches.stream().noneMatch(superType -> subtype.isOfTypeOrAnySubtype(superType))) // but drop if its a subtype of a matching parent type
				.forEach(subtype -> matches.add(subtype)); 
		}
		return matches;
	}
				
	private TypeAndCardinality resolvePropertyAccessOrMethodResourceToType(XtextResource resource, int offset) {
		var modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (modelElement != null) {
			var el2TypeMap = typeExtractor.extractElementToTypeMap(modelElement).get();
			if (modelElement instanceof MethodExp methodExp) {
				var prevNav = OclxASTUtils.findPrecedingOperatorFor(methodExp);
				if (prevNav != null) {
					var completeWithType = el2TypeMap.getReturnTypeMap().get(prevNav);
					return completeWithType;
				}
			}
		}
		return null;
	}
	
	protected List<EObject> getPrecedingElement(XtextResource resource, int offset) {
		var modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		var varOrSelfContainer = modelElement.eContainer();
		if (varOrSelfContainer instanceof SelfExp selfExp) {
			var thisIndex = selfExp.getMethods().indexOf(modelElement);
			if (thisIndex > 0) return List.of(modelElement, selfExp.getMethods().get(thisIndex-1));
			else return List.of(modelElement, varOrSelfContainer);
		} else if (varOrSelfContainer instanceof VarReference varRef) { 
			var thisIndex = varRef.getMethods().indexOf(modelElement);
			if (thisIndex > 0) return List.of(modelElement, varRef.getMethods().get(thisIndex-1));
			else return List.of(modelElement, varOrSelfContainer);
		}
		return Collections.emptyList();
	}

	private List<CodeAction> generateRepairForSelfExp(SelfExp precedingElement, List<PPEInstanceType> subclasses) {
		// we cant really suggest a cast of context, rather make context more precise
		var ctx = getContext(precedingElement);
		return subclasses.stream()
		.map(subclass -> {
			var actionEdit = prepareSkeletonCodeAction();
			actionEdit.getKey().setTitle("Use '"+subclass.getName()+"' as a more specialized context element");									
			Range range = QuickFixCodeActionService.getRangeOfElement(ctx);
			actionEdit.getValue().add(new TextEdit(range, subclass.getName()));												
			return actionEdit.getKey();
		})
		.toList();				
	}
	
	private Context getContext(EObject exp) {
		if (exp == null) return null;
		if (exp instanceof Constraint constraint) {
			var ctx = constraint.getContext();
			return ctx;
		} else {
			return getContext(exp.eContainer());
		}
	}

	// repair by casting the property owning object
	private List<CodeAction> generateRepairForPropertyAccessExp(PropertyAccessExp accessExp, List<PPEInstanceType> subclasses, String propertyName){										
		var rankedSubClasses = OclxContentProposalProvider.getSimilaritySortedTypes(subclasses, propertyName);
		var subclassScore = rankedSubClasses.get(0);			
		var actionEdit = prepareSkeletonCodeAction();			
		actionEdit.getKey().setTitle("Access property '"+propertyName+"' in the more specialized type '"+subclassScore.getValue().getName()+"' ");
		var range = diagnostics.getRange();
		actionEdit.getValue().add(new TextEdit(range, "asType(<"+getTransformedFQN(subclassScore.getValue())+">)."+propertyName));							
		return List.of(actionEdit.getKey());
	}
	
	
	private List<CodeAction> generateRepairForMethodCallExp(MethodCallExp methodExp, List<PPEInstanceType> subclasses, String name) {
		// a method that returns a single instance can only happen over collection --> need to filter collection then cast object
		// get range of methodcall,
		var methodRange = QuickFixCodeActionService.getRangeOfElement(methodExp);
		var rankedSubClasses = OclxContentProposalProvider.getSimilaritySortedTypes(subclasses, methodExp.getName());
		var subclassScore = rankedSubClasses.get(0);
		
		// insert select
		if (methodRange != null) {
			var actionEdit = prepareSkeletonCodeAction();
			actionEdit.getKey().setTitle("Add a filter for instances of the more specialize type '"+subclassScore.getValue().getName()+"' before method/operation call '"+methodExp.getName()+"'");
			
			var pos = new Position(methodRange.getStart().getLine(), methodRange.getStart().getCharacter()-1);  // start and end are equal as we want to insert, shifted by 1: the . navigation character
			var range = new Range(pos, pos);
			actionEdit.getValue().add(new TextEdit(range, "->select(object | object.isKindOf(<"+getTransformedFQN(subclassScore.getValue())+">))"));								
			actionEdit.getValue().add(new TextEdit(diagnostics.getRange(), "asType(<"+getTransformedFQN(subclassScore.getValue())+">)."+name));
								
			return List.of(actionEdit.getKey());			
		} else return Collections.emptyList();
	}
	
	private List<CodeAction> generateRepairForVarReference(VarReference varRef, List<PPEInstanceType> subclasses, String name) {
		var refName = varRef.getRef().getName();				
		var path = new ArrayList<EObject>();		
		findPathToIterator(varRef, refName, path);
		if (!path.isEmpty()) {
			var iter = path.get(path.size()-1);
			// find most fitting type to refname as refname often conveys meaning
			List<Entry<Double, PPEInstanceType>> rankedSubClasses = (List<Entry<Double, PPEInstanceType>>) OclxContentProposalProvider.getSimilaritySortedTypes(subclasses, refName);
			var subclassScore = rankedSubClasses.get(0);
			if (subclassScore.getKey() < QuickFixCodeActionService.minSimilarityThreshold  // find better match
					|| (refName.length() <= 1 && rankedSubClasses.size() > 1) ) { // or if refName only 1 char and there are more candidates)
				//	find nearby candidate
				var candidates = findTypeIndicatorsAlongPathUpwards(path, varRef); 
				if (candidates.isEmpty()) // we continue search towards self
				{
					path.clear();
					path.addAll(producePathToSelf(iter).toList());
					candidates = path.stream()
							.filter(obj -> obj instanceof Exp)
							.map(obj -> (Exp)obj)
							.flatMap(exp -> findTypeIndicatorsDownwards(exp).stream()).distinct().toList()  ; 
				}
				var bestFit = refName.length() <= 1 ? 0.4 : subclassScore.getKey(); // penalize best fit param for single char iter refs
				replaceWithBetterMatch(rankedSubClasses, candidates, subclasses, bestFit);
				subclassScore = rankedSubClasses.get(0);
			}									
			
			var actionEdit = prepareSkeletonCodeAction();
			actionEdit.getKey().setTitle("Add a filter for instances of the more specialize subtype '"+subclassScore.getValue().getName()+"' before iterator");

			var iterRange = QuickFixCodeActionService.getRangeOfElement(iter);
			var pos = new Position(iterRange.getStart().getLine(), iterRange.getStart().getCharacter()-2);  // start and end are equal as we want to insert, shifted by 2: the -> navigation characters
			var range = new Range(pos, pos); // start and end are equal as we want to insert
			actionEdit.getValue().add(new TextEdit(range, "->select("+refName+"Untyped | "+refName+"Untyped.isKindOf(<"+getTransformedFQN(subclassScore.getValue())+">))"));		
			actionEdit.getValue().add(new TextEdit(diagnostics.getRange(), "asType(<"+getTransformedFQN(subclassScore.getValue())+">)."+name));	
			
			return List.of(actionEdit.getKey());		
		}
		return Collections.emptyList();
	}
	
	private void findPathToIterator(EObject exp, String iterVarName, List<EObject> path) {
		if (exp == null) { // not found, hence clear the path
			path.clear();			
		} else {
			path.add(exp);
			if (exp instanceof IteratorExp iterExp) {
				var varName = iterExp.getItervar().getName().getName();
				if (!varName.equals(iterVarName)) { //another nested iterator
					findPathToIterator(exp.eContainer(), iterVarName, path);
				}
			} else {
				findPathToIterator(exp.eContainer(), iterVarName, path);
			}		
		}
	}
	
	private Stream<EObject> producePathToSelf(EObject exp) {
		if (exp == null) {
			return Stream.empty();
		} else if (exp instanceof SelfExp) { 
			return Stream.of(exp);
		}else {
			return Stream.concat(Stream.of(exp), producePathToSelf(exp.eContainer()));
		}
	}
	
	protected List<String> findTypeIndicatorsAlongPathUpwards(List<EObject> pathUp, EObject comingFrom) {
		if (pathUp.isEmpty()) return Collections.emptyList();				
		var currentExp = pathUp.remove(0);
		if (currentExp instanceof Exp exp) {
			var typeStrings = new ArrayList<String>();
			// look at each level, spread out towards front of query (not the back as we probably have errors and couldn't analyse types)
			// include literal values but not the property we are currently trying to resolve
			if (exp instanceof InfixExp infixExp) {				 
				for (var sibling : infixExp.getExpressions()) {
					if (sibling.equals(comingFrom)) break;
					typeStrings.addAll(findTypeIndicatorsDownwards(sibling));
				}				
			}			
			if (typeStrings.size() < 3) // threshold when to stop searching
				typeStrings.addAll(findTypeIndicatorsAlongPathUpwards(pathUp, exp));
			return typeStrings;
		}
		return Collections.emptyList();
	}
	
	protected List<String> findTypeIndicatorsDownwards(Exp exp) {
		if (exp instanceof InfixExp infixExp) {
			return infixExp.getExpressions().stream().flatMap(subExp -> findTypeIndicatorsDownwards(subExp).stream()).toList();
		} 
		if (exp instanceof NestedExp nestedExp) {
			return findTypeIndicatorsDownwards(nestedExp.getSource());
		} 
		if (exp instanceof PrefixExp prefixExp) {
			return findTypeIndicatorsDownwards(prefixExp.getExpression());
		} 
		if (exp instanceof SelfExp || exp instanceof VarReference) {
			return Stream.concat(
					exp.getMethods().stream()
					.filter(op -> op instanceof TypeCallExp)
					.map(op -> (TypeCallExp)op)
					.map(typeCall -> typeCall.getType().getName())
					.map(typeName -> removePathFromType(typeName))
					.filter(typeName -> typeName.length() > 1) // ignore too short type names
					,		
					exp.getMethods().stream()
					.filter(op -> op instanceof PropertyAccessExp)
					.map(op -> (PropertyAccessExp)op)
					.map(propAccess -> propAccess.getName())
					.filter(propName -> propName.length() > 2) // ignore too short properties
					.map(propName -> { // handle process input/output here
						if (propName.startsWith("in_"))
							return propName.substring(3);
						if (propName.startsWith("out_"))
							return propName.substring(4);
						return propName;
					})
			).toList();
		} 
		if (exp instanceof StringLiteralExp strLit && strLit.getValue().length() > 1) { // other literals currently not sensible / avoid to short literals
				return List.of(strLit.getValue());
		}
		// TODO temporal expressions
		return Collections.emptyList();
	}
	
	private String removePathFromType(String type) {
		var pos = type.lastIndexOf("/");
		if (pos >= 0 && pos < type.length()-1) {
			return type.substring(pos+1);
		} else 
			return type;
	}

	protected void replaceWithBetterMatch(List<Entry<Double, PPEInstanceType>> currentRanked, List<String> candidates, List<PPEInstanceType> types, double prevBestFit) {
		candidates = candidates.stream().map(String::toLowerCase).distinct().toList();
		AtomicDouble bestFit = new AtomicDouble(prevBestFit);		
		candidates.stream().forEach(str -> {
			var rankedTypes = OclxContentProposalProvider.getSimilaritySortedTypes(types, str);
			if (rankedTypes.get(0).getKey() > bestFit.get()) {
				currentRanked.clear();
				currentRanked.addAll(rankedTypes);
				bestFit.set(rankedTypes.get(0).getKey());
			}
		});
		
	}
	
	
	protected String getTransformedFQN(PPEInstanceType type) {
		var fqn = type.getFullyQualifiedName();
		if (fqn.startsWith("/"))
			return fqn.substring(1);
		else
			return fqn;
	}
	
	// only need to add actual edit and the title
	private Entry<CodeAction, ArrayList<TextEdit>> prepareSkeletonCodeAction() {
		var edit = new WorkspaceEdit();
		var textEdits = new ArrayList<TextEdit>();
		edit.getChanges().put(resource.getURI().toString(), textEdits);
					
		var action = new CodeAction();
		action.setKind(CodeActionKind.QuickFix);		
		action.setDiagnostics(List.of(diagnostics));
		action.setEdit(edit);
		return new AbstractMap.SimpleEntry<>(action, textEdits);
	}
	
}
