/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse.validation;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

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
import at.jku.isse.oclx.VarReference;
import at.jku.isse.passiveprocessengine.core.BuildInType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.CARDINALITIES;
import at.jku.isse.services.OCLXGrammarAccess;
import at.jku.isse.validation.ElementToTypeMap.TypeAndCardinality;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class OCLXValidator extends AbstractOCLXValidator {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OCLXValidator.class);
	
	@Inject
	private OCLXGrammarAccess grammarAccess;
	@Inject
	protected SchemaRegistry schemaReg;
	@Inject 
	protected MethodRegistry methodReg;
	
	public static final String DUPLICATE_VAR_NAME = "duplicateVarName";
	public static final String UNKNOWN_PROPERTY = "unknownProperty";
	public static final String UNKNOWN_OPERATION = "unknownOperation";
	public static final String UNKNOWN_TYPE = "unknownType";
	public static final String MISSING_TYPE = "missingType";
	public static final String INCOMPATIBLE_RETURN_TYPE = "incompatibleReturnType";
	public static final String INCOMPATIBLE_INPUT_TYPE = "incompatibleInputType";
	
	
	@Check(CheckType.FAST)
	public void checkExistingContextType(Constraint constraint) {
		String context = constraint.getContext().getName();
		if (context == null) { 
			return;
		}
		Optional<PPEInstanceType> optType = resolveType(context);
		if (optType.isEmpty()) {
			error(String.format("Context refers to unknown InstanceType '%s'", context), constraint, OclxPackage.Literals.CONSTRAINT__CONTEXT, UNKNOWN_TYPE);
		} 
	}
	

	
	@Check(CheckType.FAST)
	public void checkVarDeclarationUniquePerConstraintAndVarUsageDeclaredBefore(Constraint constraint) {
		Set<String> varDeclarations = new HashSet<>();
		varDeclarations.add("self"); // already default declared variable, cannot be declared again
		checkVariables(constraint.getExpression(), varDeclarations);
	}
	
	
	//TODO: make this an object and track declaration context separate from all global vars
	private void checkVariables(Exp exp, Set<String> declaredVars) {
		if (exp == null) return;
		log.trace(exp.toString());
		
		// VarExp and SelfExp dont need to be checked
		if (exp instanceof PrefixExp) {
			PrefixExp prefixExp = (PrefixExp)exp;
			checkVariables(prefixExp.getExpression() , declaredVars);
		} else if (exp instanceof NestedExp) {
			checkVariables(((NestedExp) exp).getSource() , declaredVars);
		} else if (exp instanceof InfixExp) {
			InfixExp infixExp = (InfixExp)exp;
			infixExp.getExpressions().forEach(childExp -> checkVariables(childExp, declaredVars));
		} else if (exp instanceof TemporalExp) {
			checkTemporalExpression((TemporalExp) exp, declaredVars);
		}
		// for any traversing/navigating:	
		exp.getMethods().forEach(methodExp -> {	
			log.trace("Traversing: "+methodExp);
			if (methodExp instanceof IteratorExp) {
				IteratorExp iterExp = (IteratorExp)methodExp;
				Optional<IteratorVarDeclaration> varOpt = Optional.ofNullable(iterExp.getItervar());
				varOpt.ifPresent(varDec -> {
					String varName = varDec.getName().getName();
					if (declaredVars.contains(varName)) {
						error("Variable already declared.", varDec, OclxPackage.Literals.ITERATOR_VAR_DECLARATION__NAME, DUPLICATE_VAR_NAME);
					} else {
						declaredVars.add(varName);
						log.trace("Declared new Variable: "+varName);
					}
				});
				// check body of an iteration
				checkVariables(iterExp.getBody(), declaredVars);
			} else if (methodExp instanceof MethodCallExp) {
				MethodCallExp callExp = (MethodCallExp)methodExp;
				if (callExp.getArgs() != null) {
					callExp.getArgs().getOperators().stream() 
					.forEach(childExp -> checkVariables(childExp, declaredVars));
				}
			} //no need to check PropertyAccessExp
		});
	}
	
	private void checkTemporalExpression(TemporalExp exp, Set<String> declaredVars) {
		if (exp instanceof UnaryTemporalExp) {
			checkVariables(((UnaryTemporalExp)exp).getExp(), declaredVars);
		} else if (exp instanceof TriggeredTemporalExp) {
			TriggeredTemporalExp trigExp = (TriggeredTemporalExp)exp;
			checkVariables(trigExp.getA(), declaredVars);
			checkVariables(trigExp.getB(), declaredVars);
		}
	}
	
	@Check(CheckType.FAST)
	public void checkTypesAndCardinalityMatches(Constraint constraint) {
		String context = constraint.getContext().getName();
		if (context == null) { 
			return;
		}
		Optional<PPEInstanceType> optType = resolveType(context);
		if (optType.isPresent()) {
			Map<String, PPEInstanceType> var2type = new HashMap<>();
			var2type.put("self", optType.get());
			Map<String, CARDINALITIES> var2Cardinality = new HashMap<>();
			var2Cardinality.put("self", CARDINALITIES.SINGLE);
			// for each navigation we check if the current type allows that method or property navigation
			checkExpressionForNavigationCorrectness(constraint.getExpression(), var2type, var2Cardinality);
		}
	}
	
	//IMPORTANT: this contains almost exactly the same logic as TypeExtractor.java sync any changes with that class
	private TypeAndCardinality checkExpressionForNavigationCorrectness(Exp exp, Map<String, PPEInstanceType> varTypeMap, Map<String, CARDINALITIES> varCardinalityMap) {
		if (exp == null) return null;
		log.trace(exp.toString());
		
		TypeAndCardinality currentTypeAndCardinality = null;
		if (exp instanceof VarReference varRef) { 	//  getting type of var			
			currentTypeAndCardinality = processVarReference(varTypeMap, varCardinalityMap, varRef);
		} else if (exp instanceof SelfExp) { 
			currentTypeAndCardinality = new TypeAndCardinality(varTypeMap.get("self"), varCardinalityMap.get("self"));
		} else
			if (exp instanceof PrefixExp prefixExp) {				
				currentTypeAndCardinality = processPrefixExp(varTypeMap, varCardinalityMap, prefixExp);
			} else if (exp instanceof NestedExp) {
				currentTypeAndCardinality = checkExpressionForNavigationCorrectness(((NestedExp) exp).getSource(), varTypeMap, varCardinalityMap);
		} else if (exp instanceof InfixExp infixExp) {			
			currentTypeAndCardinality = processInfixExp(varTypeMap, varCardinalityMap, infixExp);
		}  else if (exp instanceof TemporalExp) {
			currentTypeAndCardinality = checkTemporalExpressionNavigation((TemporalExp) exp, varTypeMap, varCardinalityMap);
		}
			
		for (MethodExp methodExp : exp.getMethods()) {
			log.trace("Traversing for methodCheck: "+methodExp);
			if (methodExp instanceof IteratorExp iterExp) {				
				currentTypeAndCardinality = processIteratorExp(varTypeMap, varCardinalityMap, currentTypeAndCardinality,
						iterExp);												
			} else if (methodExp instanceof MethodCallExp callExp) {				
				currentTypeAndCardinality = processMethodCallExp(varTypeMap, varCardinalityMap,
						currentTypeAndCardinality, callExp);
			} else if (methodExp instanceof PropertyAccessExp propExp) {
				currentTypeAndCardinality = processPropertyAccessExp(currentTypeAndCardinality, propExp);
			} else if (methodExp instanceof TypeCallExp typeCallExp) {
				currentTypeAndCardinality = processTypeCallExp(typeCallExp);
			}
		}
				
		return currentTypeAndCardinality;
	}



	private TypeAndCardinality processPropertyAccessExp(TypeAndCardinality currentTypeAndCardinality,
			PropertyAccessExp propExp) {
		// we update the currentType				
		currentTypeAndCardinality = checkNavigation(currentTypeAndCardinality.getType(), propExp);
		log.trace("new current type via property: "+currentTypeAndCardinality.toString());
		return currentTypeAndCardinality;
	}



	private TypeAndCardinality processMethodCallExp(Map<String, PPEInstanceType> varTypeMap,
			Map<String, CARDINALITIES> varCardinalityMap, TypeAndCardinality currentTypeAndCardinality,
			MethodCallExp callExp) {
		// we update the currentType
		currentTypeAndCardinality = checkNextNavigation(currentTypeAndCardinality, callExp);
		log.trace("new current type via method: "+currentTypeAndCardinality.toString());
		if (callExp.getArgs() != null) {
			callExp.getArgs().getOperators().stream() 
				.forEach(childExp -> checkExpressionForNavigationCorrectness(childExp, varTypeMap, varCardinalityMap));
		}
		return currentTypeAndCardinality;
	}



	private TypeAndCardinality processTypeCallExp(TypeCallExp typeCallExp) {
		if (typeCallExp.getType() != null) {
			//we dont support typing to Collections
			String typeName = typeCallExp.getType().getName();
			Optional<PPEInstanceType> optType = resolveFullyQualifiedType(typeName);
			if (optType.isEmpty()) {
				error(String.format(" Provided type '%s' is not a known InstanceType", typeName)
						, typeCallExp.getType(), OclxPackage.Literals.TYPE_EXP__NAME, UNKNOWN_TYPE);
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
				log.error("Missing TypeCall handling: "+opName);
				return null;
			}
		} else {
			error(String.format(" Operation '%s' is missing a type a parameter", typeCallExp.getName())
			, typeCallExp.getType(), OclxPackage.Literals.TYPE_EXP__NAME, MISSING_TYPE);
			return null;
		}
	}



	private TypeAndCardinality processInfixExp(Map<String, PPEInstanceType> varTypeMap,
			Map<String, CARDINALITIES> varCardinalityMap, InfixExp infixExp) {
		TypeAndCardinality currentTypeAndCardinality;
		if (infixExp.getExpressions().size() > 1) {
			BinaryOperator op = infixExp.getOperators().get(0);
			boolean isBooleanOp = isBooleanOperator(op);
			boolean isMathOp = isMathOperatpr(op);
			List<TypeAndCardinality> returnTypes = infixExp.getExpressions().stream()
					.map(childExp -> new AbstractMap.SimpleEntry<Exp, TypeAndCardinality>(childExp, checkExpressionForNavigationCorrectness(childExp, varTypeMap, varCardinalityMap)))
					.map(entry -> {
						if (isBooleanOp && entry.getValue().getType() != BuildInType.BOOLEAN && entry.getValue().getCardinality() != CARDINALITIES.SINGLE) {
							error(String.format(" Boolean Operator requires nested expression(s) to return single Boolean but found '%s' ", entry.getValue())
									, infixExp, OclxPackage.Literals.INFIX_EXP__EXPRESSIONS, INCOMPATIBLE_RETURN_TYPE);
						} else if (isMathOp 
								&& ( entry.getValue().getType() != BuildInType.FLOAT && entry.getValue().getType() != BuildInType.INTEGER && entry.getValue().getCardinality() != CARDINALITIES.SINGLE) //neither float nor integer nor SINGLE
								) {
							error(String.format(" Math Operator requires nested expression(s) to return single FLOAT or INTEGER but found '%s' ", entry.getValue())
									, infixExp, OclxPackage.Literals.INFIX_EXP__EXPRESSIONS, INCOMPATIBLE_RETURN_TYPE);
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
			currentTypeAndCardinality = checkExpressionForNavigationCorrectness(infixExp.getExpressions().get(0), varTypeMap, varCardinalityMap);
		}
		return currentTypeAndCardinality;
	}



	private TypeAndCardinality processIteratorExp(Map<String, PPEInstanceType> varTypeMap,
			Map<String, CARDINALITIES> varCardinalityMap, TypeAndCardinality currentTypeAndCardinality,
			IteratorExp iterExp) {
		// check if iterator can be called on current input
		if (currentTypeAndCardinality == null || currentTypeAndCardinality.getCardinality().equals(CARDINALITIES.SINGLE)) {
			error(String.format("Iterator '%s' cannot be called on SINGLE input, requires SET, LIST, or COLLECTION", iterExp.getName().getName())
				, iterExp, OclxPackage.Literals.ITERATOR_EXP__NAME, INCOMPATIBLE_INPUT_TYPE);
		}
		
		Optional<IteratorVarDeclaration> varOpt = Optional.ofNullable(iterExp.getItervar());
		if (varOpt.isPresent()) {
			IteratorVarDeclaration varDec = varOpt.get();
			String varName = varDec.getName().getName();
			if (varTypeMap.containsKey(varName)) {
				// ignoring
				//error("Variable already declared.", varDec, OclxPackage.Literals.ITERATOR_VAR_DECLARATION__NAME, DUPLICATE_VAR_NAME);
			} else {
				if (varDec.getType() != null) {
					String typeName = varDec.getType().getName();
					//we dont support iterating over Collections of Collections
					Optional<PPEInstanceType> optType = resolveFullyQualifiedType(typeName);
					if (optType.isEmpty()) {
						error(String.format("Provided type '%s' is not a known InstanceType", typeName), varDec.getType(), OclxPackage.Literals.TYPE_EXP__NAME, UNKNOWN_TYPE);
						varTypeMap.put(varName, BuildInType.METATYPE);
					} else {
						varTypeMap.put(varName, optType.get());
						log.trace(String.format("Adding new variable %s of type %s " ,varName, optType.get().getName()));
					}
				} else {
					// determine var type based on previous method/property access, otherwise checking var type leads to NPE
					varTypeMap.put(varName, currentTypeAndCardinality.getType());																						
				}
				// iterator variable is always a single as we dont support Collections of Collections
				varCardinalityMap.put(varName, CARDINALITIES.SINGLE);
			}
		}
		// we update the currentType with the return type from the iterator
		var tempCurrentTypeAndCardinality = checkExpressionForNavigationCorrectness(iterExp.getBody(), varTypeMap, varCardinalityMap);
		// now we need to override the cardinality based on the iterator type:
		var iterType = iterExp.getName().getName();
		if (iterType.equals(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2().getValue())  
				|| iterType.equals(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3().getValue())
				|| iterType.equals(grammarAccess.getIteratorNameAccess().getNameSelectKeyword_0_4().getValue())
				) {
			currentTypeAndCardinality = new TypeAndCardinality(tempCurrentTypeAndCardinality.getType(), currentTypeAndCardinality.getCardinality()); // same cardinality, potentially different type
		} else if (iterType.equals(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1().getValue())
				|| iterType.equals(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0().getValue())) {
			currentTypeAndCardinality = new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
		}
		return currentTypeAndCardinality;
	}



	private TypeAndCardinality processPrefixExp(Map<String, PPEInstanceType> varTypeMap,
			Map<String, CARDINALITIES> varCardinalityMap, PrefixExp prefixExp) {
		TypeAndCardinality currentTypeAndCardinality;
		currentTypeAndCardinality = checkExpressionForNavigationCorrectness(prefixExp.getExpression(), varTypeMap, varCardinalityMap); 
		if (prefixExp.getOperator().getName().equals(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1().getValue())
				&& currentTypeAndCardinality.getType() != BuildInType.BOOLEAN) {
			error(String.format(" Expression prefixed with 'not' operator requires Boolean return type but found '%s' ", currentTypeAndCardinality.getType())
					, prefixExp, OclxPackage.Literals.PREFIX_EXP__EXPRESSION, INCOMPATIBLE_RETURN_TYPE);
		}
		return currentTypeAndCardinality;
	}



	private TypeAndCardinality processVarReference(Map<String, PPEInstanceType> varTypeMap,
			Map<String, CARDINALITIES> varCardinalityMap, VarReference varRef) {
		TypeAndCardinality currentTypeAndCardinality;
		String varName = varRef.getRef().getName();
		currentTypeAndCardinality = new TypeAndCardinality(varTypeMap.get(varName), varCardinalityMap.get(varName));
		log.trace(String.format("Setting current context type %s via var %s ",currentTypeAndCardinality.getType().getName(), varName));
		return currentTypeAndCardinality;
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



	private TypeAndCardinality checkTemporalExpressionNavigation(TemporalExp exp, Map<String, PPEInstanceType> varTypeMap, Map<String, CARDINALITIES> varCardinalityMap) {
		if (exp instanceof UnaryTemporalExp) {
			var returnType = checkExpressionForNavigationCorrectness(((UnaryTemporalExp)exp).getExp(), varTypeMap, varCardinalityMap);
			if (returnType.getType() != BuildInType.BOOLEAN || returnType.getCardinality() != CARDINALITIES.SINGLE) {
				error(String.format(" Temporal Expression requires nested expression to return single Boolean but found '%s' ", returnType), 
						((UnaryTemporalExp)exp), OclxPackage.Literals.UNARY_TEMPORAL_EXP__EXP, INCOMPATIBLE_RETURN_TYPE);
			}
		} else if (exp instanceof TriggeredTemporalExp) {
			TriggeredTemporalExp trigExp = (TriggeredTemporalExp)exp;
			var returnTypeA = checkExpressionForNavigationCorrectness(trigExp.getA(), varTypeMap, varCardinalityMap);
			if (returnTypeA.getType() != BuildInType.BOOLEAN || returnTypeA.getCardinality() != CARDINALITIES.SINGLE) {
				error(String.format(" Temporal Expression requires nested expression(s) to return single Boolean but found '%s' ", returnTypeA)
						, trigExp, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A, INCOMPATIBLE_RETURN_TYPE);
			}
			var returnTypeB =checkExpressionForNavigationCorrectness(trigExp.getB(), varTypeMap, varCardinalityMap);
			if (returnTypeB.getType() != BuildInType.BOOLEAN || returnTypeB.getCardinality() != CARDINALITIES.SINGLE) {
				error(String.format(" Temporal Expression requires nested expression(s) to return single Boolean but found '%s' ", returnTypeB)
						, trigExp, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B, INCOMPATIBLE_RETURN_TYPE);
			}
		}
		return new TypeAndCardinality(BuildInType.BOOLEAN, CARDINALITIES.SINGLE);
	}
	
	private TypeAndCardinality checkNavigation(PPEInstanceType currentType, PropertyAccessExp expression) {
		String method = expression.getName();
		if (!currentType.hasPropertyType(method)) {
			error(String.format("'%s' is not a known property for InstanceType '%s'", method, currentType.getName() )
					, expression, OclxPackage.Literals.PROPERTY_ACCESS_EXP__NAME, UNKNOWN_PROPERTY);
			return null;
		} else {
			var prop = currentType.getPropertyType(method);
			return new TypeAndCardinality(prop.getInstanceType(), prop.getCardinality());
		}
	}
	
	private TypeAndCardinality checkNextNavigation(TypeAndCardinality currentTypeAndCardinality, MethodCallExp expression) {

		// if ANY return value, reuse current type (as this is then a collection accessor operation or collection transformation operation			
		var methodReturnType = methodReg.getReturnTypeForMethodName(expression.getName(), currentTypeAndCardinality.getType());			
		if (methodReturnType == null) {
			error(String.format("'%s' is not a known operation/method ", expression.getName())
					, expression, OclxPackage.Literals.METHOD_CALL_EXP__NAME, UNKNOWN_OPERATION);
			return null;
		} else {
			// check if method can be called on current type (see ARL OperatorExpression)
			var isCompatibleType = methodReg.canMethodBeCalledOnType(expression.getName(), currentTypeAndCardinality);		
			if (!isCompatibleType) {
				error(String.format("'%s' cannot be called on type '%s' of cardinality '%s' ", expression.getName(), currentTypeAndCardinality.getType(), currentTypeAndCardinality.getCardinality())
						, expression, OclxPackage.Literals.METHOD_CALL_EXP__NAME, INCOMPATIBLE_INPUT_TYPE);
			}				
			return methodReturnType;
		}					
	}
	
	private Optional<PPEInstanceType> resolveType(String typeName) {
		return schemaReg.getAllNonDeletedInstanceTypes().stream()
				.filter(type -> type.getName().equalsIgnoreCase(typeName))
				.findFirst();
	}
	
	private Optional<PPEInstanceType> resolveFullyQualifiedType(String fqnTypeName) {
		return schemaReg.findNonDeletedInstanceTypeByFQN(fqnTypeName);
	}
}
