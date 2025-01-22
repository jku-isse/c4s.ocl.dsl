/**
 * generated by Xtext 2.34.0
 */
package at.jku.isse.tests;

import at.jku.isse.oclx.Model;
import at.jku.isse.oclx.OclxPackage;
import at.jku.isse.validation.OCLXValidator;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(OCLXInjectorProvider.class)
@SuppressWarnings("all")
public class OCLXParsingTest {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  private ValidationTestHelper validationTestHelper;

  @Test
  public void loadAtomicContextFail() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"ignored\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: STRING");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: self.isDefined() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.CONSTRAINT, 
        OCLXValidator.UNKNOWN_TYPE);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void loadKnownContext() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"ignored\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: self.isDefined() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void loadUnknownContext() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"ignored\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: noSuchType");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: self.isDefined() ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.CONSTRAINT, 
        OCLXValidator.UNKNOWN_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void loadSyntacticCorrectSmallModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing a better way to provide a description");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("to a rule\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("is overrulable: false");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* some comment here */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: not(self->FORALL(x : <test/type/decl> | x.isDefined() ) )");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void loadDuplicateVarDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule AnotherRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: nosu");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: self.downstream->FORALL(x | (x.isDefined() ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append("and ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append("self->EXISTS( x | x.size() > 0)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append(") ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t");
      _builder.append(")  ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.ITERATOR_VAR_DECLARATION, 
        OCLXValidator.DUPLICATE_VAR_NAME);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void loadDuplicateVarDeclaration2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule2 {");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("description: \"just some test\"");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("is overrulable: false");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("expression: ( ");
      _builder.newLine();
      _builder.append("\t            ");
      _builder.append("self.downstream ");
      _builder.newLine();
      _builder.append("\t                ");
      _builder.append("->EXISTS(req | req.bugs.size() > 0)");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("and ");
      _builder.newLine();
      _builder.append("\t            ");
      _builder.append("self->isDefined()");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("and self.downstream->FORALL( req |  req.isEmpty() )  )");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.ITERATOR_VAR_DECLARATION, 
        OCLXValidator.DUPLICATE_VAR_NAME);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void loadKnownPropertyUsage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"ignored\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: self.requirements.size() > 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFindUnknownTypeDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: not(self.requirements->FORALL(x : <test/type/decl> | x.isDefined() ) )");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.TYPE_EXP, 
        OCLXValidator.UNKNOWN_TYPE);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFindKnownTypeDeclaration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: not(self.requirements->FORALL(x : <root/types/DemoIssue> | x.parent <> null ) )");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testUpcastVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: artifact");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: self.asType(<root/types/DemoIssue>).requirements.size() > 0 ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDowncastVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: self.asType(<root/types/artifact>).requirements.size() > 0 ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
        OCLXValidator.UNKNOWN_PROPERTY);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTemporalNestedReturnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: next(self.requirements) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.EXP, 
        OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTriggeredTemporalNestedReturnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: everyTime(self.requirements then self.requirements.size() > 0)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.EXP, 
        OCLXValidator.INCOMPATIBLE_RETURN_TYPE);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTriggeredTemporalNestedReturnTypeSuccess() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: asLongAs(self.requirements.isEmpty() ensureThat self.requirements.size() > 0)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testCommentInlineSuccess() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description: \"testing\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("context: DemoIssue");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("expression: asLongAs(self.requirements.isEmpty()  // this is just for testing, does not make sense");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ensureThat self.requirements.size() > 0) // as this can never be true");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      boolean _isEmpty = errors.isEmpty();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: ");
      String _join = IterableExtensions.join(errors, ", \r\n");
      _builder_1.append(_join);
      Assertions.assertTrue(_isEmpty, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testPropertyInSubclass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesSingle.referencesGroup.size() > 0 }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
        OCLXValidator.UNKNOWN_PROPERTY);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testPropertyInSubclass2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup.any().referencesGroup.size() > 0 }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
        OCLXValidator.UNKNOWN_PROPERTY);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testPropertyInSubclassViaIterator() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup->FORALL(issue | issue.bugs.size() > 0) }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
        OCLXValidator.UNKNOWN_PROPERTY);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testUnknownOperation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesSingle.siz() > 0 }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.METHOD_CALL_EXP, 
        OCLXValidator.UNKNOWN_OPERATION);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleSingleInputToCollectionOperation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesSingle.size() > 0 }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.METHOD_CALL_EXP, 
        OCLXValidator.INCOMPATIBLE_INPUT_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleCollectionInputToSingleOperation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup.toString() > 0 }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.METHOD_CALL_EXP, 
        OCLXValidator.INCOMPATIBLE_INPUT_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleIteratorInputToSingleOperation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup->SELECT(x | x.isDefined()).toString() > 0 }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.METHOD_CALL_EXP, 
        OCLXValidator.INCOMPATIBLE_INPUT_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIncompatibleSingleInputToIterator() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesSingle->FORALL(x | x.isDefined() ) }");
      _builder.newLine();
      final String content = _builder.toString();
      final Model result = this.parseHelper.parse(content);
      Assertions.assertNotNull(result);
      this.validationTestHelper.assertError(result, 
        OclxPackage.Literals.ITERATOR_EXP, 
        OCLXValidator.INCOMPATIBLE_INPUT_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
