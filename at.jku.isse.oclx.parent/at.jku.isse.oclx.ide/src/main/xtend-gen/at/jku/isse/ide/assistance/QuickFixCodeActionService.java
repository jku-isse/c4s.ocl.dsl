package at.jku.isse.ide.assistance;

import at.jku.isse.oclx.IteratorVarDeclaration;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.NavigationOperator;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.validation.ElementToTypeMap;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.validation.OCLXValidator;
import at.jku.isse.validation.OclxASTUtils;
import at.jku.isse.validation.TypeExtractor;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
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
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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

  @Inject
  private MethodRegistry methodReg;

  @Inject
  private SchemaRegistry schemaReg;

  private DuplicateVariableQuickfixer duplicateFixer = new DuplicateVariableQuickfixer();

  private SyntaxErrorFixer syntaxFixer = new SyntaxErrorFixer();

  private double minSimilarityThreshold = 0.8;

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
                  final List<String> choices = this.findMostSimilarProperties(stringToRepair, resource, offset, this.minSimilarityThreshold);
                  int _size = choices.size();
                  boolean _greaterThan = (_size > 0);
                  if (_greaterThan) {
                    final String newProp = choices.get(0);
                    this.generateCodeActionReplaceWithMostSimilarProperty(d, resource, newProp, result);
                  }
                } else {
                  Object _get_4 = d.getCode().get();
                  boolean _equals_4 = Objects.equal(_get_4, OCLXValidator.UNKNOWN_OPERATION);
                  if (_equals_4) {
                    List<String> choices_1 = this.findMostSimilarOperations(resource, offset, stringToRepair);
                    int _size_1 = choices_1.size();
                    boolean _greaterThan_1 = (_size_1 > 0);
                    if (_greaterThan_1) {
                      final String newOp = choices_1.get(0);
                      this.generateCodeActionReplaceWithMostSimilarOperation(d, resource, newOp, result);
                    }
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

  protected List<String> findMostSimilarProperties(final String partialPropertyName, final XtextResource resource, final int offset, final double minSimilarityThreshold) {
    ElementToTypeMap.TypeAndCardinality completeWithType = this.resolvePropertyAccessOrMethodResourceToType(resource, offset);
    if ((completeWithType != null)) {
      final List<String> choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), partialPropertyName, minSimilarityThreshold);
      return choices;
    }
    return Collections.<String>emptyList();
  }

  public boolean generateCodeActionReplaceWithMostSimilarProperty(final Diagnostic d, final XtextResource resource, final String newProp, final List<CodeAction> result) {
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

  protected List<String> findMostSimilarOperations(final XtextResource resource, final int offset, final String partialOpName) {
    ElementToTypeMap.TypeAndCardinality inputOfType = this.resolvePropertyAccessOrMethodResourceToType(resource, offset);
    if ((inputOfType != null)) {
      final List<String> choices = OclxContentProposalProvider.getSimilaritySortedMethods(this.methodReg, partialOpName, inputOfType);
      return choices;
    }
    return Collections.<String>emptyList();
  }

  public boolean generateCodeActionReplaceWithMostSimilarOperation(final Diagnostic d, final XtextResource resource, final String newMethod, final List<CodeAction> result) {
    CodeAction _codeAction = new CodeAction();
    final Procedure1<CodeAction> _function = (CodeAction it) -> {
      it.setKind(CodeActionKind.QuickFix);
      it.setTitle((("Replace with most similar operation \'" + newMethod) + "\' "));
      it.setDiagnostics(Collections.<Diagnostic>unmodifiableList(CollectionLiterals.<Diagnostic>newArrayList(d)));
      WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
      final Procedure1<WorkspaceEdit> _function_1 = (WorkspaceEdit it_1) -> {
        URI _uRI = resource.getURI();
        TextEdit _textEdit = new TextEdit();
        final Procedure1<TextEdit> _function_2 = (TextEdit it_2) -> {
          it_2.setRange(d.getRange());
          it_2.setNewText(newMethod);
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

  protected ElementToTypeMap.TypeAndCardinality resolvePropertyAccessOrMethodResourceToType(final XtextResource resource, final int offset) {
    final EObject modelElement = this.eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((modelElement != null)) {
      final ElementToTypeMap el2TypeMap = this.typeExtractor.extractElementToTypeMap(modelElement).get();
      if ((modelElement instanceof MethodExp)) {
        final NavigationOperator prevNav = OclxASTUtils.findPrecedingOperatorFor(((MethodExp)modelElement));
        if ((prevNav != null)) {
          final ElementToTypeMap.TypeAndCardinality completeWithType = el2TypeMap.getReturnTypeMap().get(prevNav);
          return completeWithType;
        }
      }
    }
    return null;
  }

  protected List<TextEdit> addTextEdit(final WorkspaceEdit edit, final URI uri, final TextEdit... textEdit) {
    return edit.getChanges().put(uri.toString(), ((List<TextEdit>)Conversions.doWrapArray(textEdit)));
  }
}
