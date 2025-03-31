package at.jku.isse.ide.assistance;

import at.jku.isse.oclx.IteratorVarDeclaration;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.validation.OCLXValidator;
import at.jku.isse.validation.TypeExtractor;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class QuickFixCodeActionService implements ICodeActionService2 {
  @Inject
  private TypeExtractor typeExtractor;

  @Inject
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;

  @Inject
  private MethodRegistry methodReg;

  @Inject
  private SchemaRegistry schemaReg;

  private DuplicateVariableQuickfixer duplicateFixer = new DuplicateVariableQuickfixer();

  private SyntaxErrorFixer syntaxFixer = new SyntaxErrorFixer();

  public static double minSimilarityThreshold = 0.8;

  @Override
  public List<Either<Command, CodeAction>> getCodeActions(final ICodeActionService2.Options options) {
    Document document = options.getDocument();
    final CodeActionParams params = options.getCodeActionParams();
    final ArrayList<CodeAction> result = CollectionLiterals.<CodeAction>newArrayList();
    Resource _resource = options.getResource();
    XtextResource resource = ((XtextResource) _resource);
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
      List<Diagnostic> _diagnostics = params.getContext().getDiagnostics();
      for (final Diagnostic d : _diagnostics) {
        {
          final String stringToRepair = document.getSubstring(d.getRange());
          final int offset = document.getOffSet(d.getRange().getStart());
          final EObject modelElement = this.eObjectAtOffsetHelper.resolveElementAt(resource, offset);
          Object _get = d.getCode().get();
          boolean _equals = Objects.equal(_get, org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC);
          if (_equals) {
            CodeAction repair = this.syntaxFixer.trySyntaxFix(modelElement, stringToRepair, d, resource);
            if ((repair != null)) {
              result.add(repair);
            }
          } else {
            Object _get_1 = d.getCode().get();
            boolean _equals_1 = Objects.equal(_get_1, OCLXValidator.UNKNOWN_TYPE);
            if (_equals_1) {
              CodeAction repair_1 = new UnknownTypeQuickfixer(this.schemaReg).createReplaceWithMostSimilarTypeQuickFix(modelElement, stringToRepair, d, resource);
              if ((repair_1 != null)) {
                result.add(repair_1);
              }
            } else {
              Object _get_2 = d.getCode().get();
              boolean _equals_2 = Objects.equal(_get_2, OCLXValidator.DUPLICATE_VAR_NAME);
              if (_equals_2) {
                EObject iterDecl = modelElement.eContainer();
                if ((iterDecl instanceof IteratorVarDeclaration)) {
                  CodeAction _createQuickfix = this.duplicateFixer.createQuickfix(((IteratorVarDeclaration)iterDecl), d, resource);
                  result.add(_createQuickfix);
                }
              } else {
                Object _get_3 = d.getCode().get();
                boolean _equals_3 = Objects.equal(_get_3, OCLXValidator.UNKNOWN_PROPERTY);
                if (_equals_3) {
                  List<CodeAction> _createReplaceWithSubtype = new UnknownPropertyQuickfixer(this.typeExtractor, this.eObjectAtOffsetHelper, d, resource).createReplaceWithSubtype(offset, stringToRepair);
                  Iterables.<CodeAction>addAll(result, _createReplaceWithSubtype);
                  List<CodeAction> _createReplaceWithMostSimilarFittingPropertyQuickFix = new SimilarPropertyQuickfixer(this.schemaReg, this.typeExtractor, this.methodReg).createReplaceWithMostSimilarFittingPropertyQuickFix(modelElement, stringToRepair, d, resource);
                  Iterables.<CodeAction>addAll(result, _createReplaceWithMostSimilarFittingPropertyQuickFix);
                } else {
                  Object _get_4 = d.getCode().get();
                  boolean _equals_4 = Objects.equal(_get_4, OCLXValidator.UNKNOWN_OPERATION);
                  if (_equals_4) {
                    List<CodeAction> _createReplaceWithMostSimilarFittingOperationQuickFix = new UnknownOperationQuickfixer(this.schemaReg, this.typeExtractor, this.methodReg).createReplaceWithMostSimilarFittingOperationQuickFix(modelElement, stringToRepair, d, resource);
                    Iterables.<CodeAction>addAll(result, _createReplaceWithMostSimilarFittingOperationQuickFix);
                  }
                }
              }
            }
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

  public static Range getRangeOfElement(final EObject exp) {
    if ((exp == null)) {
      return null;
    }
    final ICompositeNode inode = NodeModelUtils.findActualNodeFor(exp);
    final int startPos = inode.getOffset();
    int _startLine = inode.getStartLine();
    final int startLine = (_startLine - 1);
    final int endPos = inode.getEndOffset();
    int _endLine = inode.getEndLine();
    final int endLine = (_endLine - 1);
    Position _position = new Position(startLine, startPos);
    Position _position_1 = new Position(endLine, endPos);
    return new Range(_position, _position_1);
  }
}
