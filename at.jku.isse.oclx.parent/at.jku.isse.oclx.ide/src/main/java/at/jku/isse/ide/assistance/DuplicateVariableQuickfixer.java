package at.jku.isse.ide.assistance;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionKind;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtext.resource.XtextResource;

import at.jku.isse.oclx.Exp;
import at.jku.isse.oclx.InfixExp;
import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.IteratorVarDeclaration;
import at.jku.isse.oclx.MethodCallExp;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.NavigationExp;
import at.jku.isse.oclx.NestedExp;
import at.jku.isse.oclx.PrefixExp;
import at.jku.isse.oclx.TemporalExp;
import at.jku.isse.oclx.TriggeredTemporalExp;
import at.jku.isse.oclx.UnaryTemporalExp;
import at.jku.isse.oclx.VarReference;

public class DuplicateVariableQuickfixer {

	private int counter = 1;
	
	public CodeAction createQuickfix(IteratorVarDeclaration iterDecl, Diagnostic diagnostics, XtextResource resource) {
		var edit = new WorkspaceEdit();
		var textEdits = new ArrayList<TextEdit>();
		edit.getChanges().put(resource.getURI().toString(), textEdits);
		
		var duplicateName = iterDecl.getName().getName();
		var newName = augmentWithNextPostfix(duplicateName);
		generateEdit(iterDecl, newName, textEdits); // rename the variable declaration
		IteratorExp iterExp = (IteratorExp) iterDecl.eContainer();
		// rename the usages of this variable
		replaceInBody(duplicateName, newName, iterExp.getBody(), textEdits);	
		
		var action = new CodeAction();
		action.setKind(CodeActionKind.QuickFix);
		action.setTitle("Replace duplicate iterator variable declaration "+duplicateName+" and its usages with "+newName);
		action.setDiagnostics(List.of(diagnostics));
		action.setEdit(edit);
		return action;
	}
	
	protected void replaceInBody(String duplicateName, String newName, Exp exp, List<TextEdit> textEdits) {
		if (exp instanceof VarReference varRef) {
			if (varRef.getRef().getName().equals(duplicateName)) {
				generateEdit(varRef, newName, textEdits);
			}
		// nothing to do for 'self' 
		} else if (exp instanceof PrefixExp prefixExp) {
			replaceInBody(duplicateName, newName, prefixExp.getExpression(), textEdits);
		} else if (exp instanceof NestedExp nestedExp) {
			replaceInBody(duplicateName, newName, nestedExp.getSource(), textEdits);
		} else if (exp instanceof InfixExp infixExp) {			
			infixExp.getExpressions().forEach(subExp -> replaceInBody(duplicateName, newName, subExp, textEdits));					
		} else if (exp instanceof TemporalExp tempExp) {
			if (tempExp instanceof UnaryTemporalExp unaryTemp) {
				replaceInBody(duplicateName, newName, unaryTemp.getExp(), textEdits);
			} else if (tempExp instanceof TriggeredTemporalExp triggeredTemp) {
				replaceInBody(duplicateName, newName, triggeredTemp.getA(), textEdits);
				replaceInBody(duplicateName, newName, triggeredTemp.getB(), textEdits);
			}
		}
		if (exp instanceof NavigationExp navExp) {
			for (MethodExp methodExp : navExp.getMethods()) {
				if (methodExp instanceof IteratorExp iterExp) {
					// check for unlikely case that sub iterator uses same var name, then we replace with newer name
					var subIterName = iterExp.getItervar().getName().getName();
					if (subIterName.equals(duplicateName)) {
						// this allows user to understand that there was another duplication that we tried to take care of
						var newNewName = augmentWithNextPostfix(subIterName);
						generateEdit(iterExp.getItervar(), newNewName, textEdits);
						replaceInBody(duplicateName, newNewName, iterExp.getBody(), textEdits);
					} else {
						replaceInBody(duplicateName, newName, iterExp.getBody(), textEdits);	
					}
				} else if (methodExp instanceof MethodCallExp callExp) {
					if (callExp.getArgs() != null)
						callExp.getArgs().getOperators().forEach(argExp -> replaceInBody(duplicateName, newName, argExp, textEdits));															
				} //else if (methodExp instanceof PropertyAccessExp propExp) {
				//	;// no op											
				//} else if (methodExp instanceof TypeCallExp typeCallExp ) {
				//	; // no op				
				//}
			}
		}
	}
	
	protected void generateEdit(IteratorVarDeclaration duplicateDecl, String newIterVarName, List<TextEdit> textEdits) {
		// get range of variable declaration,
		var range = QuickFixCodeActionService.getRangeOfElement(duplicateDecl);
		// replace with new name
		textEdits.add(new TextEdit(range, newIterVarName));
	}
	
	protected void generateEdit(VarReference candidateRef, String newIterVarName, List<TextEdit> textEdits) {
		Range range;
		// get range of reference 
		var rangeRef = QuickFixCodeActionService.getRangeOfElement(candidateRef);
		if (candidateRef.getNav().isEmpty()) {
			range = rangeRef;
		} else {
			var navRange = QuickFixCodeActionService.getRangeOfElement(candidateRef.getNav().get(0));
			range = new Range(rangeRef.getStart(), navRange.getStart());
		}
		// replace with new name
		textEdits.add(new TextEdit(range, newIterVarName));
	}
	
	private String augmentWithNextPostfix(String varName) {
		return varName+"0"+counter++;
	}
}
