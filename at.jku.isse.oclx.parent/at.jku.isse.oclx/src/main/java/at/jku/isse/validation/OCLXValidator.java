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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import at.jku.isse.oclx.NavigationExp;
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
public class OCLXValidator extends AbstractOCLXValidator implements TypeExtractor.ErrorCollector {
	
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
			checkTemporalExpressionVariables((TemporalExp) exp, declaredVars);
		}
		// for any traversing/navigating:	
		if (exp instanceof NavigationExp navExp) {
			navExp.getMethods().forEach(methodExp -> {	
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
	}
	
	private void checkTemporalExpressionVariables(TemporalExp exp, Set<String> declaredVars) {
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
			ElementToTypeMap elementToTypeMap = new ElementToTypeMap(optType.get());
			// for each navigation we check if the current type allows that method or property navigation
			TypeExtractor extractor = new TypeExtractor(schemaReg, methodReg, grammarAccess, this);
			extractor.checkExpressionForNavigationCorrectness(constraint.getExpression(), elementToTypeMap);
		}
	}
	

	private Optional<PPEInstanceType> resolveType(String typeName) {
		return schemaReg.getAllNonDeletedInstanceTypes().stream()
				.filter(type -> type.getName().equalsIgnoreCase(typeName))
				.findFirst();
	}


	@Override
	public void error(String message, EObject source, EStructuralFeature feature, String code) {
		super.error(message, source, feature, code);		
	}
}
