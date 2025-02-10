package at.jku.isse.ide.assistance;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionKind;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtext.resource.XtextResource;

import at.jku.isse.designspace.artifactconnector.core.repository.CoreTypeFactory;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;

public class UnknownTypeQuickfixer {

	public UnknownTypeQuickfixer(SchemaRegistry schemaReg) {
		super();
		this.schemaReg = schemaReg;
	}

	private final SchemaRegistry schemaReg;
	
	public CodeAction createReplaceWithMostSimilarTypeQuickFix(EObject modelElement, String unknownType, Diagnostic diagnostics, XtextResource resource) {
		var edit = new WorkspaceEdit();
		var textEdits = new ArrayList<TextEdit>();
		edit.getChanges().put(resource.getURI().toString(), textEdits);
		
		var optType = findMostSimilarType(unknownType);
		if (optType.isPresent()) {
			var knownFQN = optType.get().getFullyQualifiedName();
			if (knownFQN.startsWith("/")) {
				knownFQN = knownFQN.substring(1);
			}
			Range range = QuickFixCodeActionService.getRangeOfElement(modelElement);
			textEdits.add(new TextEdit(range, "<"+knownFQN+">"));
			
			var action = new CodeAction();
			action.setKind(CodeActionKind.QuickFix);
			action.setTitle("Replace unknown type declaration '"+unknownType+"' and with most similar type '"+knownFQN+"'");
			action.setDiagnostics(List.of(diagnostics));
			action.setEdit(edit);
			return action;
		} else
			return null;
	}
	
	public Optional<PPEInstanceType> findMostSimilarType(String typeName) {
		return schemaReg.getTypeByName(CoreTypeFactory.BASE_TYPE_NAME).getAllSubtypesRecursively().stream()
				.map(type -> new AbstractMap.SimpleEntry<Double, PPEInstanceType>( new JaroWinklerDistance()
						.apply(type.getName(), typeName), type) )
				.sorted(OclxContentProposalProvider.similarityComparator)
				.map(entry -> entry.getValue())
				.findFirst();
	}
}
