package at.jku.isse.ide.assistance

import com.google.inject.Inject
import java.util.Collections
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionKind
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import at.jku.isse.validation.OCLXValidator
import at.jku.isse.oclx.PropertyAccessExp
import at.jku.isse.oclx.SelfExp
import at.jku.isse.oclx.MethodCallExp
import at.jku.isse.oclx.VarReference
import at.jku.isse.passiveprocessengine.core.PPEInstanceType
import org.eclipse.emf.ecore.EObject
import at.jku.isse.oclx.Constraint
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.Position
import at.jku.isse.validation.MethodRegistry
import at.jku.isse.oclx.MethodExp
import at.jku.isse.oclx.IteratorExp
import at.jku.isse.validation.OclxASTUtils
import at.jku.isse.validation.TypeExtractor
import at.jku.isse.oclx.IteratorVarDeclaration
import at.jku.isse.passiveprocessengine.core.SchemaRegistry

class QuickFixCodeActionService implements ICodeActionService2 {
	
	@Inject
	TypeExtractor typeExtractor
	@Inject
	EObjectAtOffsetHelper eObjectAtOffsetHelper;
	@Inject 
	MethodRegistry methodReg;
	@Inject 
	SchemaRegistry schemaReg;
	
	DuplicateVariableQuickfixer duplicateFixer = new DuplicateVariableQuickfixer();
	SyntaxErrorFixer syntaxFixer = new SyntaxErrorFixer();
	
	override getCodeActions(Options options) {
		
		var document = options.document
		val params = options.codeActionParams
		val result = <CodeAction>newArrayList
		var resource = options.resource as XtextResource
		
		if (document === null) { // then resource most likely also null
					//val content = getFileContent(params.textDocument.uri)
					//System.out.println(content)
					//document = new Document(1, content)
			val lsCtx = options.languageServerAccess.doSyncRead(params.textDocument.uri, [lsCtx |  return lsCtx] )
			document = lsCtx.document
			resource = lsCtx.resource as XtextResource		
		}
		if (document !== null) {
			for (d : params.context.diagnostics) {
				val stringToRepair = document.getSubstring(d.range)
				val offset = document.getOffSet(d.range.start)
				val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
				if (d.code.get == org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC) {
					var repair =  syntaxFixer.trySyntaxFix(modelElement, stringToRepair, d, resource);
					if (repair !== null) {
						result += repair
					}
				} else if (d.code.get == OCLXValidator.UNKNOWN_TYPE) {					
					var repair =  new UnknownTypeQuickfixer(schemaReg).createReplaceWithMostSimilarTypeQuickFix(modelElement, stringToRepair, d, resource);
					if (repair !== null) {
						result += repair
					}
				} else if (d.code.get == OCLXValidator.DUPLICATE_VAR_NAME) {					
					var iterDecl = modelElement.eContainer;
					if (iterDecl instanceof IteratorVarDeclaration){
						result += duplicateFixer.createQuickfix(iterDecl, d, resource);	
					}
				} else if (d.code.get == OCLXValidator.UNKNOWN_PROPERTY) {																	
					generatorCodeActionReplaceWithSubtype(d, resource, offset, stringToRepair, result)
					val choices = findMostSimilarProperties(stringToRepair, resource, offset)
					if (choices.size() > 0) {
						val newProp = choices.get(0)
						generateCodeActionReplaceWithMostSimilarProperty(d, resource, newProp, result)
					}			
				} else if (d.code.get == OCLXValidator.UNKNOWN_OPERATION) {
					var choices = findMostSimilarOperations(resource, offset, stringToRepair)
					if (choices.size() > 0) {
						val newOp = choices.get(0)
						generateCodeActionReplaceWithMostSimilarOperation(d, resource, newOp, result)
					}
				}
			}
		
		}
		return result.map[Either.forRight(it)]
	}

	def ILanguageServerAccess.Context process(ILanguageServerAccess.Context ctx) {
		return ctx
	}

	def generatorCodeActionReplaceWithSubtype(Diagnostic d, XtextResource resource, int offset, String partialPropertyName, List<CodeAction> result) {
		val subclasses = findSubclassWithProperty(partialPropertyName, resource, offset)
		if (subclasses.isEmpty()) return		
		val selfAndPrecedingElement = getPrecedingElement(resource, offset)
		dispatchByPreceedingElement(selfAndPrecedingElement.get(0), selfAndPrecedingElement.get(1)
									, d, resource, subclasses, partialPropertyName, result
		)
	}

	protected def findSubclassWithProperty(String propertyName, XtextResource resource, int offset) {
		var completeWithType = resolvePropertyAccessOrMethodResourceToType(resource, offset)
		if (completeWithType !== null) {
			return completeWithType.type.allSubtypesRecursively.stream().filter(subtype | subtype.hasPropertyType(propertyName)).toList()
		}
		return Collections.emptyList()
	}


	protected def getPrecedingElement(XtextResource resource, int offset) {
		val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset)
		val varOrSelfContainer = modelElement.eContainer
		if (varOrSelfContainer instanceof SelfExp) {
			val thisIndex = varOrSelfContainer.methods.indexOf(modelElement)
			if (thisIndex > 0) return List.of(modelElement, varOrSelfContainer.methods.get(thisIndex-1))
			else return List.of(modelElement, varOrSelfContainer)
		} else if (varOrSelfContainer instanceof VarReference) { 
			val thisIndex = varOrSelfContainer.methods.indexOf(modelElement)
			if (thisIndex > 0) return List.of(modelElement, varOrSelfContainer.methods.get(thisIndex-1))
			else return List.of(modelElement, varOrSelfContainer)
		}
	}

	protected def dispatchByPreceedingElement(EObject affectedElement, EObject precedingElement, Diagnostic d, XtextResource resource
											, List<PPEInstanceType> subclasses, String propertyName, List<CodeAction> result) {
		
		val subclass = subclasses.get(0);
		if (precedingElement instanceof SelfExp) {
			// we cant really suggest a cast of context, rather make context more precise
				val ctx = getContext(precedingElement);
						result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Use '"+subclass.name+"' as a more specialized context element"
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = getRangeOfElement(ctx)
								newText = subclass.name
							])
						]
					]
		} else
		if (precedingElement instanceof PropertyAccessExp) {
			// cast the property
			result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Access property '"+propertyName+"' in the more specialized type '"+subclass.name+"' "
						diagnostics = #[d]
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = d.range
								newText = "asType(<"+getTransformedFQN(subclass)+">)."+propertyName
							])
						]
					]
		} else
		if (precedingElement instanceof MethodCallExp) {
			// a method that returns a single instance can only happen over collection --> need to filter collection then cast object
			// get range of methodcall,
			val methodRange = getRangeOfElement(precedingElement);
			// insert select
			if (methodRange !== null) {
				result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Add a filter for instances of the more specialize type '"+subclass.name+"' before method/operation call '"+precedingElement.name+"'";
						diagnostics = #[d]
						val pos = new Position(methodRange.start.line, methodRange.start.character-1)  // start and end are equal as we want to insert, shifted by 1: the . navigation character
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = new Range(pos, pos)
								newText = "->select(object | object.isKindOf(<"+getTransformedFQN(subclass)+">))"
							], new TextEdit => [
								range = d.range
								newText = "asType(<"+getTransformedFQN(subclass)+">)."+propertyName
							])
						]
					]			
			}
		} else
		if (precedingElement instanceof VarReference) {
			val refName = precedingElement.ref.name;			
			// find most fitting type to refname as refname often conveys meaning
			val bestFitType = UnknownTypeQuickfixer.findMostSimilarType(refName, schemaReg).get();									
			val iter = getIterator(precedingElement, refName);
			if (iter !== null) {
				val iterRange = getRangeOfElement(iter);
				result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Add a filter for instances of the more specialize subtype '"+bestFitType.name+"' before iterator"
						diagnostics = #[d]
						val pos = new Position(iterRange.start.line, iterRange.start.character-2)  // start and end are equal as we want to insert, shifted by 2: the -> navigation characters
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = new Range(pos, pos) // start and end are equal as we want to insert
								newText = "->select("+refName+"Untyped | "+refName+"Untyped.isKindOf(<"+getTransformedFQN(bestFitType)+">))"
							], new TextEdit => [
								range = d.range
								newText = "asType(<"+getTransformedFQN(bestFitType)+">)."+propertyName
							])
						]
					]			
			}
		} else {
			System.out.println("ERROR in QuickFixCodeActionService: Unexpected preceding element: "+precedingElement.toString);
		}
	}
	


	static def Range getRangeOfElement(EObject exp) {
		if (exp === null) return null;
		val inode = NodeModelUtils.findActualNodeFor(exp)
		val startPos = inode.offset
		val startLine = inode.startLine-1 // we need zero based lines for Range
		val endPos = inode.endOffset
		val endLine = inode.endLine-1
		return new Range(new Position(startLine, startPos), new Position(endLine, endPos))
	}

	protected def EObject getContext(EObject exp) {
		if (exp === null) return null;
		if (exp instanceof Constraint) {
			val ctx = exp.context
			return ctx
		} else {
			return getContext(exp.eContainer)
		}
	}

	protected def EObject getIterator(EObject exp, String iterVarName) {
		if (exp === null) return null;
		if (exp instanceof IteratorExp) {
			val varName = exp.itervar.name.name
			if (varName.equals(iterVarName)) {
				return exp;
			} else { //another nested iterator
				return getIterator(exp.eContainer, iterVarName)
			}
		} else {
			return getIterator(exp.eContainer, iterVarName)
		}
	}

	protected def findMostSimilarProperties(String partialPropertyName, XtextResource resource, int offset) {
		var completeWithType = resolvePropertyAccessOrMethodResourceToType(resource, offset);
		if (completeWithType !== null) {
			val choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), partialPropertyName)
			return choices
		}
		return Collections.emptyList()
	}

	protected def resolvePropertyAccessOrMethodResourceToType(XtextResource resource, int offset) {
		val modelElement = eObjectAtOffsetHelper.resolveElementAt(resource, offset)
		if (modelElement !== null) {
			val el2TypeMap = typeExtractor.extractElementToTypeMap(modelElement).get()
			if (modelElement instanceof MethodExp) {
				val prevNav = OclxASTUtils.findPrecedingOperatorFor(modelElement);
				if (prevNav !== null) {
					val completeWithType = el2TypeMap.getReturnTypeMap().get(prevNav);
					return completeWithType;
				}
			}
		}
		return null;
	}
	
	protected def getTransformedFQN(PPEInstanceType type) {
		var fqn = type.fullyQualifiedName
		if (fqn.startsWith("/"))
			return fqn.substring(1)
		else
			return fqn
	}

	def generateCodeActionReplaceWithMostSimilarProperty(Diagnostic d, XtextResource resource, String newProp, List<CodeAction> result) {	
		result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Replace with most similar property '"+newProp+"' "
						diagnostics = #[d]
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = d.range
								newText = newProp
							])
						]
					]
	}
	
	protected def findMostSimilarOperations(XtextResource resource, int offset, String partialOpName) {
		var inputOfType = resolvePropertyAccessOrMethodResourceToType(resource, offset);
		if (inputOfType !== null) {
			val choices = OclxContentProposalProvider.getSimilaritySortedMethods(methodReg, partialOpName, inputOfType)
			return choices
		}
		return Collections.emptyList()
	}
	
	def generateCodeActionReplaceWithMostSimilarOperation(Diagnostic d, XtextResource resource, String newMethod, List<CodeAction> result) {	
		result += new CodeAction => [
						kind = CodeActionKind.QuickFix
						title = "Replace with most similar operation '"+newMethod+"' "
						diagnostics = #[d]
						edit = new WorkspaceEdit() => [
							addTextEdit(resource.URI, new TextEdit => [
								range = d.range
								newText = newMethod
							])
						]
					]
	}
	
	protected def addTextEdit(WorkspaceEdit edit, URI uri, TextEdit... textEdit) {		
		//map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
		//edit.changes.computeIfAbsent(uri.toString, k -> new LinkedList<>()).add(textEdit);
		edit.changes.put(uri.toString, textEdit)
	}
		
}