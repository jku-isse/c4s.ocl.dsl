package at.jku.isse.tests;

import com.google.inject.Inject;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.HoverParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.hover.HoverService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(OCLXInjectorProvider.class)
@SuppressWarnings("all")
public class HoverOverTests extends AbstractContentAssistTest {
  @Inject
  private HoverService hoverService;

  @Test
  public void hoverOverSelfTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self }");
    _builder.newLine();
    final String text = _builder.toString();
    final Hover hovers = this.getHoverOver(text, (-4), 1);
    System.out.println(hovers);
    Assertions.assertTrue(this.assertHoverHas("DemoIssue", hovers));
  }

  @Test
  public void hoverOverRefTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.requirements->forAll(req | req )}");
    _builder.newLine();
    final String text = _builder.toString();
    final Hover hovers = this.getHoverOver(text, (-5), 1);
    System.out.println(hovers);
    Assertions.assertTrue(this.assertHoverHas("DemoIssue", hovers));
  }

  public boolean assertHoverHas(final String expectedHoverText, final Hover hoverInfo) {
    return hoverInfo.getContents().getRight().getValue().equalsIgnoreCase(expectedHoverText);
  }

  public Hover getHoverOver(final String text, final int position) {
    return this.getHoverOver(text, position, 0);
  }

  public Hover getHoverOver(final String text, final int position, final int zeroIndexedRow) {
    try {
      String lineText = text;
      int positionVal = position;
      if ((zeroIndexedRow > 0)) {
        lineText = this.getLine(text, zeroIndexedRow);
      }
      if ((positionVal < 0)) {
        int _length = lineText.length();
        int _plus = (_length + positionVal);
        positionVal = _plus;
      }
      final XtextResource result = this.parse(text);
      Assertions.assertNotNull(result);
      Document _document = new Document(Integer.valueOf(1), text);
      String _string = result.getURI().toString();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(_string);
      Position _position = new Position(zeroIndexedRow, positionVal);
      HoverParams _hoverParams = new HoverParams(_textDocumentIdentifier, _position);
      return this.hoverService.hover(_document, result, _hoverParams, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public String getLine(final String text, final int zeroIndexedRow) {
    final String[] lines = text.split(System.lineSeparator());
    return lines[zeroIndexedRow];
  }
}
