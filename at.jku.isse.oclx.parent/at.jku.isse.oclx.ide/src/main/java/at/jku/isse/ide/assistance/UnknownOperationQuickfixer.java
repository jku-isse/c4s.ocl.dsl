package at.jku.isse.ide.assistance;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.resource.XtextResource;

import at.jku.isse.oclx.MethodExp;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.validation.TypeExtractor;

public class UnknownOperationQuickfixer extends AbstractQuickfixer {

	public UnknownOperationQuickfixer(SchemaRegistry schemaReg, TypeExtractor typeExtractor,MethodRegistry methodReg) {
		super(schemaReg, typeExtractor, methodReg);
	}
	
	public List<CodeAction> createReplaceWithMostSimilarFittingOperationQuickFix(EObject modelElement, String unknownOp, Diagnostic diagnostics, XtextResource resource) {
		el2TypeMap = typeExtractor.extractElementToTypeMap(modelElement).get();
		var completeWithType = resolveInputToMethodResourceToType(modelElement);
		if (completeWithType != null) {
			var choices = OclxContentProposalProvider.getSimilaritySortedMethods(methodReg, unknownOp, completeWithType);
			if (!choices.isEmpty()) {
				// now, if we know what follows, we can filter down to methodOutput compatible with subsequent element	
				var nextArlTypes = resolveNextLogicalElement((MethodExp)modelElement, completeWithType);
				if (!nextArlTypes.isEmpty()) { //lets filter
					choices = choices.stream()
							.filter(op -> nextArlTypes.stream().anyMatch(nextArlType -> op.getValue().returnType.conformsTo(nextArlType)))
							.toList();
				}
				if (!choices.isEmpty()) {
					var newMethod = choices.get(0).getValue().name;
					var actionEdit = UnknownPropertyQuickfixer.prepareSkeletonCodeAction(diagnostics, resource);
					actionEdit.getKey().setTitle("Replace with most similar operation '"+newMethod+"' ");
					actionEdit.getValue().add(new TextEdit(diagnostics.getRange(), newMethod));								

					return List.of(actionEdit.getKey());
				}
			}
		}
		
		return Collections.emptyList();
	}
	

}
