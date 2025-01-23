package at.jku.isse.ide.assistance;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

import at.jku.isse.oclx.BinaryOperator;
import at.jku.isse.oclx.BooleanOperator;
import at.jku.isse.oclx.Constraint;
import at.jku.isse.oclx.Exp;
import at.jku.isse.oclx.InfixExp;
import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.IteratorVarDeclaration;
import at.jku.isse.oclx.MathOperator;
import at.jku.isse.oclx.MethodCallExp;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.NestedExp;
import at.jku.isse.oclx.OclxPackage;
import at.jku.isse.oclx.PrefixExp;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.TemporalExp;
import at.jku.isse.oclx.TriggeredTemporalExp;
import at.jku.isse.oclx.TypeCallExp;
import at.jku.isse.oclx.UnaryTemporalExp;
import at.jku.isse.oclx.VarDeclaration;
import at.jku.isse.oclx.VarReference;
import at.jku.isse.passiveprocessengine.core.BuildInType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.CARDINALITIES;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.PPEPropertyType;
import at.jku.isse.services.OCLXGrammarAccess;
import at.jku.isse.validation.ElementToTypeMap;
import at.jku.isse.validation.ElementToTypeMap.TypeAndCardinality;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;

public class TypeExtractor {
	@Inject
	private SchemaRegistry schemaReg;
	@Inject
	private MethodRegistry methodReg;
	@Inject 
	private OCLXGrammarAccess grammarAccess;
	
	public TypeExtractor() {
	}
	
	
	public Optional<ElementToTypeMap> extractElementToTypeMap(EObject eobject) {
		Optional<Constraint> optRoot = OclxASTUtils.getRootConstraint(eobject);
		return optRoot.flatMap(root -> {
			Optional<PPEInstanceType> optCtx = this.resolveContext(root);
			return optCtx.flatMap(ctx -> {
				ElementToTypeMap elementToTypeMap = new ElementToTypeMap(ctx);
				this.fillTypeMapAndReturnCurrent(root.getExpression(), elementToTypeMap);
				return Optional.of(elementToTypeMap);
			});
		});
	}
	
	//IMPORTANT: this contains almost exactly the same logic as OCLXValidator.java sync any changes with that class
	public TypeAndCardinality fillTypeMapAndReturnCurrent(Exp exp, ElementToTypeMap elementToTypeMap) {
		if (exp == null) return null;
		TypeAndCardinality currentType = null;
		if (exp instanceof VarReference) { 	//  getting type of var
			VarReference varRef = (VarReference)exp;
			EObject varDecl = varRef.getRef();
			currentType = elementToTypeMap.getReturnTypeMap().get(varDecl);
			
		} else if (exp instanceof SelfExp) { 
			currentType = elementToTypeMap.getSelfType();
		} else
			if (exp instanceof PrefixExp) {
			PrefixExp prefixExp = (PrefixExp)exp;
			currentType = fillTypeMapAndReturnCurrent(prefixExp.getExpression(), elementToTypeMap);
		} else if (exp instanceof NestedExp) {
			currentType = fillTypeMapAndReturnCurrent(((NestedExp) exp).getSource(), elementToTypeMap);
		} else if (exp instanceof InfixExp) {
			InfixExp infixExp = (InfixExp)exp;
			if (infixExp.getExpressions().size() > 1) {
				infixExp.getExpressions().forEach(childExp -> fillTypeMapAndReturnCurrent(childExp, elementToTypeMap));
				// return type depends on Binary Operator
				BinaryOperator op = infixExp.getOperators().get(0);
				if (op instanceof BooleanOperator) {
					currentType = new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
				} else if (op instanceof MathOperator) {
					currentType = new TypeAndCardinality(BuildInType.FLOAT, CARDINALITIES.SINGLE);
				} else {
					currentType = new TypeAndCardinality(BuildInType.METATYPE, CARDINALITIES.SINGLE); //should not happen
				}
			} else {
				currentType = fillTypeMapAndReturnCurrent(infixExp.getExpressions().get(0), elementToTypeMap);
			} 
		} else if (exp instanceof TemporalExp) {
			currentType = checkTemporalExpressionNavigation((TemporalExp) exp, elementToTypeMap);
		}
		
		
		elementToTypeMap.getReturnTypeMap().put(exp, currentType);
		// as we also want to assign navigation operators the type of the preceding var/method/property
		int methodPos = 0;
		for (MethodExp methodExp : exp.getMethods()) {
			// if there is a methodExp, there must be a navigation operator first from the preceding self/varref
			if (currentType != null) {
				elementToTypeMap.getReturnTypeMap().put(exp.getNav().get(methodPos), currentType);
			} // else there is an error using unknown property or reference, then we cant infer the type, ignore.
			// prep for next round/method
			methodPos++;
			if (methodExp instanceof IteratorExp) {
				IteratorExp iterExp = (IteratorExp)methodExp;
				Optional<IteratorVarDeclaration> varOpt = Optional.ofNullable(iterExp.getItervar());
				if (varOpt.isPresent()) {
					IteratorVarDeclaration varDec = varOpt.get();
					VarDeclaration varDecl = varDec.getName();
					if (elementToTypeMap.getReturnTypeMap().containsKey(varDecl)) {
						// ignoring error, dealt with via Validator feedback
					} else {
						if (varDec.getType() != null) {
							String typeName = varDec.getType().getName();
							//we dont support iterating over Collections of Collections, hence a single value
							Optional<PPEInstanceType> optType = resolveFullyQualifiedType(typeName);
							if (optType.isPresent()) {
								elementToTypeMap.getReturnTypeMap().put(varDecl, new TypeAndCardinality(optType.get(), CARDINALITIES.SINGLE));
								elementToTypeMap.getReturnTypeMap().put(varDec, new TypeAndCardinality(optType.get(), CARDINALITIES.SINGLE));
							} else { // we reuse the collections base type
								elementToTypeMap.tryAddToReturnTypeMap(varDecl, currentType, CARDINALITIES.SINGLE);
								elementToTypeMap.tryAddToReturnTypeMap(varDec, currentType, CARDINALITIES.SINGLE);
							}
						} else {
							// use type of property on which iterator is called on							
							elementToTypeMap.tryAddToReturnTypeMap(varDecl, currentType, CARDINALITIES.SINGLE);
							elementToTypeMap.tryAddToReturnTypeMap(varDec, currentType, CARDINALITIES.SINGLE);			
						}
					}
				}
				// we update the currentType with the return type from the iterator
				currentType = fillTypeMapAndReturnCurrent(iterExp.getBody(), elementToTypeMap);
				elementToTypeMap.getReturnTypeMap().put(methodExp, currentType);
			} else if (methodExp instanceof MethodCallExp) {
				MethodCallExp callExp = (MethodCallExp)methodExp;
				// we update the currentType
				if (currentType != null) {
					currentType = checkNextNavigation(currentType, callExp);
					elementToTypeMap.getReturnTypeMap().put(methodExp, currentType);
				}
				if (callExp.getArgs() != null) {
					callExp.getArgs().getOperators().stream() 
						.forEach(childExp -> fillTypeMapAndReturnCurrent(childExp,  elementToTypeMap));
				}
			} else if (methodExp instanceof PropertyAccessExp) {
				// we update the currentType
				PropertyAccessExp propExp = (PropertyAccessExp)methodExp;
				if (currentType != null)
					currentType = processPropertyAccess(currentType.getType(), propExp, elementToTypeMap);
			} else if (methodExp instanceof TypeCallExp typeCallExp ) {
				if (typeCallExp.getType() != null) {
					//we dont support typing to Collections
					String typeName = typeCallExp.getType().getName();
					Optional<PPEInstanceType> optType = resolveFullyQualifiedType(typeName);
					if (optType.isEmpty()) {
						return null;
					} else {
						var opName = typeCallExp.getName();
						if (opName.equals(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0().getValue())) {
							return new TypeAndCardinality(optType.get(), CARDINALITIES.SINGLE);
						} else
						if (opName.equals(grammarAccess.getTypeCallAccess().getNameIsKindOfKeyword_0_0_2().getValue()) 
								|| opName.equals(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1().getValue()) 
								) {
							return new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
						} 						
						return null;
					}
				} else {
					return null;
				}
			}
		}
		// if there is a trailing navigation --> also set that return type of that:
		if (exp.getNav().size() > exp.getMethods().size()) {
			elementToTypeMap.getReturnTypeMap().put(exp.getNav().get(methodPos), currentType);
		}
		
		// returns the last type of an expression/navigation chain,
		return currentType;
	}
	
	private TypeAndCardinality checkTemporalExpressionNavigation(TemporalExp exp, ElementToTypeMap elementToTypeMap) {
		if (exp instanceof UnaryTemporalExp) {
			fillTypeMapAndReturnCurrent( ((UnaryTemporalExp)exp).getExp(), elementToTypeMap);
		} else if (exp instanceof TriggeredTemporalExp) {
			TriggeredTemporalExp trigExp = (TriggeredTemporalExp)exp;
			fillTypeMapAndReturnCurrent(trigExp.getA(), elementToTypeMap);
			fillTypeMapAndReturnCurrent(trigExp.getB(), elementToTypeMap);
		}
		return new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE); 
	}
	
	private TypeAndCardinality processPropertyAccess(PPEInstanceType currentType, PropertyAccessExp expression, ElementToTypeMap elementToTypeMap) {
		if (currentType == null)
			return null;
		String method = expression.getName();
		if (!currentType.hasPropertyType(method)) {
			return null;
		} else {
			PPEPropertyType pType = currentType.getPropertyType(method);
			PPEInstanceType returnType = pType.getInstanceType();
			TypeAndCardinality typeAndCard = new TypeAndCardinality(returnType, pType.getCardinality());
			elementToTypeMap.getReturnTypeMap().put(expression, typeAndCard);
			elementToTypeMap.getPropertyAccessMap().put(expression, currentType.getPropertyType(method));
			return typeAndCard;
		}
	}
	
	private TypeAndCardinality checkNextNavigation(TypeAndCardinality currentTypeAndCardinality, MethodCallExp expression) {
		
			var returnType = methodReg.getReturnTypeForMethodName(expression.getName(), currentTypeAndCardinality.getType());			
			return returnType;
		
	}
	
	
	
	public Optional<PPEInstanceType> resolveContext(Constraint constraint) {
		if (constraint.getContext() != null) {// ignore the case we didnt define the context yet
			String ctxType = constraint.getContext().getName();
			return resolveType(ctxType);
		}
		return Optional.empty();
	}
	
	public Optional<PPEInstanceType> resolveType(String typeName) {
		return schemaReg.getAllNonDeletedInstanceTypes().stream()
				.filter(type -> type.getName().equalsIgnoreCase(typeName))
				.findFirst();
	}
	
	public Optional<PPEInstanceType> resolveFullyQualifiedType(String fqnTypeName) {
		return schemaReg.findNonDeletedInstanceTypeByFQN(fqnTypeName);
	}
	

}