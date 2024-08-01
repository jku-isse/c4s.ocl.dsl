package at.jku.isse.ide.assistance;

import at.jku.isse.oclx.NavigationOperator;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.validation.OCLXValidator;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionKind;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class QuickFixCodeActionService implements ICodeActionService2 {
  @Inject
  private TypeExtractor typeExtractor;

  @Inject
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;

  @Override
  public List<Either<Command, CodeAction>> getCodeActions(final ICodeActionService2.Options options) {
    Document document = options.getDocument();
    final CodeActionParams params = options.getCodeActionParams();
    final ArrayList<CodeAction> result = CollectionLiterals.<CodeAction>newArrayList();
    Resource _resource = options.getResource();
    XtextResource resource = ((XtextResource) _resource);
    List<Diagnostic> _diagnostics = params.getContext().getDiagnostics();
    for (final Diagnostic d : _diagnostics) {
      Object _get = d.getCode().get();
      boolean _equals = Objects.equal(_get, OCLXValidator.UNKNOWN_PROPERTY);
      if (_equals) {
        if ((document == null)) {
          final Function<ILanguageServerAccess.Context, ILanguageServerAccess.Context> _function = (ILanguageServerAccess.Context lsCtx) -> {
            return lsCtx;
          };
          final ILanguageServerAccess.Context lsCtx = options.getLanguageServerAccess().<ILanguageServerAccess.Context>doSyncRead(params.getTextDocument().getUri(), _function);
          document = lsCtx.getDocument();
          Resource _resource_1 = lsCtx.getResource();
          resource = ((XtextResource) _resource_1);
        }
        if ((document != null)) {
          final String propertyString = document.getSubstring(d.getRange());
          final int offset = document.getOffSet(d.getRange().getStart());
          final List<String> choices = this.findMostSimilarProperties(propertyString, resource, offset);
          int _size = choices.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            final String newProp = choices.get(0);
            this.getCodeAction(d, resource, newProp, result);
          }
        }
      }
    }
    final Function1<CodeAction, Either<Command, CodeAction>> _function_1 = (CodeAction it) -> {
      return Either.<Command, CodeAction>forRight(it);
    };
    return ListExtensions.<CodeAction, Either<Command, CodeAction>>map(result, _function_1);
  }

  public ILanguageServerAccess.Context process(final ILanguageServerAccess.Context ctx) {
    return ctx;
  }

  public boolean getCodeAction(final Diagnostic d, final XtextResource resource, final String newProp, final List<CodeAction> result) {
    CodeAction _codeAction = new CodeAction();
    final Procedure1<CodeAction> _function = (CodeAction it) -> {
      it.setKind(CodeActionKind.QuickFix);
      it.setTitle((("Replace with most similar property \'" + newProp) + "\' "));
      it.setDiagnostics(Collections.<Diagnostic>unmodifiableList(CollectionLiterals.<Diagnostic>newArrayList(d)));
      WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
      final Procedure1<WorkspaceEdit> _function_1 = (WorkspaceEdit it_1) -> {
        URI _uRI = resource.getURI();
        TextEdit _textEdit = new TextEdit();
        final Procedure1<TextEdit> _function_2 = (TextEdit it_2) -> {
          it_2.setRange(d.getRange());
          it_2.setNewText(newProp);
        };
        TextEdit _doubleArrow = ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function_2);
        this.addTextEdit(it_1, _uRI, _doubleArrow);
      };
      WorkspaceEdit _doubleArrow = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function_1);
      it.setEdit(_doubleArrow);
    };
    CodeAction _doubleArrow = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction, _function);
    return result.add(_doubleArrow);
  }

  protected List<String> findMostSimilarProperties(final String partialPropertyName, final XtextResource resource, final int offset) {
    final EObject modelElement = this.eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((modelElement != null)) {
      final ElementToTypeMap el2TypeMap = this.typeExtractor.extractElementToTypeMap(modelElement).get();
      if ((modelElement instanceof PropertyAccessExp)) {
        final NavigationOperator prevNav = OclxASTUtils.findPrecedingOperatorFor(((PropertyAccessExp)modelElement));
        if ((prevNav != null)) {
          final ElementToTypeMap.TypeAndCardinality completeWithType = el2TypeMap.getReturnTypeMap().get(prevNav);
          if ((completeWithType != null)) {
            final List<String> choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), partialPropertyName);
            return choices;
          }
        }
      }
    }
    return Collections.<String>emptyList();
  }

  protected List<TextEdit> addTextEdit(final WorkspaceEdit edit, final URI uri, final TextEdit... textEdit) {
    return edit.getChanges().put(uri.toString(), ((List<TextEdit>)Conversions.doWrapArray(textEdit)));
  }
}
