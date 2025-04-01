package at.jku.isse.tests;

import at.jku.isse.OCLXTestArtifacts;
import at.jku.isse.designspace.artifactconnector.core.repository.CoreTypeFactory;
import at.jku.isse.ide.assistance.CodeActionExecuter;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(OCLXInjectorProvider.class)
@SuppressWarnings("all")
public class CodeRepairExecutionTests {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;

  @Inject
  private IResourceFactory resourceFactory;

  @Inject
  private InvariantChecker invariantChecker;

  @Inject
  private ICodeActionService2 repairService;

  @Inject
  private SchemaRegistry schemaRegistry;

  @Test
  public void testRepairPropertyViaSubtyping() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesSingle.referencesGroup.size() > 0 }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairPropertyViaCollectionMethodSubtyping() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup.any().referencesGroup.size() > 0 }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairPropertyViaCollectionMethodSubtyping2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup->any().referencesGroup.size() > 0 }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairPropertyViaCollectionReductionMethodSubtyping() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup.asList().first().referencesGroup.size() > 0 }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairPropertyViaContextSubtyping() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: Artifact expression: self.referencesGroup.size() > 0 }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairSetPropertyViaSubtyping() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup->forAll(issue | issue.bugs.size() > 0) }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairSetPropertyViaSubtyping2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup.forAll(issue | issue->bugs.size() > 0) }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairOfCollectionMethodViaReplacement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.referencesGroup.sizes() > 0 }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairOfSingleMethodViaReplacement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule { description: \"testing\" context: DemoIssue expression: self.state.chars().size() = 1 }");
    _builder.newLine();
    final String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairOfDuplicateIterVar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule2 {  description: \"just some test\" context: DemoIssue  expression: (self.downstream->exists(req | req.bugs.size() > 0) and self->isDefined() and self.downstream->forAll( req | req.bugs.isEmpty() ) ) }");
    String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testRepairOfDuplicateIterVar2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule2 {  description: \"just some test\" context: DemoIssue  expression: self.downstream->select(req | req.bugs.size() > 0)->forAll( req | req.bugs.isEmpty() ) }");
    String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testIgnoreSyntaxError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule2 {  description: \"just some test\" context: DemoIssue  expression: self.downstream->exists(req | req.isTypeOf(REQ) ) }");
    String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    Assertions.assertNull(repaired);
  }

  @Test
  public void testSimilarTypeReplaced() {
    PPEInstanceType baseType = this.schemaRegistry.getTypeByName(CoreTypeFactory.BASE_TYPE_NAME);
    this.schemaRegistry.createNewInstanceType((OCLXTestArtifacts.TYPEPREFIX + "XXXXX"), baseType);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule2 {  description: \"just some test\" context: DemoIssue  expression: self.downstream->exists(req | req.isTypeOf(<Issue>) ) }");
    String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testExactTypeReplaced() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule2 {  description: \"just some test\" context: DemoIssue  expression: self.downstream->exists(req | req.isTypeOf(<DemoIssue>) ) }");
    String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testPlaceTypeInBracketsWithinIterator() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule2 { description: \"just some test\" context: DemoIssue expression: (self.downstream->exists(req : | req.bugs.size() > 0)) }");
    String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(this.isCorrect(repaired));
  }

  @Test
  public void testPlaceTypeInBracketsWithinIterator2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule2 { description: \"just some test\" context: DemoIssue expression: (self.downstream->exists(req : DemoIssue | req.bugs.size() > 0)) }");
    String content = _builder.toString();
    CodeActionExecuter executer = new CodeActionExecuter(content, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    int _size = executer.getProblems().size();
    boolean _greaterThan = (_size > 0);
    Assertions.assertTrue(_greaterThan);
    executer.executeFirstExecutableRepair();
    Assertions.assertNotNull(executer.getExecutedCodeAction());
    String repaired = executer.getRepairedOclxConstraint();
    System.out.println(executer.getExecutedCodeAction());
    System.out.println(repaired);
    Assertions.assertTrue(repaired.contains("<DemoIssue>"));
  }

  public boolean isCorrect(final String constraint) {
    CodeActionExecuter executer = new CodeActionExecuter(constraint, this.resourceSetProvider, this.resourceFactory, this.invariantChecker, this.repairService);
    executer.checkForIssues();
    return executer.getProblems().isEmpty();
  }
}
