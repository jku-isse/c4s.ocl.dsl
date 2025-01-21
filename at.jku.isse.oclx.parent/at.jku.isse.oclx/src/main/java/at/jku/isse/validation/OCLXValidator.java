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
import at.jku.isse.oclx.UnaryTemporalExp;
import at.jku.isse.oclx.VarReference;
import at.jku.isse.passiveprocessengine.core.BuildInType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.services.OCLXGrammarAccess;

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
	
	public static final String DUPLICATE_VAR_NAME = "duplicateVarName";
	public static final String UNKNOWN_PROPERTY = "unknownProperty";
	public static final String UNKNOWN_TYPE = "unknownType";
	public static final String INCOMPATIBLE_RETURN_TYPE = "incompatibleReturnType";
	
	
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
	public void checkMethodExists(Constraint constraint) {
		String context = constraint.getContext().getName();
		if (context == null) { 
			return;
		}
		Optional<PPEInstanceType> optType = resolveType(context);
		if (optType.isPresent()) {
			Map<String, PPEInstanceType> var2type = new HashMap<>();
			var2type.put("self", optType.get());
			// for each navigation we check if the current type allows that method or property navigation
			checkExpressionForNavigationCorrectness(constraint.getExpression(), var2type);
		}
	}
	
	private PPEInstanceType checkExpressionForNavigationCorrectness(Exp exp, Map<String, PPEInstanceType> varTypeMap) {
		if (exp == null) return null;
		log.trace(exp.toString());
		
		PPEInstanceType currentType = null;
		if (exp instanceof VarReference) { 	//  getting type of var
			VarReference varRef = (VarReference)exp;
			String varName = varRef.getRef().getName();
			currentType = varTypeMap.get(varName);
			log.trace(String.format("Setting current context type %s via var %s ",currentType.getName(), varName));
		} else if (exp instanceof SelfExp) { 
			currentType = varTypeMap.get("self");
		} else
			if (exp instanceof PrefixExp) {
			PrefixExp prefixExp = (PrefixExp)exp;
			currentType = checkExpressionForNavigationCorrectness(prefixExp.getExpression(), varTypeMap);
			if (prefixExp.getOperator().getName().equals(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1().getValue())
					&& currentType != BuildInType.BOOLEAN) {
				error(String.format(" Expression prefixed with 'not' operator requires Boolean return type but found '%s' ", currentType), prefixExp.getExpression(), OclxPackage.Literals.PREFIX_EXP__EXPRESSION, INCOMPATIBLE_RETURN_TYPE);
			}
		} else if (exp instanceof NestedExp) {
			currentType = checkExpressionForNavigationCorrectness(((NestedExp) exp).getSource(), varTypeMap);
		} else if (exp instanceof InfixExp) {
			InfixExp infixExp = (InfixExp)exp;
			if (infixExp.getExpressions().size() > 1) {
				BinaryOperator op = infixExp.getOperators().get(0);
				boolean isBooleanOp = isBooleanOperator(op);
				boolean isMathOp = isMathOperatpr(op);
				List<PPEInstanceType> returnTypes = infixExp.getExpressions().stream()
						.map(childExp -> new AbstractMap.SimpleEntry<Exp, PPEInstanceType>(childExp, checkExpressionForNavigationCorrectness(childExp, varTypeMap)))
						.map(entry -> {
							if (isBooleanOp && entry.getValue() != BuildInType.BOOLEAN) {
								error(String.format(" Boolean Operator requires nested expression(s) to return Boolean but found '%s' ", entry.getValue()), infixExp, OclxPackage.Literals.INFIX_EXP__EXPRESSIONS, INCOMPATIBLE_RETURN_TYPE);
							} else if (isMathOp 
									&& ( entry.getValue() != BuildInType.FLOAT && entry.getValue() != BuildInType.INTEGER) //neither float nor integer
									) {
								error(String.format(" Math Operator requires nested expression(s) to return FLOAT or INTEGER but found '%s' ", entry.getValue()), infixExp, OclxPackage.Literals.INFIX_EXP__EXPRESSIONS, INCOMPATIBLE_RETURN_TYPE);
							}
							return entry.getValue();
						})
						.collect(Collectors.toList());
				// return type depends on Binary Operator, we only check first operator 
				if (op instanceof BooleanOperator) {
					currentType = BuildInType.BOOLEAN;
				} else if (op instanceof MathOperator) {
					currentType = BuildInType.FLOAT; //TODO: check simultaneous use of math and logic operators!
				} else {
					currentType = BuildInType.METATYPE; //should not happen
				}
			} else {
				currentType = checkExpressionForNavigationCorrectness(infixExp.getExpressions().get(0), varTypeMap);
			}
		}  else if (exp instanceof TemporalExp) {
			currentType = checkTemporalExpressionNavigation((TemporalExp) exp, varTypeMap);
		}
			
		for (MethodExp methodExp : exp.getMethods()) {
			log.trace("Traversing for methodCheck: "+methodExp);
			if (methodExp instanceof IteratorExp) {
				IteratorExp iterExp = (IteratorExp)methodExp;
				
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
							if (currentType != null) {
								varTypeMap.put(varName, currentType);
							// determine var type based on previous method/property access, otherwise checking var type leads to NPE
							}
						}
					}
				}
				// we update the currentType with the return type from the iterator
				currentType = checkExpressionForNavigationCorrectness(iterExp.getBody(), varTypeMap);
			} else if (methodExp instanceof MethodCallExp) {
				MethodCallExp callExp = (MethodCallExp)methodExp;
				// we update the currentType
				currentType = checkNextNavigation(currentType, callExp);
				log.trace("new current type via method: "+currentType.toString());
				if (callExp.getArgs() != null) {
					callExp.getArgs().getOperators().stream() 
						.forEach(childExp -> checkExpressionForNavigationCorrectness(childExp, varTypeMap));
				}
			} else if (methodExp instanceof PropertyAccessExp) {
				// we update the currentType
				PropertyAccessExp propExp = (PropertyAccessExp)methodExp;
				currentType = checkNavigation(currentType, propExp);
				log.trace("new current type via property: "+currentType.toString());
			}
		}
		return currentType;
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



	private PPEInstanceType checkTemporalExpressionNavigation(TemporalExp exp, Map<String, PPEInstanceType> varTypeMap) {
		if (exp instanceof UnaryTemporalExp) {
			PPEInstanceType returnType = checkExpressionForNavigationCorrectness(((UnaryTemporalExp)exp).getExp(), varTypeMap);
			if (returnType != BuildInType.BOOLEAN) {
				error(String.format(" Temporal Expression requires nested expression to return Boolean but found '%s' ", returnType), 
						((UnaryTemporalExp)exp), OclxPackage.Literals.UNARY_TEMPORAL_EXP__EXP, INCOMPATIBLE_RETURN_TYPE);
			}
		} else if (exp instanceof TriggeredTemporalExp) {
			TriggeredTemporalExp trigExp = (TriggeredTemporalExp)exp;
			PPEInstanceType returnTypeA = checkExpressionForNavigationCorrectness(trigExp.getA(), varTypeMap);
			if (returnTypeA != BuildInType.BOOLEAN) {
				error(String.format(" Temporal Expression requires nested expression(s) to return Boolean but found '%s' ", returnTypeA)
						, trigExp, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A, INCOMPATIBLE_RETURN_TYPE);
			}
			PPEInstanceType returnTypeB =checkExpressionForNavigationCorrectness(trigExp.getB(), varTypeMap);
			if (returnTypeB != BuildInType.BOOLEAN) {
				error(String.format(" Temporal Expression requires nested expression(s) to return Boolean but found '%s' ", returnTypeB)
						, trigExp, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B, INCOMPATIBLE_RETURN_TYPE);
			}
		}
		return BuildInType.BOOLEAN;
	}
	
	private PPEInstanceType checkNavigation(PPEInstanceType currentType, PropertyAccessExp expression) {
		String method = expression.getName();
		if (!currentType.hasPropertyType(method)) {
			error(String.format("'%s' is not a known property for InstanceType '%s'", method, currentType.getName() ), expression, OclxPackage.Literals.PROPERTY_ACCESS_EXP__NAME, UNKNOWN_PROPERTY);
			return null;
		} else {
			return currentType.getPropertyType(method).getInstanceType();
		}
	}
	
	private PPEInstanceType checkNextNavigation(PPEInstanceType currentType, MethodCallExp expression) {
		if (expression.getType() != null) {
			//we dont support typing to Collections
			String typeName = expression.getType().getName();
			Optional<PPEInstanceType> optType = resolveFullyQualifiedType(typeName);
			if (optType.isEmpty()) {
				error(String.format(" Provided type '%s' is not a known InstanceType", typeName), expression.getType(), OclxPackage.Literals.TYPE_EXP__NAME, UNKNOWN_TYPE);
			} else {
				return optType.get();
			}
		}
			// we have a regular method
			return null; //TODO: handle method return types --> this needs something more sophisticated to know which method can be called on which type (see ARL OperatorExpression)
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
