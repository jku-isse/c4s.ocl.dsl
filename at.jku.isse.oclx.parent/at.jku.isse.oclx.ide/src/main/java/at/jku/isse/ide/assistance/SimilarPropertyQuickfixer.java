package at.jku.isse.ide.assistance;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.resource.XtextResource;

import at.jku.isse.designspace.rule.arl.parser.ArlType;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.passiveprocessengine.core.BuildInType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.CARDINALITIES;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.PPEPropertyType;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.validation.TypeExtractor;

public class SimilarPropertyQuickfixer extends AbstractQuickfixer{

	public SimilarPropertyQuickfixer(SchemaRegistry schemaReg, TypeExtractor typeExtractor, MethodRegistry methodReg) {
		super(schemaReg, typeExtractor, methodReg);
	}

	public List<CodeAction> createReplaceWithMostSimilarFittingPropertyQuickFix(EObject modelElement, String unknownProp, Diagnostic diagnostics, XtextResource resource) {
		el2TypeMap = typeExtractor.extractElementToTypeMap(modelElement).get();
		var completeWithType = resolveInputToMethodResourceToType(modelElement);
		if (completeWithType != null) {
			var choices = OclxContentProposalProvider.getSimilaritySortedProperties(completeWithType.getType(), unknownProp);
			if (!choices.isEmpty()) {
				// now, if we know what follows, we can filter down to methodOutput compatible with subsequent element	
				var nextArlTypes = resolveNextLogicalElement((MethodExp)modelElement, completeWithType);
				if (!nextArlTypes.isEmpty()) { //lets filter
					choices = choices.stream()
							.filter(prop -> nextArlTypes.stream().anyMatch(nextArlType -> doesPropertyMatchArl(prop.getValue(), nextArlType)) )
							.toList();
				}
			
				if (!choices.isEmpty()) {
					var newProp = choices.get(0).getValue().getName();
					var actionEdit = UnknownPropertyQuickfixer.prepareSkeletonCodeAction(diagnostics, resource);
					actionEdit.getKey().setTitle("Replace with most similar property '"+newProp+"' ");
					actionEdit.getValue().add(new TextEdit(diagnostics.getRange(), newProp));								

					return List.of(actionEdit.getKey());
				}
			}
		}
		return Collections.emptyList();
	}
		
	private boolean doesPropertyMatchArl(PPEPropertyType prop, ArlType arlType) {
		switch(arlType.collection) {
		case ANY:
			break;
		case COLLECTION:
			if (prop.getCardinality().equals(CARDINALITIES.SINGLE)) return false;
			break;
		case LIST:
			if (!prop.getCardinality().equals(CARDINALITIES.LIST)) return false;
			break;
		case MAP:
			if (!prop.getCardinality().equals(CARDINALITIES.MAP)) return false;
			break;
		case SET:
			if (!prop.getCardinality().equals(CARDINALITIES.SET)) return false;
			break;
		case SINGLE:
			if (!prop.getCardinality().equals(CARDINALITIES.SINGLE)) return false;
			break;
		default:
			break;
		}
		switch (arlType.type) {
		case ANY:
			return true;
		case BOOLEAN:
			return prop.getInstanceType().equals(BuildInType.BOOLEAN);
		case DATE:
			return prop.getInstanceType().equals(BuildInType.DATE);
		case INSTANCE:
			break;
		case INTEGER:
			return prop.getInstanceType().equals(BuildInType.INTEGER);
		case NULL:
			return false;
		case NUMBER:
			return prop.getInstanceType().equals(BuildInType.INTEGER) || prop.getInstanceType().equals(BuildInType.FLOAT);
		case REAL:
			return prop.getInstanceType().equals(BuildInType.FLOAT);
		case STRING:
			return prop.getInstanceType().equals(BuildInType.STRING);
		case TUPLE:
			return false;
		default:
			break;
		}
		return true;
	}
}
