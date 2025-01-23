package at.jku.isse.tests

import com.google.inject.Inject
import org.eclipse.lsp4j.CompletionParams
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.hover.HoverService
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.lsp4j.HoverParams
import org.eclipse.lsp4j.Hover

@ExtendWith(InjectionExtension)
@InjectWith(OCLXInjectorProvider)
class HoverOverTests extends AbstractContentAssistTest{
	
	@Inject
	HoverService hoverService
	
			@Test
	def void hoverOverSelfTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self }
		'''
		val hovers = getHoverOver(text, -4, 1)
		System.out.println(hovers)
		Assertions.assertTrue(assertHoverHas("DemoIssue", hovers))
	}
	
	
		@Test
	def void hoverOverRefTest() {
		val text = '''rule TestRule {description: "ignored" 	context: DemoIssue 	
		expression: self.requirements->forAll(req | req )}
		'''
		val hovers = getHoverOver(text, -5, 1)
		System.out.println(hovers)
		Assertions.assertTrue(assertHoverHas("DemoIssue", hovers))
	}
	
	def assertHoverHas(String expectedHoverText, Hover hoverInfo) {
		return hoverInfo.contents.getRight().value.equalsIgnoreCase(expectedHoverText)
	}
	
	
	def getHoverOver(String text, int position) {
		return getHoverOver(text, position, 0);
	}
	
	def getHoverOver(String text, int position, int zeroIndexedRow) {
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
		return hoverService.hover(new Document(1, text), result,
			new HoverParams(new TextDocumentIdentifier(result.URI.toString),
				new Position(zeroIndexedRow, positionVal)), null)
	}
	
	def getLine(String text, int zeroIndexedRow) {
		val lines = text.split(System.lineSeparator());
		return lines.get(zeroIndexedRow)
	}
}