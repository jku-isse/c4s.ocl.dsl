package at.jku.isse.tests;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionContext;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(OCLXInjectorProvider.class)
@SuppressWarnings("all")
public class CodeRepairTests extends AbstractContentAssistTest {
  @Inject
  private /* ParseHelper<Model> */Object parseHelper;

  @Inject
  private ValidationTestHelper validationTestHelper;

  @Inject
  private ICodeActionService2 repairService;

  @Test
  public void testRepairProperty() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field OclxPackage is undefined"
      + "\nThe field CodeRepairTests.parseHelper refers to the missing type Model"
      + "\nThe method error2CodeAction(String, Model) from the type CodeRepairTests refers to the missing type Model"
      + "\nLiterals cannot be resolved"
      + "\nPROPERTY_ACCESS_EXP cannot be resolved"
      + "\neResource cannot be resolved"
      + "\nerrors cannot be resolved"
      + "\nisEmpty cannot be resolved"
      + "\njoin cannot be resolved");
  }

  public List<Either<Command, CodeAction>> error2CodeAction(final String content, final /* Model */Object result) {
    try {
      final Issue issue = this.validationTestHelper.validate(result).get(0);
      Integer _lineNumber = issue.getLineNumber();
      int _minus = ((_lineNumber).intValue() - 1);
      Integer _column = issue.getColumn();
      int _minus_1 = ((_column).intValue() - 1);
      Position _position = new Position(_minus, _minus_1);
      Integer _lineNumberEnd = issue.getLineNumberEnd();
      int _minus_2 = ((_lineNumberEnd).intValue() - 1);
      Integer _columnEnd = issue.getColumnEnd();
      int _minus_3 = ((_columnEnd).intValue() - 1);
      Position _position_1 = new Position(_minus_2, _minus_3);
      final Range range = new Range(_position, _position_1);
      final XtextResource xresult = this.parse(content);
      final Diagnostic d = new Diagnostic();
      final CodeActionContext ctx = new CodeActionContext(Collections.<Diagnostic>unmodifiableList(CollectionLiterals.<Diagnostic>newArrayList(d)));
      d.setCode(issue.getCode());
      d.setSeverity(DiagnosticSeverity.Error);
      d.setMessage(issue.getMessage());
      d.setRange(range);
      ICodeActionService2.Options options = new ICodeActionService2.Options();
      Document _document = new Document(Integer.valueOf(1), content);
      options.setDocument(_document);
      options.setResource(xresult);
      String _string = xresult.getURI().toString();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(_string);
      CodeActionParams _codeActionParams = new CodeActionParams(_textDocumentIdentifier, range, ctx);
      options.setCodeActionParams(_codeActionParams);
      return this.repairService.getCodeActions(options);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
