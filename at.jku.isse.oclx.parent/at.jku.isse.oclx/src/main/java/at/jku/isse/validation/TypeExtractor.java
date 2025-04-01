package at.jku.isse.validation;

import java.util.AbstractMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;

import com.google.inject.Inject;

import at.jku.isse.oclx.BinaryOperator;
import at.jku.isse.oclx.BooleanLiteralExp;
import at.jku.isse.oclx.BooleanOperator;
import at.jku.isse.oclx.Constraint;
import at.jku.isse.oclx.Exp;
import at.jku.isse.oclx.FloatLiteralExp;
import at.jku.isse.oclx.InfixExp;
import at.jku.isse.oclx.IntLiteralExp;
import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.IteratorVarDeclaration;
import at.jku.isse.oclx.MathOperator;
import at.jku.isse.oclx.MethodCallExp;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.NestedExp;
import at.jku.isse.oclx.OclxPackage;
import at.jku.isse.oclx.PrefixExp;
import at.jku.isse.oclx.PrimitiveLiteralExp;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.StringLiteralExp;
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
import at.jku.isse.validation.ElementToTypeMap.TypeAndCardinality;
import lombok.extern.slf4j.Slf4j;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;

@Slf4j
public class TypeExtractor {

	@Inject
	private SchemaRegistry schemaReg;
	@Inject
	private MethodRegistry methodReg;
	@Inject 
	private OCLXGrammarAccess grammarAccess;	
	@Inject
	private ErrorCollector errorCollector;
	
	public TypeExtractor() {
	}
	
	public TypeExtractor(SchemaRegistry schemaReg, MethodRegistry methodReg, OCLXGrammarAccess grammarAccess, ErrorCollector errorCollector) {
		super();
		this.schemaReg = schemaReg;
		this.methodReg = methodReg;
		this.grammarAccess = grammarAccess;
		this.errorCollector = errorCollector;
	}
	
	public Optional<ElementToTypeMap> extractElementToTypeMap(EObject eobject) {
		Optional<Constraint> optRoot = OclxASTUtils.getRootConstraint(eobject);
		return optRoot.flatMap(root -> {
			Optional<PPEInstanceType> optCtx = this.resolveContext(root);
			return optCtx.flatMap(ctx -> {
				ElementToTypeMap elementToTypeMap = new ElementToTypeMap(ctx);
				this.checkExpressionForNavigationCorrectness(root.getExpression(), elementToTypeMap);
				return Optional.of(elementToTypeMap);
			});
		});
	}
	
	public TypeAndCardinality checkExpressionForNavigationCorrectness(Exp exp, ElementToTypeMap elementToTypeMap) {
		if (exp == null) return null;
		
		TypeAndCardinality currentTypeAndCardinality = null;
		
		if (exp instanceof VarReference varRef) { 	//  getting type of var
			currentTypeAndCardinality = processVarReference(elementToTypeMap, varRef);						
		} else if (exp instanceof SelfExp) { 
			currentTypeAndCardinality = elementToTypeMap.getSelfType();
		} else
		if (exp instanceof PrefixExp prefixExp) {
			currentTypeAndCardinality = processPrefixExp(elementToTypeMap, prefixExp);
		} else if (exp instanceof NestedExp nestedExp) {
			currentTypeAndCardinality = checkExpressionForNavigationCorrectness(nestedExp.getSource(), elementToTypeMap);
		} else if (exp instanceof InfixExp infixExp) {			
			currentTypeAndCardinality = processInfixExp(elementToTypeMap, infixExp);						
		} else if (exp instanceof TemporalExp) {
			currentTypeAndCardinality = checkTemporalExpressionNavigation((TemporalExp) exp, elementToTypeMap);
		} else if (exp instanceof PrimitiveLiteralExp primExp) {	
			currentTypeAndCardinality = processPrimitiveLiteralExp(primExp);
		}
		
		if (currentTypeAndCardinality == null) { // no point in continuing as once we cannot establish it here, we cannot infer much further into the expression.
			return null;
		}
		elementToTypeMap.getReturnTypeMap().put(exp, currentTypeAndCardinality);	
		// as we also want to assign navigation operators the type of the preceding var/method/property
		int methodPos = 0;		
		for (MethodExp methodExp : exp.getMethods()) {
			log.trace("Traversing for methodCheck: "+methodExp);
			// if there is a methodExp, there must be a navigation operator first from the preceding self/varref			
			elementToTypeMap.getReturnTypeMap().put(exp.getNav().get(methodPos), currentTypeAndCardinality);			
			// prep for next round/method
			methodPos++;
			if (methodExp instanceof IteratorExp iterExp) {
				currentTypeAndCardinality = processIteratorExp(elementToTypeMap, currentTypeAndCardinality,
						iterExp);
			} else if (methodExp instanceof MethodCallExp callExp) {
				currentTypeAndCardinality = processMethodCallExp(elementToTypeMap,
						currentTypeAndCardinality, callExp);															
			} else if (methodExp instanceof PropertyAccessExp propExp) {
				currentTypeAndCardinality = processPropertyAccessExp(currentTypeAndCardinality, propExp, elementToTypeMap);												
			} else if (methodExp instanceof TypeCallExp typeCallExp ) {
				currentTypeAndCardinality = processTypeCallExp(typeCallExp, elementToTypeMap);					
			}
			// abort loop if we can no longer establish type and cardinality
			if (currentTypeAndCardinality == null) { // no point in continuing as once we cannot establish it here, we cannot infer much further into the expression.
				return null;
			}
		}
		// if there is a trailing navigation --> also set that return type of that:
		if (exp.getNav().size() > exp.getMethods().size()) {
			elementToTypeMap.getReturnTypeMap().put(exp.getNav().get(methodPos), currentTypeAndCardinality);
		}		
		// returns the last type of an expression/navigation chain,
		return currentTypeAndCardinality;
	}

	private TypeAndCardinality processVarReference(ElementToTypeMap elementToTypeMap, VarReference varRef) {		
		//String varName = varRef.getRef().getName();
		//currentTypeAndCardinality = new TypeAndCardinality(varTypeMap.get(varName), varCardinalityMap.get(varName));						
		EObject varDecl = varRef.getRef();
		var currentTypeAndCardinality = elementToTypeMap.getReturnTypeMap().get(varDecl);
		if (currentTypeAndCardinality != null)
			log.trace(String.format("Setting current context type %s via var %s ",currentTypeAndCardinality.getType().getName(), varRef.getRef().getName()));
		else
			log.trace(String.format("Could not set next context type for var %s ", varRef.getRef().getName()));
		return currentTypeAndCardinality;
	}
	
	private TypeAndCardinality processPrefixExp(ElementToTypeMap elementToTypeMap, PrefixExp prefixExp) {
		TypeAndCardinality currentTypeAndCardinality;
		currentTypeAndCardinality = checkExpressionForNavigationCorrectness(prefixExp.getExpression(), elementToTypeMap); 
		if (prefixExp.getOperator().getName().equals(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1().getValue())) {
			// 'not' operator
			if (currentTypeAndCardinality != null // no error further inwards, that needs to be fixed first
					&& currentTypeAndCardinality.getType() != BuildInType.BOOLEAN) {
				var type = currentTypeAndCardinality != null ? currentTypeAndCardinality.getType() : "null";
				errorCollector.error(String.format(" Expression prefixed with 'not' operator requires Boolean return type but found '%s' ", type)
					, prefixExp, OclxPackage.Literals.PREFIX_EXP__EXPRESSION, OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
			} 
			return new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE); // return type is nevertheless always a single boolean
		} else // '-' operator
		return currentTypeAndCardinality;
	}
	
	private TypeAndCardinality processInfixExp(ElementToTypeMap elementToTypeMap, InfixExp infixExp) {
		TypeAndCardinality currentTypeAndCardinality;
		if (infixExp.getExpressions().size() > 1) {
			BinaryOperator op = infixExp.getOperators().get(0);
			boolean isBooleanOp = isBooleanOperator(op);
			boolean isMathOp = isMathOperatpr(op);
			List<TypeAndCardinality> returnTypes = infixExp.getExpressions().stream()
					.map(childExp -> new AbstractMap.SimpleEntry<Exp, TypeAndCardinality>(childExp, checkExpressionForNavigationCorrectness(childExp, elementToTypeMap)))
					.filter(Objects::nonNull) // in presence of errors, ignore null responses and wait for fixing
					.filter(entry -> entry.getValue() != null && entry.getValue().getType() != null && entry.getValue().getCardinality() != null) // also ignore when type or card is null, as also then we cant check anything below
					.map(entry -> {
						if (isBooleanOp && entry.getValue().getType() != BuildInType.BOOLEAN && entry.getValue().getCardinality() != CARDINALITIES.SINGLE) {
							errorCollector.error(String.format(" Boolean Operator requires nested expression(s) to return single Boolean but found '%s' ", entry.getValue())
									, infixExp, OclxPackage.Literals.INFIX_EXP__EXPRESSIONS, OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
						} else if (isMathOp 
								&& ( entry.getValue().getType() != BuildInType.FLOAT && entry.getValue().getType() != BuildInType.INTEGER && entry.getValue().getCardinality() != CARDINALITIES.SINGLE) //neither float nor integer nor SINGLE
								) {
							errorCollector.error(String.format(" Math Operator requires nested expression(s) to return single FLOAT or INTEGER but found '%s' ", entry.getValue())
									, infixExp, OclxPackage.Literals.INFIX_EXP__EXPRESSIONS, OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
						}
						return entry.getValue();
					})
					.collect(Collectors.toList());
			// return type depends on Binary Operator, we only check first operator 
			if (op instanceof BooleanOperator) {
				currentTypeAndCardinality = new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);					
			} else if (op instanceof MathOperator) {
				currentTypeAndCardinality = new TypeAndCardinality(BuildInType.FLOAT, CARDINALITIES.SINGLE);
				//TODO: check simultaneous use of math and logic operators!
			} else {
				currentTypeAndCardinality = new TypeAndCardinality(BuildInType.METATYPE, CARDINALITIES.SINGLE);
				//should not happen
			}
		} else {
			currentTypeAndCardinality = checkExpressionForNavigationCorrectness(infixExp.getExpressions().get(0), elementToTypeMap);
		}
		return currentTypeAndCardinality;
	}	
	
	private TypeAndCardinality checkTemporalExpressionNavigation(TemporalExp exp, ElementToTypeMap elementToTypeMap) {				
		if (exp instanceof UnaryTemporalExp) {
			var returnType = checkExpressionForNavigationCorrectness(((UnaryTemporalExp)exp).getExp(), elementToTypeMap);
			if (returnType.getType() != BuildInType.BOOLEAN || returnType.getCardinality() != CARDINALITIES.SINGLE) {
				errorCollector.error(String.format(" Temporal Expression requires nested expression to return single Boolean but found '%s' ", returnType), 
						((UnaryTemporalExp)exp), OclxPackage.Literals.UNARY_TEMPORAL_EXP__EXP, OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
			}
		} else if (exp instanceof TriggeredTemporalExp) {
			TriggeredTemporalExp trigExp = (TriggeredTemporalExp)exp;
			var returnTypeA = checkExpressionForNavigationCorrectness(trigExp.getA(), elementToTypeMap);
			if (returnTypeA.getType() != BuildInType.BOOLEAN || returnTypeA.getCardinality() != CARDINALITIES.SINGLE) {
				errorCollector.error(String.format(" Temporal Expression requires nested expression(s) to return single Boolean but found '%s' ", returnTypeA)
						, trigExp, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A, OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
			}
			var returnTypeB =checkExpressionForNavigationCorrectness(trigExp.getB(), elementToTypeMap);
			if (returnTypeB.getType() != BuildInType.BOOLEAN || returnTypeB.getCardinality() != CARDINALITIES.SINGLE) {
				errorCollector.error(String.format(" Temporal Expression requires nested expression(s) to return single Boolean but found '%s' ", returnTypeB)
						, trigExp, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B, OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
			}
		}
		return new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
	}
	
	private TypeAndCardinality processPrimitiveLiteralExp(PrimitiveLiteralExp primExp) {
		if (primExp instanceof StringLiteralExp)
			return new TypeAndCardinality(BuildInType.STRING, CARDINALITIES.SINGLE);
		if (primExp instanceof IntLiteralExp)
			return new TypeAndCardinality(BuildInType.INTEGER, CARDINALITIES.SINGLE);
		if (primExp instanceof BooleanLiteralExp)
			return new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
		if (primExp instanceof FloatLiteralExp)
			return new TypeAndCardinality(BuildInType.FLOAT, CARDINALITIES.SINGLE);		
		return null;
	}
	
	private TypeAndCardinality processIteratorExp(ElementToTypeMap elementToTypeMap, TypeAndCardinality currentTypeAndCardinality,
			IteratorExp iterExp) {
		// check if iterator can be called on current input
		if (currentTypeAndCardinality == null || currentTypeAndCardinality.getCardinality().equals(CARDINALITIES.SINGLE)) {
			errorCollector.error(String.format("Iterator '%s' cannot be called on SINGLE input, requires SET, LIST, or COLLECTION", iterExp.getName().getName())
				, iterExp, OclxPackage.Literals.ITERATOR_EXP__NAME, OCLXValidator.INCOMPATIBLE_INPUT_TYPE);
		}
		
		Optional<IteratorVarDeclaration> varOpt = Optional.ofNullable(iterExp.getItervar());
		if (varOpt.isPresent()) {
			IteratorVarDeclaration varDec = varOpt.get();
			VarDeclaration varDecl = varDec.getName();
			String varName = varDecl.getName();
			if (elementToTypeMap.getReturnTypeMap().containsKey(varDecl)) {
				// ignoring
				//error("Variable already declared.", varDec, OclxPackage.Literals.ITERATOR_VAR_DECLARATION__NAME, DUPLICATE_VAR_NAME);
			} else {
				if (varDec.getType() != null) {
					String typeName = varDec.getType().getName();
					//we dont support iterating over Collections of Collections, hence a single value
					Optional<PPEInstanceType> optType = resolveFullyQualifiedType(typeName);
					if (optType.isPresent()) {
						log.trace(String.format("Adding new variable %s of type %s " ,varName, optType.get().getName()));
						elementToTypeMap.getReturnTypeMap().put(varDecl, new TypeAndCardinality(optType.get(), CARDINALITIES.SINGLE));
						elementToTypeMap.getReturnTypeMap().put(varDec, new TypeAndCardinality(optType.get(), CARDINALITIES.SINGLE));
					} else { // we reuse the collections base type
						errorCollector.error(String.format("Provided type '%s' is not a known InstanceType", typeName), varDec.getType(), OclxPackage.Literals.TYPE_EXP__NAME, OCLXValidator.UNKNOWN_TYPE);
						
						elementToTypeMap.tryAddToReturnTypeMap(varDecl, BuildInType.METATYPE, CARDINALITIES.SINGLE);
						elementToTypeMap.tryAddToReturnTypeMap(varDec, BuildInType.METATYPE, CARDINALITIES.SINGLE);
					}
				} else {
					// use type of property on which iterator is called on i.e, previous method/property access, otherwise checking var type leads to NPE					
					elementToTypeMap.tryAddToReturnTypeMap(varDecl, currentTypeAndCardinality.getType(), CARDINALITIES.SINGLE);
					elementToTypeMap.tryAddToReturnTypeMap(varDec, currentTypeAndCardinality.getType(), CARDINALITIES.SINGLE);			
				}
				
			}
		}
		// we update the currentType with the return type from the iterator
		var tempCurrentTypeAndCardinality = checkExpressionForNavigationCorrectness(iterExp.getBody(), elementToTypeMap);
		// now we need to override the cardinality based on the iterator type:
		var iterType = iterExp.getName().getName();
		if (iterType.equals(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2().getValue())) {
				currentTypeAndCardinality = new TypeAndCardinality(tempCurrentTypeAndCardinality.getType(), currentTypeAndCardinality.getCardinality()); // same cardinality, potentially different type
		} else if (iterType.equals(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3().getValue())
				|| iterType.equals(grammarAccess.getIteratorNameAccess().getNameSelectKeyword_0_4().getValue())
				) {
			currentTypeAndCardinality = new TypeAndCardinality(currentTypeAndCardinality.getType(), currentTypeAndCardinality.getCardinality()); // same cardinality, same type as we just filter
		} else if (iterType.equals(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1().getValue())
				|| iterType.equals(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0().getValue())) {
			currentTypeAndCardinality = new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
		}
		elementToTypeMap.getReturnTypeMap().put(iterExp, currentTypeAndCardinality);		
		return currentTypeAndCardinality;						
	}
	
	private TypeAndCardinality processMethodCallExp(ElementToTypeMap elementToTypeMap, TypeAndCardinality currentTypeAndCardinality,
			MethodCallExp callExp) {
		// we update the currentType
		if (currentTypeAndCardinality != null) {
			// if ANY return value, reuse current type (as this is then a collection accessor operation or collection transformation operation			
			var methodReturnType = methodReg.getReturnTypeForMethodName(callExp.getName(), currentTypeAndCardinality.getType());			
			if (methodReturnType == null) {
				errorCollector.error(String.format("'%s' is not a known operation/method ", callExp.getName())
						, callExp, OclxPackage.Literals.METHOD_CALL_EXP__NAME, OCLXValidator.UNKNOWN_OPERATION);
				return null;
			} else {
				// check if method can be called on current type (see ARL OperatorExpression)
				var isCompatibleType = methodReg.canMethodBeCalledOnType(callExp.getName(), currentTypeAndCardinality);		
				if (!isCompatibleType) {
					errorCollector.error(String.format("'%s' cannot be called on type '%s' of cardinality '%s' ", callExp.getName(), currentTypeAndCardinality.getType(), currentTypeAndCardinality.getCardinality())
							, callExp, OclxPackage.Literals.METHOD_CALL_EXP__NAME, OCLXValidator.INCOMPATIBLE_INPUT_TYPE);
				}
				// check if parameters are correct number
				var ops = methodReg.findOperationsForName(callExp.getName());
				var argsCount = callExp.getArgs() != null ? callExp.getArgs().getOperators().size() : 0;
				var hasEqualCount = ops.stream().anyMatch(op -> op.parameterTypes.size() == argsCount);
				if (!hasEqualCount) {
					errorCollector.error(String.format("'%s' does not accept '%s' parameters ", callExp.getName(), argsCount)
							, callExp, OclxPackage.Literals.METHOD_CALL_EXP__NAME, OCLXValidator.INCORRECT_PARAMETERS);
				}
			}								
			currentTypeAndCardinality = methodReturnType;
			log.trace("new current type via method: "+currentTypeAndCardinality.toString());
			elementToTypeMap.getReturnTypeMap().put(callExp, currentTypeAndCardinality);
		}
		if (callExp.getArgs() != null) {
			callExp.getArgs().getOperators().stream() 
				.forEach(childExp -> checkExpressionForNavigationCorrectness(childExp, elementToTypeMap));
		}
		return currentTypeAndCardinality;
	}
	
	private TypeAndCardinality processPropertyAccessExp(TypeAndCardinality currentTypeAndCardinality,
			PropertyAccessExp propExp, ElementToTypeMap elementToTypeMap) {
		if (currentTypeAndCardinality == null) return null;								
		var currentType = currentTypeAndCardinality.getType();
		if (currentType == null) return null;
		
		String method = propExp.getName();
		if (!currentType.hasPropertyType(method)) {
			errorCollector.error(String.format("'%s' is not a known property for InstanceType '%s'", method, currentType.getName() )
					, propExp, OclxPackage.Literals.PROPERTY_ACCESS_EXP__NAME, OCLXValidator.UNKNOWN_PROPERTY);
			return null;
		} else {
			PPEPropertyType pType = currentType.getPropertyType(method);
			PPEInstanceType returnType = pType.getInstanceType();
			currentTypeAndCardinality = new TypeAndCardinality(returnType, pType.getCardinality());
			elementToTypeMap.getReturnTypeMap().put(propExp, currentTypeAndCardinality);
			elementToTypeMap.getPropertyAccessMap().put(propExp, currentType.getPropertyType(method));		
		}				
		log.trace("new current type via property: "+currentTypeAndCardinality.toString());
		return currentTypeAndCardinality;
	}
	
	private TypeAndCardinality processTypeCallExp(TypeCallExp typeCallExp, ElementToTypeMap elementToTypeMap) {
		if (typeCallExp.getType() != null) {
			TypeAndCardinality currentTypeAndCardinality;
			
			//we dont support typing to Collections
			String typeName = typeCallExp.getType().getName();
			Optional<PPEInstanceType> optType = resolveFullyQualifiedType(typeName);			
			if (optType.isEmpty()) {
				errorCollector.error(String.format(" Provided type '%s' is not a known InstanceType", typeName)
						, typeCallExp.getType(), OclxPackage.Literals.TYPE_EXP__NAME, OCLXValidator.UNKNOWN_TYPE);
				return null;
			} else {
				var opName = typeCallExp.getName();
				if (opName.equals(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0().getValue())) {
					currentTypeAndCardinality = new TypeAndCardinality(optType.get(), CARDINALITIES.SINGLE);
				} else
				if (opName.equals(grammarAccess.getTypeCallAccess().getNameIsKindOfKeyword_0_0_2().getValue()) 
						|| opName.equals(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1().getValue()) 
						) {
					currentTypeAndCardinality = new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
				} else { 
					log.error("Missing TypeCall handling: "+opName);
					return null;
				}
			}
			elementToTypeMap.getReturnTypeMap().put(typeCallExp, currentTypeAndCardinality);
			return currentTypeAndCardinality;
			
		} else {
			errorCollector.error(String.format(" Operation '%s' is missing a type a parameter", typeCallExp.getName())
			, typeCallExp.getType(), OclxPackage.Literals.TYPE_EXP__NAME, OCLXValidator.MISSING_TYPE);
			return null;
		}		
	}
	
	private boolean isMathOperatpr(BinaryOperator op) {
		return (op instanceof MathOperator
				&& grammarAccess.getMathOperatorAccess().getOpAlternatives_0().getElements().stream() 
					.filter(Keyword.class::isInstance)
					.map(Keyword.class::cast)
					.map(keyword -> keyword.getValue())
					.anyMatch(keyword -> keyword.equals(op.getOp()) )
				);
	}



	private boolean isBooleanOperator(BinaryOperator op) {
		return (op instanceof BooleanOperator 
				&& ( 
					op.getOp().equals(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6().getValue() )
				|| op.getOp().equals(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7().getValue() )
				|| op.getOp().equals(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8().getValue() )
						)		
		) ;
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
	

	public static interface ErrorCollector {
		void error(String message, EObject source, EStructuralFeature feature, String code);
	}
	
	public static class NoOpErrorCollector implements ErrorCollector {

		@Override
		public void error(String message, EObject source, EStructuralFeature feature, String code) {			
		}
		
	}
	
}