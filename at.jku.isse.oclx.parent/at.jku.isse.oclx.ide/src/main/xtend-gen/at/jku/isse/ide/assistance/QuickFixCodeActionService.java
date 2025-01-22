package at.jku.isse.ide.assistance;

import at.jku.isse.oclx.Constraint;
import at.jku.isse.oclx.Context;
import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.MethodCallExp;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.NavigationOperator;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.VarReference;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.validation.ElementToTypeMap;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.validation.OCLXValidator;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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
          Object _get = d.getCode().get();
          boolean _equals = Objects.equal(_get, OCLXValidator.UNKNOWN_PROPERTY);
          if (_equals) {
            this.generatorCodeActionReplaceWithSubtype(d, resource, offset, stringToRepair, result);
            final List<String> choices = this.findMostSimilarProperties(stringToRepair, resource, offset);
            int _size = choices.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              final String newProp = choices.get(0);
              this.generateCodeActionReplaceWithMostSimilarProperty(d, resource, newProp, result);
            }
          } else {
            Object _get_1 = d.getCode().get();
            boolean _equals_1 = Objects.equal(_get_1, OCLXValidator.UNKNOWN_OPERATION);
            if (_equals_1) {
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
    final Function1<CodeAction, Either<Command, CodeAction>> _function_1 = (CodeAction it) -> {
      return Either.<Command, CodeAction>forRight(it);
    };
    return ListExtensions.<CodeAction, Either<Command, CodeAction>>map(result, _function_1);
  }

  public ILanguageServerAccess.Context process(final ILanguageServerAccess.Context ctx) {
    return ctx;
  }

  public void generatorCodeActionReplaceWithSubtype(final Diagnostic d, final XtextResource resource, final int offset, final String partialPropertyName, final List<CodeAction> result) {
    final List<PPEInstanceType> subclasses = this.findSubclassWithProperty(partialPropertyName, resource, offset);
    boolean _isEmpty = subclasses.isEmpty();
    if (_isEmpty) {
      return;
    }
    final PPEInstanceType subclass = subclasses.get(0);
    final EObject precedingElement = this.getPrecedingElement(resource, offset);
    this.dispatchByPreceedingElement(precedingElement, d, resource, subclass, partialPropertyName, result);
  }

  protected List<PPEInstanceType> findSubclassWithProperty(final String propertyName, final XtextResource resource, final int offset) {
    ElementToTypeMap.TypeAndCardinality completeWithType = this.resolvePropertyAccessOrMethodResourceToType(resource, offset);
    if ((completeWithType != null)) {
      final Predicate<PPEInstanceType> _function = (PPEInstanceType subtype) -> {
        return subtype.hasPropertyType(propertyName);
      };
      return completeWithType.getType().getAllSubtypesRecursively().stream().filter(_function).toList();
    }
    return Collections.<PPEInstanceType>emptyList();
  }

  protected EObject getPrecedingElement(final XtextResource resource, final int offset) {
    final EObject modelElement = this.eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    final EObject varOrSelfContainer = modelElement.eContainer();
    if ((varOrSelfContainer instanceof SelfExp)) {
      final int thisIndex = ((SelfExp)varOrSelfContainer).getMethods().indexOf(modelElement);
      if ((thisIndex > 0)) {
        return ((SelfExp)varOrSelfContainer).getMethods().get((thisIndex - 1));
      } else {
        return varOrSelfContainer;
      }
    } else {
      if ((varOrSelfContainer instanceof VarReference)) {
        final int thisIndex_1 = ((VarReference)varOrSelfContainer).getMethods().indexOf(modelElement);
        if ((thisIndex_1 > 0)) {
          return ((VarReference)varOrSelfContainer).getMethods().get((thisIndex_1 - 1));
        } else {
          return varOrSelfContainer;
        }
      }
    }
    return null;
  }

  protected Boolean dispatchByPreceedingElement(final EObject modelElement, final Diagnostic d, final XtextResource resource, final PPEInstanceType subclass, final String propertyName, final List<CodeAction> result) {
    boolean _xifexpression = false;
    if ((modelElement instanceof SelfExp)) {
      CodeAction _codeAction = new CodeAction();
      final Procedure1<CodeAction> _function = (CodeAction it) -> {
        it.setKind(CodeActionKind.QuickFix);
        String _name = subclass.getName();
        String _plus = ("Use \'" + _name);
        String _plus_1 = (_plus + "\' as a more specialized context element");
        it.setTitle(_plus_1);
        WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
        final Procedure1<WorkspaceEdit> _function_1 = (WorkspaceEdit it_1) -> {
          URI _uRI = resource.getURI();
          TextEdit _textEdit = new TextEdit();
          final Procedure1<TextEdit> _function_2 = (TextEdit it_2) -> {
            it_2.setRange(this.getRangeOfContext(modelElement));
            it_2.setNewText(subclass.getName());
          };
          TextEdit _doubleArrow = ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function_2);
          this.addTextEdit(it_1, _uRI, _doubleArrow);
        };
        WorkspaceEdit _doubleArrow = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function_1);
        it.setEdit(_doubleArrow);
      };
      CodeAction _doubleArrow = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction, _function);
      _xifexpression = result.add(_doubleArrow);
    } else {
      boolean _xifexpression_1 = false;
      if ((modelElement instanceof PropertyAccessExp)) {
        CodeAction _codeAction_1 = new CodeAction();
        final Procedure1<CodeAction> _function_1 = (CodeAction it) -> {
          it.setKind(CodeActionKind.QuickFix);
          String _name = subclass.getName();
          String _plus = ((("Access property \'" + propertyName) + "\' in subtype \'") + _name);
          String _plus_1 = (_plus + "\' ");
          it.setTitle(_plus_1);
          it.setDiagnostics(Collections.<Diagnostic>unmodifiableList(CollectionLiterals.<Diagnostic>newArrayList(d)));
          WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
          final Procedure1<WorkspaceEdit> _function_2 = (WorkspaceEdit it_1) -> {
            URI _uRI = resource.getURI();
            TextEdit _textEdit = new TextEdit();
            final Procedure1<TextEdit> _function_3 = (TextEdit it_2) -> {
              it_2.setRange(d.getRange());
              String _name_1 = subclass.getName();
              String _plus_2 = ("asType(<" + _name_1);
              String _plus_3 = (_plus_2 + ">).");
              String _plus_4 = (_plus_3 + propertyName);
              it_2.setNewText(_plus_4);
            };
            TextEdit _doubleArrow_1 = ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function_3);
            this.addTextEdit(it_1, _uRI, _doubleArrow_1);
          };
          WorkspaceEdit _doubleArrow_1 = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function_2);
          it.setEdit(_doubleArrow_1);
        };
        CodeAction _doubleArrow_1 = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction_1, _function_1);
        _xifexpression_1 = result.add(_doubleArrow_1);
      } else {
        boolean _xifexpression_2 = false;
        if ((modelElement instanceof MethodCallExp)) {
          boolean _xblockexpression = false;
          {
            Range methodRange = this.getRangeOfElement(modelElement);
            boolean _xifexpression_3 = false;
            if ((methodRange != null)) {
              CodeAction _codeAction_2 = new CodeAction();
              final Procedure1<CodeAction> _function_2 = (CodeAction it) -> {
                it.setKind(CodeActionKind.QuickFix);
                String _name = subclass.getName();
                String _plus = ("Add a filter for instances of subtype \'" + _name);
                String _plus_1 = (_plus + "\' before method/operation call \'");
                String _name_1 = ((MethodCallExp)modelElement).getName();
                String _plus_2 = (_plus_1 + _name_1);
                String _plus_3 = (_plus_2 + "\'");
                it.setTitle(_plus_3);
                it.setDiagnostics(Collections.<Diagnostic>unmodifiableList(CollectionLiterals.<Diagnostic>newArrayList(d)));
                int _line = d.getRange().getStart().getLine();
                int _character = d.getRange().getStart().getCharacter();
                int _minus = (_character - 1);
                final Position pos = new Position(_line, _minus);
                WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
                final Procedure1<WorkspaceEdit> _function_3 = (WorkspaceEdit it_1) -> {
                  URI _uRI = resource.getURI();
                  TextEdit _textEdit = new TextEdit();
                  final Procedure1<TextEdit> _function_4 = (TextEdit it_2) -> {
                    Range _range = new Range(pos, pos);
                    it_2.setRange(_range);
                    String _name_2 = subclass.getName();
                    String _plus_4 = ("->SELECT(object | object.isKindOf(<" + _name_2);
                    String _plus_5 = (_plus_4 + ">)");
                    it_2.setNewText(_plus_5);
                  };
                  TextEdit _doubleArrow_2 = ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function_4);
                  this.addTextEdit(it_1, _uRI, _doubleArrow_2);
                };
                WorkspaceEdit _doubleArrow_2 = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function_3);
                it.setEdit(_doubleArrow_2);
              };
              CodeAction _doubleArrow_2 = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction_2, _function_2);
              _xifexpression_3 = result.add(_doubleArrow_2);
            }
            _xblockexpression = _xifexpression_3;
          }
          _xifexpression_2 = _xblockexpression;
        } else {
          boolean _xifexpression_3 = false;
          if ((modelElement instanceof VarReference)) {
            boolean _xblockexpression_1 = false;
            {
              final String refName = ((VarReference)modelElement).getRef().getName();
              Range iterRange = this.getRangeOfIterator(((VarReference)modelElement), refName);
              boolean _xifexpression_4 = false;
              boolean _notEquals = (!Objects.equal(iterRange, null));
              if (_notEquals) {
                CodeAction _codeAction_2 = new CodeAction();
                final Procedure1<CodeAction> _function_2 = (CodeAction it) -> {
                  it.setKind(CodeActionKind.QuickFix);
                  String _name = subclass.getName();
                  String _plus = ("Add a filter for instances of subtype \'" + _name);
                  String _plus_1 = (_plus + "\' before iterator");
                  it.setTitle(_plus_1);
                  it.setDiagnostics(Collections.<Diagnostic>unmodifiableList(CollectionLiterals.<Diagnostic>newArrayList(d)));
                  WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
                  final Procedure1<WorkspaceEdit> _function_3 = (WorkspaceEdit it_1) -> {
                    URI _uRI = resource.getURI();
                    TextEdit _textEdit = new TextEdit();
                    final Procedure1<TextEdit> _function_4 = (TextEdit it_2) -> {
                      Position _start = d.getRange().getStart();
                      Position _start_1 = d.getRange().getStart();
                      Range _range = new Range(_start, _start_1);
                      it_2.setRange(_range);
                      String _name_1 = subclass.getName();
                      String _plus_2 = ((((("->SELECT(" + refName) + "Untyped | ") + refName) + "Untyped.isKindOf(<") + _name_1);
                      String _plus_3 = (_plus_2 + ">)");
                      it_2.setNewText(_plus_3);
                    };
                    TextEdit _doubleArrow_2 = ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function_4);
                    this.addTextEdit(it_1, _uRI, _doubleArrow_2);
                  };
                  WorkspaceEdit _doubleArrow_2 = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function_3);
                  it.setEdit(_doubleArrow_2);
                };
                CodeAction _doubleArrow_2 = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction_2, _function_2);
                _xifexpression_4 = result.add(_doubleArrow_2);
              }
              _xblockexpression_1 = _xifexpression_4;
            }
            _xifexpression_3 = _xblockexpression_1;
          } else {
            String _string = modelElement.toString();
            String _plus = ("ERROR in QuickFixCodeActionService: Unexpected preceding element: " + _string);
            System.out.println(_plus);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return Boolean.valueOf(_xifexpression);
  }

  protected Range getRangeOfElement(final EObject exp) {
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

  protected Range getRangeOfContext(final EObject exp) {
    if ((exp == null)) {
      return null;
    }
    if ((exp instanceof Constraint)) {
      final Context ctx = ((Constraint)exp).getContext();
      final ICompositeNode inode = NodeModelUtils.findActualNodeFor(ctx);
      final int startPos = inode.getOffset();
      int _startLine = inode.getStartLine();
      final int startLine = (_startLine - 1);
      final int endPos = inode.getEndOffset();
      int _endLine = inode.getEndLine();
      final int endLine = (_endLine - 1);
      Position _position = new Position(startLine, startPos);
      Position _position_1 = new Position(endLine, endPos);
      return new Range(_position, _position_1);
    } else {
      return this.getRangeOfContext(exp.eContainer());
    }
  }

  protected Range getRangeOfIterator(final VarReference exp, final String iterVarName) {
    if ((exp == null)) {
      return null;
    }
    if ((exp instanceof IteratorExp)) {
      final String varName = ((IteratorExp)exp).getItervar().getName().getName();
      boolean _equals = varName.equals(iterVarName);
      if (_equals) {
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
      } else {
        return this.getRangeOfContext(exp.eContainer());
      }
    } else {
      return this.getRangeOfContext(exp.eContainer());
    }
  }

  protected List<String> findMostSimilarProperties(final String partialPropertyName, final XtextResource resource, final int offset) {
    ElementToTypeMap.TypeAndCardinality completeWithType = this.resolvePropertyAccessOrMethodResourceToType(resource, offset);
    if ((completeWithType != null)) {
      final List<String> choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), partialPropertyName);
      return choices;
    }
    return Collections.<String>emptyList();
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

  protected List<TextEdit> addTextEdit(final WorkspaceEdit edit, final URI uri, final TextEdit... textEdit) {
    return edit.getChanges().put(uri.toString(), ((List<TextEdit>)Conversions.doWrapArray(textEdit)));
  }
}
