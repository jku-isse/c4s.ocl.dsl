package at.jku.isse.ide.assistance;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
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
		
		var optType = findMostSimilarType(unknownType, schemaReg);
		if (optType.isPresent()) {
			var knownFQN = optType.get().getId();			
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
	
	public static Optional<PPEInstanceType> findMostSimilarType(String typeName, SchemaRegistry schemaReg) {
		List <SimpleEntry <Double, PPEInstanceType>> candidates = schemaReg.getTypeByName(CoreTypeFactory.BASE_TYPE_URI).getAllSubtypesRecursively().stream()
		.map(type -> new AbstractMap.SimpleEntry<Double, PPEInstanceType>( new JaroWinklerSimilarity()
				.apply(type.getName(), typeName), type) )
				.sorted(OclxContentProposalProvider.similarityComparator)
				.toList();
		return candidates.stream() 
				.map(entry -> entry.getValue())
				.findFirst();
	}
}
