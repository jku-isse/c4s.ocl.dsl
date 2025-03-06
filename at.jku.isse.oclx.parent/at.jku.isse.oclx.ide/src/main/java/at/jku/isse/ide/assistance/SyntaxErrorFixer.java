package at.jku.isse.ide.assistance;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionKind;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtext.resource.XtextResource;

import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.IteratorVarDeclaration;

public class SyntaxErrorFixer {

	
	public CodeAction trySyntaxFix(EObject modelElement, String syntaxErrorCause, Diagnostic diagnostics, XtextResource resource) {
		if (modelElement instanceof IteratorVarDeclaration iterDecl) {
			return fixIterVarDeclaration(iterDecl, syntaxErrorCause, diagnostics, resource);
		}
		if (modelElement instanceof IteratorExp iterExp) {
			return fixIteratorExp(iterExp, syntaxErrorCause, diagnostics, resource);
		}
		return null;
	}

	private CodeAction fixIterVarDeclaration(IteratorVarDeclaration iterDecl, String syntaxErrorCause, Diagnostic diagnostics, XtextResource resource) {
		var edit = new WorkspaceEdit();
		var textEdits = new ArrayList<TextEdit>();
		edit.getChanges().put(resource.getURI().toString(), textEdits);
		
		Range range = diagnostics.getRange();
		textEdits.add(new TextEdit(range, "<"+syntaxErrorCause+">"));
		
		var action = new CodeAction();
		action.setKind(CodeActionKind.QuickFix);
		action.setTitle("Wrap type in < > brackets");
		action.setDiagnostics(List.of(diagnostics));
		action.setEdit(edit);
		return action;
	}
	
	private CodeAction fixIteratorExp(IteratorExp iterExp, String syntaxErrorCause, Diagnostic diagnostics,
			XtextResource resource) {
		if (syntaxErrorCause.equals("|") && iterExp.getItervar() != null) { // cause is most likely a missing type while a ':' is provided
			// get end of iter decl
			// get begin of | 
			// replace  whitespace " "
			var edit = new WorkspaceEdit();
			var textEdits = new ArrayList<TextEdit>();
			edit.getChanges().put(resource.getURI().toString(), textEdits);
			
			var iterRange = QuickFixCodeActionService.getRangeOfElement(iterExp.getItervar()); 
			var lengthName = iterExp.getItervar().getName().getName().length();
			var start = iterRange.getStart();
			start.setCharacter(start.getCharacter()+lengthName); // the : is included in the itervar element, but not in the name
			var end = diagnostics.getRange().getStart();
			Range range = new Range(start, end); 
			textEdits.add(new TextEdit(range, " "));
			
			var action = new CodeAction();
			action.setKind(CodeActionKind.QuickFix);
			action.setTitle("Remove any text between iterator var declaration and '|' or add ':' plus type in < > ");
			action.setDiagnostics(List.of(diagnostics));
			action.setEdit(edit);
			return action;
		} else
			return null;
	}
}
