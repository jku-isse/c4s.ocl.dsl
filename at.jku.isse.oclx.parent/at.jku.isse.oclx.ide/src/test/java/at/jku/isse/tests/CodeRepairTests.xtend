package at.jku.isse.tests

import at.jku.isse.oclx.Model
import at.jku.isse.oclx.OclxPackage
import at.jku.isse.validation.OCLXValidator
import com.google.inject.Inject
import org.eclipse.lsp4j.CodeActionContext
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2.Options
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.apache.commons.text.similarity.JaroWinklerSimilarity

@ExtendWith(InjectionExtension)
@InjectWith(OCLXInjectorProvider)
class CodeRepairTests extends AbstractContentAssistTest{
	
	@Inject
	ParseHelper<Model> parseHelper
	
	@Inject ValidationTestHelper validationTestHelper
	
	@Inject
	ICodeActionService2 repairService
	
//			@Test
//	def void hoverOverSelfTest() {
//		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
//		expression: self }
//		'''
//		val completions = getHoverOver(text, -4, 1)
//		System.out.println(completions);
//	}
	
	
//		@Test
//	def void hoverOverRefTest() {
//		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
//		expression: self.requirements->forAll(req | req )}
//		'''
//		val completions = getHoverOver(text, -5, 1)
//		System.out.println(completions);
//	}

	@Test
	def void testSimilarity() {
		printSim("sizes", "size");
		printSim("chars", "characters");
		printSim("process", "predecessorItems");
		
		printSim("b", "bug");
		printSim("b", "cub");
		printSim("child", "sharedsteps");
	}
	
	def printSim(String a, String b) {
		System.out.println(String.format("%s %s sim: %s", a, b, new JaroWinklerSimilarity().apply(a, b)));
	}
	

	@Test
	def void testRepairProperty() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.downstre.size() > 0 }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
			OCLXValidator.UNKNOWN_PROPERTY
		);
	
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		//TODO fix
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("downstream"))
	}
	
	@Test
	def void testRepairPropertyViaSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesSingle.referencesGroup.size() > 0 }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
			OCLXValidator.UNKNOWN_PROPERTY
		);
	
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("DemoIssue"))
	}
	
	@Test
	def void testRepairPropertyViaCollectionMethodSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup.any().referencesGroup.size() > 0 }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
			OCLXValidator.UNKNOWN_PROPERTY
		);
		
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("DemoIssue"))
	}
	
		@Test
	def void testRepairPropertyViaCollectionReductionMethodSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup.asList().first().referencesGroup.size() > 0 }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
			OCLXValidator.UNKNOWN_PROPERTY
		);

		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("DemoIssue"))
	}
	
		@Test
	def void testRepairPropertyViaContextSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: Artifact expression: self.referencesSingle.referencesGroup.size() > 0 }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
			OCLXValidator.UNKNOWN_PROPERTY
		);
	
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("specialized context"))
	}
	
	@Test
	def void testRepairSetPropertyViaSubtyping() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup->forAll(issue | issue.bugs.size() > 0) }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
			OCLXValidator.UNKNOWN_PROPERTY
		);
	
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("DemoIssue"))
	}
	
	@Test
	def void testRepairOfCollectionMethodViaReplacement() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.referencesGroup.sizes() > 0 }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.METHOD_CALL_EXP, 
			OCLXValidator.UNKNOWN_OPERATION
		);
	
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		//TODO fix
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("size"))
	}
	
		@Test
	def void testRepairOfSingleMethodViaReplacement() {
		val content = '''
			rule TestRule { description: "testing" context: DemoIssue expression: self.state.chars().size() = 1 }
		'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.METHOD_CALL_EXP, 
			OCLXValidator.UNKNOWN_OPERATION
		);
	//TODO fix
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("characters"))
	}
	
		@Test
	def void testRepairOfDuplicateIterVar() {
		var content = '''rule TestRule2 {
	    description: "just some test"
	    is overrulable: false
	    context: DemoIssue
	    expression: ( 
	            self.downstream 
	                ->exists(req | req.bugs.size() > 0)
	        and 
	            self->isDefined()
	        and self.downstream->forAll( req |  req.isDefined() )  )
	}'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.ITERATOR_VAR_DECLARATION, 
			OCLXValidator.DUPLICATE_VAR_NAME
		);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("req01"))
	}
	
	@Test
	def void testRepairOfIterTypeSyntaxError() {
		var content = '''rule TestRule2 {
	    description: "just some test"	    
	    context: DemoIssue
	    expression: ( 
	            self.downstream 
	                ->exists(req : DemoIssue | req.bugs.size() > 0)
	         )
	}'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertFalse(errors.isEmpty, '''Expected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("< >"))
	}
	
	@Test
	def void testRepairOfIterTypeSyntaxError2() {
		var content = '''rule TestRule2 {
	    description: "just some test"	    
	    context: DemoIssue
	    expression: ( 
	            self.downstream 
	                ->exists(req :DemoIssue | req.bugs.size() > 0)
	         )
	}'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertFalse(errors.isEmpty, '''Expected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains("< >"))
	}
	
	@Test
	def void testRepairOfIterTypeSyntaxError3() {
		var content = '''rule TestRule2 {
	    description: "just some test"	    
	    context: DemoIssue
	    expression: ( 
	            self.downstream 
	                ->exists(req : | req.bugs.size() > 0)
	         )
	}'''
		val result = parseHelper.parse(content)
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertFalse(errors.isEmpty, '''Expected errors: «errors.join(", \r\n")»''')	
		
		val codeActions = error2CodeAction(content, result)
		System.out.println(codeActions)
		Assertions.assertTrue(codeActions.get(0).getRight().title.contains(":"))
	}
	
	
	def error2CodeAction(String content, Model result) {
		val issue = validationTestHelper.validate(result).get(0);
		val range = new Range(new Position(issue.lineNumber-1, issue.column-1), new Position(issue.lineNumberEnd-1, issue.columnEnd-1))
		
		val xresult = parse(content)
		
		val d = new Diagnostic()
		val ctx = new CodeActionContext(#[d])
		d.code = issue.code
		d.severity = DiagnosticSeverity.Error
		d.message = issue.message
		d.range = range
		
		var options = new Options();
		options.document =  new Document(1, content)
		options.resource = xresult
		options.codeActionParams = new CodeActionParams(new TextDocumentIdentifier(xresult.URI.toString), range, ctx)
		return repairService.getCodeActions(options)
	}
	
	

}