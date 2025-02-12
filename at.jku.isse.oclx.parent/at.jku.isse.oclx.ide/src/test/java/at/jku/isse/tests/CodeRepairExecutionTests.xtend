package at.jku.isse.tests

import at.jku.isse.ide.assistance.CodeActionExecuter
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.junit.jupiter.api.BeforeAll
import at.jku.isse.passiveprocessengine.core.SchemaRegistry
import at.jku.isse.OCLXTestArtifacts
import at.jku.isse.designspace.artifactconnector.core.repository.CoreTypeFactory

@ExtendWith(InjectionExtension)
@InjectWith(OCLXInjectorProvider)
class CodeRepairExecutionTests {
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	IResourceFactory resourceFactory;
	
	@Inject
	InvariantChecker invariantChecker;
	
	@Inject
	ICodeActionService2 repairService
	
	@Inject
	SchemaRegistry schemaRegistry
	
	@Test
	def void testRepairPropertyViaSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesSingle.referencesGroup.size() > 0 }
		'''
		
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		
		Assertions.assertTrue(isCorrect(repaired));
	}
	
	@Test
	def void testRepairPropertyViaCollectionMethodSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup.any().referencesGroup.size() > 0 }
		'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		//TODO select after any, rather than before
		Assertions.assertTrue(isCorrect(repaired));
	}
	
		@Test
	def void testRepairPropertyViaCollectionReductionMethodSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup.asList().first().referencesGroup.size() > 0 }
		'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		// self.referencesGroup.asList().first()->SELECT(object | object.isKindOf(<DemoIssue>).referencesGroup.size() > 0 
		
		// TODO: select statement added before property, instead of before list
		Assertions.assertTrue(isCorrect(repaired));
	}
	
		@Test
	def void testRepairPropertyViaContextSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: Artifact expression: self.referencesGroup.size() > 0 }
		'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		
		Assertions.assertTrue(isCorrect(repaired));
	}
	
	@Test
	def void testRepairSetPropertyViaSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup->forAll(issue | issue.bugs.size() > 0) }
		'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		// TODO Wrong position of SELECT -> is before property, but needs to be before iterator
		Assertions.assertTrue(isCorrect(repaired));
	}
	
	@Test
	def void testRepairOfCollectionMethodViaReplacement() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup.sizes() > 0 }
		'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		
		Assertions.assertTrue(isCorrect(repaired));
	}
	
		@Test
	def void testRepairOfSingleMethodViaReplacement() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.state.chars().size() = 1 }
		'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		
		Assertions.assertTrue(isCorrect(repaired));
	}
	
		@Test
	def void testRepairOfDuplicateIterVar() {
		var content = '''rule TestRule2 {  description: "just some test" context: DemoIssue  expression: (self.downstream->exists(req | req.bugs.size() > 0) and self->isDefined() and self.downstream->forAll( req | req.bugs.isEmpty() ) ) }'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		
		Assertions.assertTrue(isCorrect(repaired));
	}
	
	@Test
	def void testRepairOfDuplicateIterVar2() {
		var content = '''rule TestRule2 {  description: "just some test" context: DemoIssue  expression: self.downstream->select(req | req.bugs.size() > 0)->forAll( req | req.bugs.isEmpty() ) }'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		
		Assertions.assertTrue(isCorrect(repaired));
	}
	
	@Test
	def void testIgnoreSyntaxError() {
		var content = '''rule TestRule2 {  description: "just some test" context: DemoIssue  expression: self.downstream->exists(req | req.isTypeOf(REQ) ) }'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		Assertions.assertNull(repaired);
	}
	
		@Test
	def void testSimilarTypeReplaced() {
		var baseType =  schemaRegistry.getTypeByName(CoreTypeFactory.BASE_TYPE_NAME);
		schemaRegistry.createNewInstanceType(OCLXTestArtifacts.TYPEPREFIX+"XXXXX", baseType);	
		
		var content = '''rule TestRule2 {  description: "just some test" context: DemoIssue  expression: self.downstream->exists(req | req.isTypeOf(<Issue>) ) }'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		Assertions.assertTrue(isCorrect(repaired));
	}
	
			@Test
	def void testExactTypeReplaced() {
		var content = '''rule TestRule2 {  description: "just some test" context: DemoIssue  expression: self.downstream->exists(req | req.isTypeOf(<DemoIssue>) ) }'''
		var executer = new CodeActionExecuter(content, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		Assertions.assertTrue(executer.problems.size() > 0);
		
		executer.executeFirstExecutableRepair();		
		Assertions.assertNotNull(executer.executedCodeAction);
		
		var repaired = executer.repairedOclxConstraint;
		System.out.println(executer.executedCodeAction);
		System.out.println(repaired);
		Assertions.assertTrue(isCorrect(repaired));
	}
	
	def isCorrect(String constraint) {
		var executer = new CodeActionExecuter(constraint, resourceSetProvider, resourceFactory, invariantChecker, repairService);
		executer.checkForIssues();
		return executer.problems.isEmpty();
	}
	

}