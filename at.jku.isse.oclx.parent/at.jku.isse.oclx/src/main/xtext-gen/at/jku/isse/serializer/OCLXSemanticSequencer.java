/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse.serializer;

import at.jku.isse.oclx.ArgumentsExp;
import at.jku.isse.oclx.BooleanLiteralExp;
import at.jku.isse.oclx.BooleanOperator;
import at.jku.isse.oclx.CollectionTypeIdentifier;
import at.jku.isse.oclx.Constraint;
import at.jku.isse.oclx.Context;
import at.jku.isse.oclx.InfixExp;
import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.IteratorName;
import at.jku.isse.oclx.IteratorVarDeclaration;
import at.jku.isse.oclx.MathOperator;
import at.jku.isse.oclx.MethodCallExp;
import at.jku.isse.oclx.Model;
import at.jku.isse.oclx.NavigationOperator;
import at.jku.isse.oclx.NestedExp;
import at.jku.isse.oclx.NullLiteralExpCS;
import at.jku.isse.oclx.NumberLiteralExp;
import at.jku.isse.oclx.OclxPackage;
import at.jku.isse.oclx.PrefixExp;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.StringLiteralExp;
import at.jku.isse.oclx.TriggeredTemporalExp;
import at.jku.isse.oclx.TypeExp;
import at.jku.isse.oclx.UnaryOperator;
import at.jku.isse.oclx.UnaryTemporalExp;
import at.jku.isse.oclx.VarDeclaration;
import at.jku.isse.oclx.VarReference;
import at.jku.isse.services.OCLXGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class OCLXSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OCLXGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == OclxPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case OclxPackage.ARGUMENTS_EXP:
				sequence_ArgumentsExp(context, (ArgumentsExp) semanticObject); 
				return; 
			case OclxPackage.BOOLEAN_LITERAL_EXP:
				sequence_BooleanLiteralExp(context, (BooleanLiteralExp) semanticObject); 
				return; 
			case OclxPackage.BOOLEAN_OPERATOR:
				sequence_BooleanOperator(context, (BooleanOperator) semanticObject); 
				return; 
			case OclxPackage.COLLECTION_TYPE_IDENTIFIER:
				sequence_CollectionTypeIdentifier(context, (CollectionTypeIdentifier) semanticObject); 
				return; 
			case OclxPackage.CONSTRAINT:
				sequence_Constraint(context, (Constraint) semanticObject); 
				return; 
			case OclxPackage.CONTEXT:
				sequence_Context(context, (Context) semanticObject); 
				return; 
			case OclxPackage.INFIX_EXP:
				sequence_Exp(context, (InfixExp) semanticObject); 
				return; 
			case OclxPackage.ITERATOR_EXP:
				sequence_CollectionIterator(context, (IteratorExp) semanticObject); 
				return; 
			case OclxPackage.ITERATOR_NAME:
				sequence_IteratorName(context, (IteratorName) semanticObject); 
				return; 
			case OclxPackage.ITERATOR_VAR_DECLARATION:
				sequence_IteratorVarDeclaration(context, (IteratorVarDeclaration) semanticObject); 
				return; 
			case OclxPackage.MATH_OPERATOR:
				sequence_MathOperator(context, (MathOperator) semanticObject); 
				return; 
			case OclxPackage.METHOD_CALL_EXP:
				sequence_MethodCall(context, (MethodCallExp) semanticObject); 
				return; 
			case OclxPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case OclxPackage.NAVIGATION_OPERATOR:
				sequence_NavigationOperator(context, (NavigationOperator) semanticObject); 
				return; 
			case OclxPackage.NESTED_EXP:
				sequence_NestedExp(context, (NestedExp) semanticObject); 
				return; 
			case OclxPackage.NULL_LITERAL_EXP_CS:
				sequence_NullLiteralExp(context, (NullLiteralExpCS) semanticObject); 
				return; 
			case OclxPackage.NUMBER_LITERAL_EXP:
				sequence_NumberLiteralExp(context, (NumberLiteralExp) semanticObject); 
				return; 
			case OclxPackage.PREFIX_EXP:
				sequence_PrefixedExp(context, (PrefixExp) semanticObject); 
				return; 
			case OclxPackage.PROPERTY_ACCESS_EXP:
				sequence_PropertyAccess(context, (PropertyAccessExp) semanticObject); 
				return; 
			case OclxPackage.SELF_EXP:
				if (rule == grammarAccess.getExpRule()
						|| action == grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()
						|| rule == grammarAccess.getPrefixedExpRule()
						|| rule == grammarAccess.getPrimaryExpRule()) {
					sequence_PrimaryExp_SelfExp(context, (SelfExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVarOrSelfExpRule()
						|| rule == grammarAccess.getSelfExpRule()) {
					sequence_SelfExp(context, (SelfExp) semanticObject); 
					return; 
				}
				else break;
			case OclxPackage.STRING_LITERAL_EXP:
				sequence_StringLiteralExp(context, (StringLiteralExp) semanticObject); 
				return; 
			case OclxPackage.TRIGGERED_TEMPORAL_EXP:
				if (rule == grammarAccess.getExpRule()
						|| action == grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()
						|| rule == grammarAccess.getPrefixedExpRule()
						|| rule == grammarAccess.getPrimaryExpRule()
						|| rule == grammarAccess.getTemporalExpRule()
						|| rule == grammarAccess.getTriggeredTemporalExpRule()) {
					sequence_LegacyAsSoonAs_LegacyEverytime_LegacyUntil_TemporalAsLongAs_TemporalAtLeastOnce_TemporalEverytime_TemporalUntil(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLegacyAsSoonAsRule()) {
					sequence_LegacyAsSoonAs(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLegacyEverytimeRule()) {
					sequence_LegacyEverytime(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLegacyUntilRule()) {
					sequence_LegacyUntil(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTemporalAsLongAsRule()) {
					sequence_TemporalAsLongAs(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTemporalAtLeastOnceRule()) {
					sequence_TemporalAtLeastOnce(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTemporalEverytimeRule()) {
					sequence_TemporalEverytime(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTemporalUntilRule()) {
					sequence_TemporalUntil(context, (TriggeredTemporalExp) semanticObject); 
					return; 
				}
				else break;
			case OclxPackage.TYPE_EXP:
				sequence_TypeExp(context, (TypeExp) semanticObject); 
				return; 
			case OclxPackage.UNARY_OPERATOR:
				sequence_UnaryOperator(context, (UnaryOperator) semanticObject); 
				return; 
			case OclxPackage.UNARY_TEMPORAL_EXP:
				sequence_UnaryTemporalExp(context, (UnaryTemporalExp) semanticObject); 
				return; 
			case OclxPackage.VAR_DECLARATION:
				sequence_VarDeclaration(context, (VarDeclaration) semanticObject); 
				return; 
			case OclxPackage.VAR_REFERENCE:
				if (rule == grammarAccess.getExpRule()
						|| action == grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()
						|| rule == grammarAccess.getPrefixedExpRule()
						|| rule == grammarAccess.getPrimaryExpRule()) {
					sequence_PrimaryExp_VarReference(context, (VarReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVarOrSelfExpRule()
						|| rule == grammarAccess.getVarReferenceRule()) {
					sequence_VarReference(context, (VarReference) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     ArgumentsExp returns ArgumentsExp
	 *
	 * Constraint:
	 *     (operators+=Exp operators+=Exp*)
	 * </pre>
	 */
	protected void sequence_ArgumentsExp(ISerializationContext context, ArgumentsExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns BooleanLiteralExp
	 *     Exp.InfixExp_1_0 returns BooleanLiteralExp
	 *     PrefixedExp returns BooleanLiteralExp
	 *     PrimaryExp returns BooleanLiteralExp
	 *     PrimitiveLiteralExp returns BooleanLiteralExp
	 *     BooleanLiteralExp returns BooleanLiteralExp
	 *
	 * Constraint:
	 *     (value='true' | value='false')
	 * </pre>
	 */
	protected void sequence_BooleanLiteralExp(ISerializationContext context, BooleanLiteralExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     BinaryOperator returns BooleanOperator
	 *     InfixOperator returns BooleanOperator
	 *     BooleanOperator returns BooleanOperator
	 *
	 * Constraint:
	 *     (
	 *         op='&gt;' | 
	 *         op='&lt;' | 
	 *         op='&gt;=' | 
	 *         op='&lt;=' | 
	 *         op='=' | 
	 *         op='&lt;&gt;' | 
	 *         op='and' | 
	 *         op='or' | 
	 *         op='xor' | 
	 *         op='implies'
	 *     )
	 * </pre>
	 */
	protected void sequence_BooleanOperator(ISerializationContext context, BooleanOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MethodExp returns IteratorExp
	 *     CollectionIterator returns IteratorExp
	 *
	 * Constraint:
	 *     (name=IteratorName itervar=IteratorVarDeclaration body=Exp)
	 * </pre>
	 */
	protected void sequence_CollectionIterator(ISerializationContext context, IteratorExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.ITERATOR_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.ITERATOR_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.ITERATOR_EXP__ITERVAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.ITERATOR_EXP__ITERVAR));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.ITERATOR_EXP__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.ITERATOR_EXP__BODY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCollectionIteratorAccess().getNameIteratorNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getCollectionIteratorAccess().getItervarIteratorVarDeclarationParserRuleCall_2_0(), semanticObject.getItervar());
		feeder.accept(grammarAccess.getCollectionIteratorAccess().getBodyExpParserRuleCall_4_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     CollectionTypeIdentifier returns CollectionTypeIdentifier
	 *
	 * Constraint:
	 *     (name='SET' | name='LIST' | name='MAP' | name='COLLECTION')
	 * </pre>
	 */
	protected void sequence_CollectionTypeIdentifier(ISerializationContext context, CollectionTypeIdentifier semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Constraint returns Constraint
	 *
	 * Constraint:
	 *     (name=ID description=DESCRIPTION? overrulable?=BooleanLiteralExp? context=Context expression=Exp)
	 * </pre>
	 */
	protected void sequence_Constraint(ISerializationContext context, Constraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Context returns Context
	 *
	 * Constraint:
	 *     name=QualifiedName
	 * </pre>
	 */
	protected void sequence_Context(ISerializationContext context, Context semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.CONTEXT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.CONTEXT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getContextAccess().getNameQualifiedNameParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns InfixExp
	 *
	 * Constraint:
	 *     (expressions+=Exp_InfixExp_1_0 operators+=BinaryOperator expressions+=PrefixedExp (operators+=BinaryOperator expressions+=PrefixedExp)*)
	 * </pre>
	 */
	protected void sequence_Exp(ISerializationContext context, InfixExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IteratorName returns IteratorName
	 *
	 * Constraint:
	 *     (name='FORALL' | name='EXISTS' | name='COLLECT' | name='REJECT' | name='SELECT')
	 * </pre>
	 */
	protected void sequence_IteratorName(ISerializationContext context, IteratorName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IteratorVarDeclaration returns IteratorVarDeclaration
	 *
	 * Constraint:
	 *     (name=VarDeclaration | (name=VarDeclaration type=TypeExp))
	 * </pre>
	 */
	protected void sequence_IteratorVarDeclaration(ISerializationContext context, IteratorVarDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns TriggeredTemporalExp
	 *     Exp.InfixExp_1_0 returns TriggeredTemporalExp
	 *     PrefixedExp returns TriggeredTemporalExp
	 *     PrimaryExp returns TriggeredTemporalExp
	 *     TemporalExp returns TriggeredTemporalExp
	 *     TriggeredTemporalExp returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (
	 *         (name='asLongAs' b=Exp a=Exp) | 
	 *         (name='ensureThat' a=Exp b=Exp) | 
	 *         (name='everyTime' a=Exp b=Exp) | 
	 *         (name='whenOnce' a=Exp b=Exp) | 
	 *         (name='until' a=Exp b=Exp) | 
	 *         (name='asSoonAs' a=Exp b=Exp) | 
	 *         (name='everytime' a=Exp b=Exp)
	 *     )
	 * </pre>
	 */
	protected void sequence_LegacyAsSoonAs_LegacyEverytime_LegacyUntil_TemporalAsLongAs_TemporalAtLeastOnce_TemporalEverytime_TemporalUntil(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LegacyAsSoonAs returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (name='asSoonAs' a=Exp b=Exp)
	 * </pre>
	 */
	protected void sequence_LegacyAsSoonAs(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLegacyAsSoonAsAccess().getAExpParserRuleCall_2_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getLegacyAsSoonAsAccess().getBExpParserRuleCall_4_0(), semanticObject.getB());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LegacyEverytime returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (name='everytime' a=Exp b=Exp)
	 * </pre>
	 */
	protected void sequence_LegacyEverytime(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLegacyEverytimeAccess().getAExpParserRuleCall_2_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getLegacyEverytimeAccess().getBExpParserRuleCall_4_0(), semanticObject.getB());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LegacyUntil returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (name='until' a=Exp b=Exp)
	 * </pre>
	 */
	protected void sequence_LegacyUntil(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLegacyUntilAccess().getAExpParserRuleCall_2_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getLegacyUntilAccess().getBExpParserRuleCall_4_0(), semanticObject.getB());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     BinaryOperator returns MathOperator
	 *     InfixOperator returns MathOperator
	 *     MathOperator returns MathOperator
	 *
	 * Constraint:
	 *     (op='*' | op='/' | op='+' | op='-')
	 * </pre>
	 */
	protected void sequence_MathOperator(ISerializationContext context, MathOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MethodExp returns MethodCallExp
	 *     MethodCall returns MethodCallExp
	 *
	 * Constraint:
	 *     (name=SimpleName | (name=SimpleName args=ArgumentsExp) | (name=SimpleName type=TypeExp))
	 * </pre>
	 */
	protected void sequence_MethodCall(ISerializationContext context, MethodCallExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     constraints+=Constraint+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NavigationOperator returns NavigationOperator
	 *
	 * Constraint:
	 *     (name='.' | name='-&gt;')
	 * </pre>
	 */
	protected void sequence_NavigationOperator(ISerializationContext context, NavigationOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns NestedExp
	 *     Exp.InfixExp_1_0 returns NestedExp
	 *     PrefixedExp returns NestedExp
	 *     PrimaryExp returns NestedExp
	 *     NestedExp returns NestedExp
	 *
	 * Constraint:
	 *     source=Exp
	 * </pre>
	 */
	protected void sequence_NestedExp(ISerializationContext context, NestedExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.NESTED_EXP__SOURCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.NESTED_EXP__SOURCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNestedExpAccess().getSourceExpParserRuleCall_1_0(), semanticObject.getSource());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns NullLiteralExpCS
	 *     Exp.InfixExp_1_0 returns NullLiteralExpCS
	 *     PrefixedExp returns NullLiteralExpCS
	 *     PrimaryExp returns NullLiteralExpCS
	 *     PrimitiveLiteralExp returns NullLiteralExpCS
	 *     NullLiteralExp returns NullLiteralExpCS
	 *
	 * Constraint:
	 *     {NullLiteralExpCS}
	 * </pre>
	 */
	protected void sequence_NullLiteralExp(ISerializationContext context, NullLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns NumberLiteralExp
	 *     Exp.InfixExp_1_0 returns NumberLiteralExp
	 *     PrefixedExp returns NumberLiteralExp
	 *     PrimaryExp returns NumberLiteralExp
	 *     PrimitiveLiteralExp returns NumberLiteralExp
	 *     NumberLiteralExp returns NumberLiteralExp
	 *
	 * Constraint:
	 *     value=INT
	 * </pre>
	 */
	protected void sequence_NumberLiteralExp(ISerializationContext context, NumberLiteralExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.NUMBER_LITERAL_EXP__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.NUMBER_LITERAL_EXP__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNumberLiteralExpAccess().getValueINTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns PrefixExp
	 *     Exp.InfixExp_1_0 returns PrefixExp
	 *     PrefixedExp returns PrefixExp
	 *
	 * Constraint:
	 *     (operator=UnaryOperator expression=PrimaryExp)
	 * </pre>
	 */
	protected void sequence_PrefixedExp(ISerializationContext context, PrefixExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.PREFIX_EXP__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.PREFIX_EXP__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.PREFIX_EXP__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.PREFIX_EXP__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrefixedExpAccess().getOperatorUnaryOperatorParserRuleCall_0_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getPrefixedExpAccess().getExpressionPrimaryExpParserRuleCall_0_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns SelfExp
	 *     Exp.InfixExp_1_0 returns SelfExp
	 *     PrefixedExp returns SelfExp
	 *     PrimaryExp returns SelfExp
	 *
	 * Constraint:
	 *     (name='self' (nav+=NavigationOperator methods+=MethodExp)*)
	 * </pre>
	 */
	protected void sequence_PrimaryExp_SelfExp(ISerializationContext context, SelfExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns VarReference
	 *     Exp.InfixExp_1_0 returns VarReference
	 *     PrefixedExp returns VarReference
	 *     PrimaryExp returns VarReference
	 *
	 * Constraint:
	 *     (ref=[VarDeclaration|ID] (nav+=NavigationOperator methods+=MethodExp)*)
	 * </pre>
	 */
	protected void sequence_PrimaryExp_VarReference(ISerializationContext context, VarReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MethodExp returns PropertyAccessExp
	 *     PropertyAccess returns PropertyAccessExp
	 *
	 * Constraint:
	 *     name=SimpleName
	 * </pre>
	 */
	protected void sequence_PropertyAccess(ISerializationContext context, PropertyAccessExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.PROPERTY_ACCESS_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.PROPERTY_ACCESS_EXP__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPropertyAccessAccess().getNameSimpleNameParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     VarOrSelfExp returns SelfExp
	 *     SelfExp returns SelfExp
	 *
	 * Constraint:
	 *     name='self'
	 * </pre>
	 */
	protected void sequence_SelfExp(ISerializationContext context, SelfExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.SELF_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.SELF_EXP__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns StringLiteralExp
	 *     Exp.InfixExp_1_0 returns StringLiteralExp
	 *     PrefixedExp returns StringLiteralExp
	 *     PrimaryExp returns StringLiteralExp
	 *     PrimitiveLiteralExp returns StringLiteralExp
	 *     StringLiteralExp returns StringLiteralExp
	 *
	 * Constraint:
	 *     value=STRING
	 * </pre>
	 */
	protected void sequence_StringLiteralExp(ISerializationContext context, StringLiteralExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.STRING_LITERAL_EXP__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.STRING_LITERAL_EXP__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringLiteralExpAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemporalAsLongAs returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (name='asLongAs' b=Exp a=Exp)
	 * </pre>
	 */
	protected void sequence_TemporalAsLongAs(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTemporalAsLongAsAccess().getBExpParserRuleCall_2_0(), semanticObject.getB());
		feeder.accept(grammarAccess.getTemporalAsLongAsAccess().getAExpParserRuleCall_4_0(), semanticObject.getA());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemporalAtLeastOnce returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (name='whenOnce' a=Exp b=Exp)
	 * </pre>
	 */
	protected void sequence_TemporalAtLeastOnce(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTemporalAtLeastOnceAccess().getAExpParserRuleCall_2_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getTemporalAtLeastOnceAccess().getBExpParserRuleCall_4_0(), semanticObject.getB());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemporalEverytime returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (name='everyTime' a=Exp b=Exp)
	 * </pre>
	 */
	protected void sequence_TemporalEverytime(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTemporalEverytimeAccess().getAExpParserRuleCall_2_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getTemporalEverytimeAccess().getBExpParserRuleCall_4_0(), semanticObject.getB());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemporalUntil returns TriggeredTemporalExp
	 *
	 * Constraint:
	 *     (name='ensureThat' a=Exp b=Exp)
	 * </pre>
	 */
	protected void sequence_TemporalUntil(ISerializationContext context, TriggeredTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__A));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TRIGGERED_TEMPORAL_EXP__B));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTemporalUntilAccess().getAExpParserRuleCall_2_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getTemporalUntilAccess().getBExpParserRuleCall_4_0(), semanticObject.getB());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TypeExp returns TypeExp
	 *
	 * Constraint:
	 *     (name=Path | (collectionType=CollectionTypeIdentifier type=TypeExp))
	 * </pre>
	 */
	protected void sequence_TypeExp(ISerializationContext context, TypeExp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnaryOperator returns UnaryOperator
	 *
	 * Constraint:
	 *     (name='-' | name='not')
	 * </pre>
	 */
	protected void sequence_UnaryOperator(ISerializationContext context, UnaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exp returns UnaryTemporalExp
	 *     Exp.InfixExp_1_0 returns UnaryTemporalExp
	 *     PrefixedExp returns UnaryTemporalExp
	 *     PrimaryExp returns UnaryTemporalExp
	 *     TemporalExp returns UnaryTemporalExp
	 *     UnaryTemporalExp returns UnaryTemporalExp
	 *
	 * Constraint:
	 *     (name=UnaryTemporalOp exp=Exp)
	 * </pre>
	 */
	protected void sequence_UnaryTemporalExp(ISerializationContext context, UnaryTemporalExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.TEMPORAL_EXP__NAME));
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.UNARY_TEMPORAL_EXP__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.UNARY_TEMPORAL_EXP__EXP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnaryTemporalExpAccess().getNameUnaryTemporalOpParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getUnaryTemporalExpAccess().getExpExpParserRuleCall_2_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     VarDeclaration returns VarDeclaration
	 *
	 * Constraint:
	 *     name=SimpleName
	 * </pre>
	 */
	protected void sequence_VarDeclaration(ISerializationContext context, VarDeclaration semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.VAR_DECLARATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.VAR_DECLARATION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarDeclarationAccess().getNameSimpleNameParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     VarOrSelfExp returns VarReference
	 *     VarReference returns VarReference
	 *
	 * Constraint:
	 *     ref=[VarDeclaration|ID]
	 * </pre>
	 */
	protected void sequence_VarReference(ISerializationContext context, VarReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclxPackage.Literals.VAR_REFERENCE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclxPackage.Literals.VAR_REFERENCE__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarReferenceAccess().getRefVarDeclarationIDTerminalRuleCall_0_1(), semanticObject.eGet(OclxPackage.Literals.VAR_REFERENCE__REF, false));
		feeder.finish();
	}
	
	
}
