package at.jku.isse.tests

import com.google.inject.Inject
import org.eclipse.lsp4j.CompletionParams
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ResourceHelper
import org.eclipse.lsp4j.CompletionList

@ExtendWith(InjectionExtension)
//@RunWith(XtextRunner)
@InjectWith(OCLXInjectorProvider)
class OclxContentAssistTests extends AbstractContentAssistTest{
	
	@Inject
	ContentAssistService contentAssistService
	
	
	@Test
	def void loadEmptyModel() {
		val text = ''' 
		'''
		val completions = getCompletions(text, 0)
		System.out.println(completions)
		
	}
	
	@Test
	def void loadEmptyContext() {
		val text = '''rule someid { context: }
		'''
		val completions = getCompletions(text, -3)
		System.out.println(completions)
	}
	
	@Test
	def void completeFromSelfTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	expression: self }
		'''
		val completions = getCompletions(text, -3)
		System.out.println(completions)
		Assertions.assertTrue(assertCompletionContainsProposal(completions, "bugs"))
	}
	
	@Test
	def void completeFromSelfNavTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	expression: self. }
		'''
		val completions = getCompletions(text, -3)
		System.out.println(completions)
		Assertions.assertTrue(assertCompletionContainsProposal(completions, "bugs"))
	}
	
		@Test
	def void completeFromPropertyNavTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.requirements. }
		'''
		val completions = getCompletions(text, -2, 1)
		System.out.println(completions)
		Assertions.assertFalse(assertCompletionContainsProposal(completions, "bugs"))
	}
	
			@Test
	def void completeFromPropertyNavEndTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.requirements. }
		'''
		val completions = getCompletions(text, -1, 1)
		System.out.println(completions)
		Assertions.assertFalse(assertCompletionContainsProposal(completions, "EXISTS"))
	}
	
			@Test
	def void completeFromPropertyCollectionNavTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.requirements-> }
		'''
		val completions = getCompletions(text, -2, 1)
		System.out.println(completions)
		Assertions.assertTrue(assertCompletionContainsProposal(completions, "EXISTS"))
	}
	
				@Test
	def void completeFromPropertyWithinCollectionNavTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.requirements-> }
		'''
		val completions = getCompletions(text, -3, 1)
		System.out.println(completions)
		Assertions.assertFalse(assertCompletionContainsProposal(completions, "EXISTS"))
	}
	
	@Test
	def void completeFromPropertyTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.requirements }
		'''
		val completions = getCompletions(text, -2, 1)
		System.out.println(completions);
		Assertions.assertTrue(assertCompletionContainsProposal(completions, "->"))
		
		//TODO ensure no use of "."
	}
	
		@Test
	def void completeFromPartialPropertyTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.req }
		'''
		val completions = getCompletions(text, -3, 1)
		System.out.println(completions)
		Assertions.assertTrue(assertCompletionContainsProposal(completions, "bugs"))
	}
	
		@Test
	def void completeFromRefTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.requirements->FORALL(req | req. )}
		'''
		val completions = getCompletions(text, -3, 1)
		System.out.println(completions)
		Assertions.assertTrue(assertCompletionContainsProposal(completions, "bugs"))
	}
	
	def getCompletions(String text, int position) {
		return getCompletions(text, position, 0);
	}
	
	def getCompletions(String text, int position, int zeroIndexedRow) {
		var lineText = text
		var positionVal = position
		if (zeroIndexedRow > 0) {
			lineText = getLine(text, zeroIndexedRow)
		}
		if (positionVal < 0) {
			positionVal = lineText.length + positionVal
		}
		val result = parse(text)
		Assertions.assertNotNull(result)
		return contentAssistService.createCompletionList(new Document(1, text), result,
			new CompletionParams(new TextDocumentIdentifier(result.URI.toString),
				new Position(zeroIndexedRow, positionVal)), null)
	}
	
	def getLine(String text, int zeroIndexedRow) {
		val lines = text.split(System.lineSeparator());
		return lines.get(zeroIndexedRow)
	}
	
	def assertCompletionContainsProposal(CompletionList completions, String text) {
		return completions.items.stream.anyMatch(completion |
			completion.label == text
		)
	}
}