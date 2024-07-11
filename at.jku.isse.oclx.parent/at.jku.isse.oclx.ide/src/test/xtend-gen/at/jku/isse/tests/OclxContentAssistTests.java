package at.jku.isse.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.function.Predicate;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService;
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
public class OclxContentAssistTests extends AbstractContentAssistTest {
  @Inject
  private ContentAssistService contentAssistService;

  @Test
  public void loadEmptyModel() {
    StringConcatenation _builder = new StringConcatenation();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, 0);
    System.out.println(completions);
  }

  @Test
  public void loadEmptyContext() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule someid { context: }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-3));
    System.out.println(completions);
  }

  @Test
  public void completeFromSelfTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \texpression: self }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-3));
    System.out.println(completions);
    Assertions.assertFalse(this.assertCompletionContainsProposal(completions, "bugs"));
  }

  @Test
  public void completeFromSelfNavTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \texpression: self. }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-3));
    System.out.println(completions);
    Assertions.assertTrue(this.assertCompletionContainsProposal(completions, "bugs"));
  }

  @Test
  public void completeFromPropertyNavTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.requirements. }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-2), 1);
    System.out.println(completions);
    Assertions.assertFalse(this.assertCompletionContainsProposal(completions, "bugs"));
  }

  @Test
  public void completeFromPropertyNavEndTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.requirements. }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-1), 1);
    System.out.println(completions);
    Assertions.assertFalse(this.assertCompletionContainsProposal(completions, "EXISTS"));
  }

  @Test
  public void completeFromPropertyCollectionNavTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.requirements-> }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-2), 1);
    System.out.println(completions);
    Assertions.assertTrue(this.assertCompletionContainsProposal(completions, "EXISTS"));
  }

  @Test
  public void completeFromPropertyWithinCollectionNavTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.requirements-> }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-3), 1);
    System.out.println(completions);
    Assertions.assertFalse(this.assertCompletionContainsProposal(completions, "EXISTS"));
  }

  @Test
  public void completeFromPropertyTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.requirements }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-2), 1);
    System.out.println(completions);
    Assertions.assertTrue(this.assertCompletionContainsProposal(completions, "->"));
  }

  @Test
  public void completeFromPartialPropertyTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.req }");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-3), 1);
    System.out.println(completions);
    Assertions.assertTrue(this.assertCompletionContainsProposal(completions, "bugs"));
  }

  @Test
  public void completeFromRefTest() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rule TestRule {description: \"ignored\" \tcontext: DemoIssue \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("expression: self.requirements->FORALL(req | req. )}");
    _builder.newLine();
    final String text = _builder.toString();
    final CompletionList completions = this.getCompletions(text, (-3), 1);
    System.out.println(completions);
    Assertions.assertTrue(this.assertCompletionContainsProposal(completions, "bugs"));
  }

  public CompletionList getCompletions(final String text, final int position) {
    return this.getCompletions(text, position, 0);
  }

  public CompletionList getCompletions(final String text, final int position, final int zeroIndexedRow) {
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
      CompletionParams _completionParams = new CompletionParams(_textDocumentIdentifier, _position);
      return this.contentAssistService.createCompletionList(_document, result, _completionParams, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public String getLine(final String text, final int zeroIndexedRow) {
    final String[] lines = text.split(System.lineSeparator());
    return lines[zeroIndexedRow];
  }

  public boolean assertCompletionContainsProposal(final CompletionList completions, final String text) {
    final Predicate<CompletionItem> _function = (CompletionItem completion) -> {
      String _label = completion.getLabel();
      return Objects.equal(_label, text);
    };
    return completions.getItems().stream().anyMatch(_function);
  }
}
