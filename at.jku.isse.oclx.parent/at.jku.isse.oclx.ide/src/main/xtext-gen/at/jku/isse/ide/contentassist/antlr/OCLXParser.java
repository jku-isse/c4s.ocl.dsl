/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse.ide.contentassist.antlr;

import at.jku.isse.ide.contentassist.antlr.internal.InternalOCLXParser;
import at.jku.isse.services.OCLXGrammarAccess;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class OCLXParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(OCLXGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, OCLXGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getPrefixedExpAccess().getAlternatives(), "rule__PrefixedExp__Alternatives");
			builder.put(grammarAccess.getInfixOperatorAccess().getAlternatives(), "rule__InfixOperator__Alternatives");
			builder.put(grammarAccess.getBooleanOperatorAccess().getOpAlternatives_0(), "rule__BooleanOperator__OpAlternatives_0");
			builder.put(grammarAccess.getMathOperatorAccess().getOpAlternatives_0(), "rule__MathOperator__OpAlternatives_0");
			builder.put(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0(), "rule__NavigationOperator__NameAlternatives_0");
			builder.put(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0(), "rule__UnaryOperator__NameAlternatives_0");
			builder.put(grammarAccess.getPrimaryExpAccess().getAlternatives(), "rule__PrimaryExp__Alternatives");
			builder.put(grammarAccess.getVarOrSelfExpAccess().getAlternatives(), "rule__VarOrSelfExp__Alternatives");
			builder.put(grammarAccess.getPrimitiveLiteralExpAccess().getAlternatives(), "rule__PrimitiveLiteralExp__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralExpAccess().getAlternatives(), "rule__BooleanLiteralExp__Alternatives");
			builder.put(grammarAccess.getMethodExpAccess().getAlternatives(), "rule__MethodExp__Alternatives");
			builder.put(grammarAccess.getIteratorNameAccess().getNameAlternatives_0(), "rule__IteratorName__NameAlternatives_0");
			builder.put(grammarAccess.getIteratorVarDeclarationAccess().getAlternatives(), "rule__IteratorVarDeclaration__Alternatives");
			builder.put(grammarAccess.getMethodCallAccess().getAlternatives(), "rule__MethodCall__Alternatives");
			builder.put(grammarAccess.getTypeCallAccess().getNameAlternatives_0_0(), "rule__TypeCall__NameAlternatives_0_0");
			builder.put(grammarAccess.getTypeExpAccess().getAlternatives(), "rule__TypeExp__Alternatives");
			builder.put(grammarAccess.getCollectionTypeIdentifierAccess().getNameAlternatives_0(), "rule__CollectionTypeIdentifier__NameAlternatives_0");
			builder.put(grammarAccess.getTemporalExpAccess().getAlternatives(), "rule__TemporalExp__Alternatives");
			builder.put(grammarAccess.getUnaryTemporalOpAccess().getAlternatives(), "rule__UnaryTemporalOp__Alternatives");
			builder.put(grammarAccess.getTriggeredTemporalExpAccess().getAlternatives(), "rule__TriggeredTemporalExp__Alternatives");
			builder.put(grammarAccess.getConstraintAccess().getGroup(), "rule__Constraint__Group__0");
			builder.put(grammarAccess.getConstraintAccess().getGroup_3(), "rule__Constraint__Group_3__0");
			builder.put(grammarAccess.getConstraintAccess().getGroup_4(), "rule__Constraint__Group_4__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getFloatAccess().getGroup(), "rule__Float__Group__0");
			builder.put(grammarAccess.getExpAccess().getGroup(), "rule__Exp__Group__0");
			builder.put(grammarAccess.getExpAccess().getGroup_1(), "rule__Exp__Group_1__0");
			builder.put(grammarAccess.getExpAccess().getGroup_1_3(), "rule__Exp__Group_1_3__0");
			builder.put(grammarAccess.getPrefixedExpAccess().getGroup_0(), "rule__PrefixedExp__Group_0__0");
			builder.put(grammarAccess.getPrimaryExpAccess().getGroup_1(), "rule__PrimaryExp__Group_1__0");
			builder.put(grammarAccess.getPrimaryExpAccess().getGroup_1_1(), "rule__PrimaryExp__Group_1_1__0");
			builder.put(grammarAccess.getNestedExpAccess().getGroup(), "rule__NestedExp__Group__0");
			builder.put(grammarAccess.getSelfExpAccess().getGroup(), "rule__SelfExp__Group__0");
			builder.put(grammarAccess.getCollectionIteratorAccess().getGroup(), "rule__CollectionIterator__Group__0");
			builder.put(grammarAccess.getIteratorVarDeclarationAccess().getGroup_1(), "rule__IteratorVarDeclaration__Group_1__0");
			builder.put(grammarAccess.getMethodCallAccess().getGroup_0(), "rule__MethodCall__Group_0__0");
			builder.put(grammarAccess.getMethodCallAccess().getGroup_1(), "rule__MethodCall__Group_1__0");
			builder.put(grammarAccess.getTypeCallAccess().getGroup(), "rule__TypeCall__Group__0");
			builder.put(grammarAccess.getTypeExpAccess().getGroup_0(), "rule__TypeExp__Group_0__0");
			builder.put(grammarAccess.getTypeExpAccess().getGroup_1(), "rule__TypeExp__Group_1__0");
			builder.put(grammarAccess.getUnaryTemporalExpAccess().getGroup(), "rule__UnaryTemporalExp__Group__0");
			builder.put(grammarAccess.getTemporalAsLongAsAccess().getGroup(), "rule__TemporalAsLongAs__Group__0");
			builder.put(grammarAccess.getTemporalUntilAccess().getGroup(), "rule__TemporalUntil__Group__0");
			builder.put(grammarAccess.getTemporalEverytimeAccess().getGroup(), "rule__TemporalEverytime__Group__0");
			builder.put(grammarAccess.getTemporalAtLeastOnceAccess().getGroup(), "rule__TemporalAtLeastOnce__Group__0");
			builder.put(grammarAccess.getLegacyUntilAccess().getGroup(), "rule__LegacyUntil__Group__0");
			builder.put(grammarAccess.getLegacyAsSoonAsAccess().getGroup(), "rule__LegacyAsSoonAs__Group__0");
			builder.put(grammarAccess.getLegacyEverytimeAccess().getGroup(), "rule__LegacyEverytime__Group__0");
			builder.put(grammarAccess.getPathAccess().getGroup(), "rule__Path__Group__0");
			builder.put(grammarAccess.getPathAccess().getGroup_1(), "rule__Path__Group_1__0");
			builder.put(grammarAccess.getArgumentsExpAccess().getGroup(), "rule__ArgumentsExp__Group__0");
			builder.put(grammarAccess.getArgumentsExpAccess().getGroup_1(), "rule__ArgumentsExp__Group_1__0");
			builder.put(grammarAccess.getModelAccess().getConstraintsAssignment(), "rule__Model__ConstraintsAssignment");
			builder.put(grammarAccess.getConstraintAccess().getNameAssignment_1(), "rule__Constraint__NameAssignment_1");
			builder.put(grammarAccess.getConstraintAccess().getDescriptionAssignment_3_1(), "rule__Constraint__DescriptionAssignment_3_1");
			builder.put(grammarAccess.getConstraintAccess().getOverrulableAssignment_4_2(), "rule__Constraint__OverrulableAssignment_4_2");
			builder.put(grammarAccess.getConstraintAccess().getContextAssignment_6(), "rule__Constraint__ContextAssignment_6");
			builder.put(grammarAccess.getConstraintAccess().getExpressionAssignment_8(), "rule__Constraint__ExpressionAssignment_8");
			builder.put(grammarAccess.getContextAccess().getNameAssignment(), "rule__Context__NameAssignment");
			builder.put(grammarAccess.getExpAccess().getOperatorsAssignment_1_1(), "rule__Exp__OperatorsAssignment_1_1");
			builder.put(grammarAccess.getExpAccess().getExpressionsAssignment_1_2(), "rule__Exp__ExpressionsAssignment_1_2");
			builder.put(grammarAccess.getExpAccess().getOperatorsAssignment_1_3_0(), "rule__Exp__OperatorsAssignment_1_3_0");
			builder.put(grammarAccess.getExpAccess().getExpressionsAssignment_1_3_1(), "rule__Exp__ExpressionsAssignment_1_3_1");
			builder.put(grammarAccess.getPrefixedExpAccess().getOperatorAssignment_0_1(), "rule__PrefixedExp__OperatorAssignment_0_1");
			builder.put(grammarAccess.getPrefixedExpAccess().getExpressionAssignment_0_2(), "rule__PrefixedExp__ExpressionAssignment_0_2");
			builder.put(grammarAccess.getBooleanOperatorAccess().getOpAssignment(), "rule__BooleanOperator__OpAssignment");
			builder.put(grammarAccess.getMathOperatorAccess().getOpAssignment(), "rule__MathOperator__OpAssignment");
			builder.put(grammarAccess.getNavigationOperatorAccess().getNameAssignment(), "rule__NavigationOperator__NameAssignment");
			builder.put(grammarAccess.getUnaryOperatorAccess().getNameAssignment(), "rule__UnaryOperator__NameAssignment");
			builder.put(grammarAccess.getPrimaryExpAccess().getNavAssignment_1_1_0(), "rule__PrimaryExp__NavAssignment_1_1_0");
			builder.put(grammarAccess.getPrimaryExpAccess().getMethodsAssignment_1_1_1(), "rule__PrimaryExp__MethodsAssignment_1_1_1");
			builder.put(grammarAccess.getNestedExpAccess().getSourceAssignment_1(), "rule__NestedExp__SourceAssignment_1");
			builder.put(grammarAccess.getSelfExpAccess().getNameAssignment_1(), "rule__SelfExp__NameAssignment_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getNameAssignment(), "rule__VarDeclaration__NameAssignment");
			builder.put(grammarAccess.getVarReferenceAccess().getRefAssignment(), "rule__VarReference__RefAssignment");
			builder.put(grammarAccess.getIntLiteralExpAccess().getValueAssignment(), "rule__IntLiteralExp__ValueAssignment");
			builder.put(grammarAccess.getStringLiteralExpAccess().getValueAssignment(), "rule__StringLiteralExp__ValueAssignment");
			builder.put(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_0(), "rule__BooleanLiteralExp__ValueAssignment_0");
			builder.put(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_1(), "rule__BooleanLiteralExp__ValueAssignment_1");
			builder.put(grammarAccess.getFloatLiteralExpAccess().getValueAssignment(), "rule__FloatLiteralExp__ValueAssignment");
			builder.put(grammarAccess.getCollectionIteratorAccess().getNameAssignment_0(), "rule__CollectionIterator__NameAssignment_0");
			builder.put(grammarAccess.getCollectionIteratorAccess().getItervarAssignment_2(), "rule__CollectionIterator__ItervarAssignment_2");
			builder.put(grammarAccess.getCollectionIteratorAccess().getBodyAssignment_4(), "rule__CollectionIterator__BodyAssignment_4");
			builder.put(grammarAccess.getIteratorNameAccess().getNameAssignment(), "rule__IteratorName__NameAssignment");
			builder.put(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_0(), "rule__IteratorVarDeclaration__NameAssignment_0");
			builder.put(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_1_0(), "rule__IteratorVarDeclaration__NameAssignment_1_0");
			builder.put(grammarAccess.getIteratorVarDeclarationAccess().getTypeAssignment_1_2(), "rule__IteratorVarDeclaration__TypeAssignment_1_2");
			builder.put(grammarAccess.getPropertyAccessAccess().getNameAssignment(), "rule__PropertyAccess__NameAssignment");
			builder.put(grammarAccess.getMethodCallAccess().getNameAssignment_0_0(), "rule__MethodCall__NameAssignment_0_0");
			builder.put(grammarAccess.getMethodCallAccess().getNameAssignment_1_0(), "rule__MethodCall__NameAssignment_1_0");
			builder.put(grammarAccess.getMethodCallAccess().getArgsAssignment_1_2(), "rule__MethodCall__ArgsAssignment_1_2");
			builder.put(grammarAccess.getTypeCallAccess().getNameAssignment_0(), "rule__TypeCall__NameAssignment_0");
			builder.put(grammarAccess.getTypeCallAccess().getTypeAssignment_2(), "rule__TypeCall__TypeAssignment_2");
			builder.put(grammarAccess.getTypeExpAccess().getNameAssignment_0_2(), "rule__TypeExp__NameAssignment_0_2");
			builder.put(grammarAccess.getTypeExpAccess().getCollectionTypeAssignment_1_0(), "rule__TypeExp__CollectionTypeAssignment_1_0");
			builder.put(grammarAccess.getTypeExpAccess().getTypeAssignment_1_1(), "rule__TypeExp__TypeAssignment_1_1");
			builder.put(grammarAccess.getCollectionTypeIdentifierAccess().getNameAssignment(), "rule__CollectionTypeIdentifier__NameAssignment");
			builder.put(grammarAccess.getUnaryTemporalExpAccess().getNameAssignment_0(), "rule__UnaryTemporalExp__NameAssignment_0");
			builder.put(grammarAccess.getUnaryTemporalExpAccess().getExpAssignment_2(), "rule__UnaryTemporalExp__ExpAssignment_2");
			builder.put(grammarAccess.getTemporalAsLongAsAccess().getNameAssignment_0(), "rule__TemporalAsLongAs__NameAssignment_0");
			builder.put(grammarAccess.getTemporalAsLongAsAccess().getBAssignment_2(), "rule__TemporalAsLongAs__BAssignment_2");
			builder.put(grammarAccess.getTemporalAsLongAsAccess().getAAssignment_4(), "rule__TemporalAsLongAs__AAssignment_4");
			builder.put(grammarAccess.getTemporalUntilAccess().getNameAssignment_0(), "rule__TemporalUntil__NameAssignment_0");
			builder.put(grammarAccess.getTemporalUntilAccess().getAAssignment_2(), "rule__TemporalUntil__AAssignment_2");
			builder.put(grammarAccess.getTemporalUntilAccess().getBAssignment_4(), "rule__TemporalUntil__BAssignment_4");
			builder.put(grammarAccess.getTemporalEverytimeAccess().getNameAssignment_0(), "rule__TemporalEverytime__NameAssignment_0");
			builder.put(grammarAccess.getTemporalEverytimeAccess().getAAssignment_2(), "rule__TemporalEverytime__AAssignment_2");
			builder.put(grammarAccess.getTemporalEverytimeAccess().getBAssignment_4(), "rule__TemporalEverytime__BAssignment_4");
			builder.put(grammarAccess.getTemporalAtLeastOnceAccess().getNameAssignment_0(), "rule__TemporalAtLeastOnce__NameAssignment_0");
			builder.put(grammarAccess.getTemporalAtLeastOnceAccess().getAAssignment_2(), "rule__TemporalAtLeastOnce__AAssignment_2");
			builder.put(grammarAccess.getTemporalAtLeastOnceAccess().getBAssignment_4(), "rule__TemporalAtLeastOnce__BAssignment_4");
			builder.put(grammarAccess.getLegacyUntilAccess().getNameAssignment_0(), "rule__LegacyUntil__NameAssignment_0");
			builder.put(grammarAccess.getLegacyUntilAccess().getAAssignment_2(), "rule__LegacyUntil__AAssignment_2");
			builder.put(grammarAccess.getLegacyUntilAccess().getBAssignment_4(), "rule__LegacyUntil__BAssignment_4");
			builder.put(grammarAccess.getLegacyAsSoonAsAccess().getNameAssignment_0(), "rule__LegacyAsSoonAs__NameAssignment_0");
			builder.put(grammarAccess.getLegacyAsSoonAsAccess().getAAssignment_2(), "rule__LegacyAsSoonAs__AAssignment_2");
			builder.put(grammarAccess.getLegacyAsSoonAsAccess().getBAssignment_4(), "rule__LegacyAsSoonAs__BAssignment_4");
			builder.put(grammarAccess.getLegacyEverytimeAccess().getNameAssignment_0(), "rule__LegacyEverytime__NameAssignment_0");
			builder.put(grammarAccess.getLegacyEverytimeAccess().getAAssignment_2(), "rule__LegacyEverytime__AAssignment_2");
			builder.put(grammarAccess.getLegacyEverytimeAccess().getBAssignment_4(), "rule__LegacyEverytime__BAssignment_4");
			builder.put(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_0(), "rule__ArgumentsExp__OperatorsAssignment_0");
			builder.put(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_1_1(), "rule__ArgumentsExp__OperatorsAssignment_1_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private OCLXGrammarAccess grammarAccess;

	@Override
	protected InternalOCLXParser createParser() {
		InternalOCLXParser result = new InternalOCLXParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public OCLXGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OCLXGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
