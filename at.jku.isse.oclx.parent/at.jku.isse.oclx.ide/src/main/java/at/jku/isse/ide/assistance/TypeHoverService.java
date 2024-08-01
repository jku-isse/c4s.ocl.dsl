package at.jku.isse.ide.assistance;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.server.hover.HoverService;

import com.google.inject.Inject;

import at.jku.isse.ide.assistance.ElementToTypeMap.TypeAndCardinality;
import at.jku.isse.oclx.Constraint;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.VarDeclaration;
import at.jku.isse.oclx.VarReference;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;

public class TypeHoverService extends HoverService {

	@Inject
	TypeExtractor typeExtractor;
	
	@Override
	public String getContents(EObject hoverOver) {

		if (hoverOver instanceof SelfExp
				|| hoverOver instanceof VarReference
				|| hoverOver instanceof VarDeclaration
				|| hoverOver instanceof PropertyAccessExp) {
			Optional<Constraint> optRoot = OclxASTUtils.getRootConstraint(hoverOver);
			if (optRoot.isPresent()) {
				Constraint root = optRoot.get();
				Optional<PPEInstanceType> optCtx = typeExtractor.resolveContext(root);
				if (optCtx.isPresent()) {
					PPEInstanceType ctx = optCtx.get();
					ElementToTypeMap elementToTypeMap = new ElementToTypeMap(ctx);
					typeExtractor.fillTypeMapAndReturnCurrent(root.getExpression(), elementToTypeMap);
					TypeAndCardinality hoverType = elementToTypeMap.getReturnTypeMap().get(hoverOver);
					if (hoverType != null) {
						Map.Entry<String, String> prepostfix = getPreAndPostFix(hoverType);
						return prepostfix.getKey()+hoverType.getType().getName()+prepostfix.getValue();
					}
				};
			};
		}
		return super.getContents(hoverOver);
	}


	private Map.Entry<String, String> getPreAndPostFix(TypeAndCardinality typeAndCardinality) {
		return switch(typeAndCardinality.getCardinality()) {
		case LIST -> new AbstractMap.SimpleEntry<String,String>("List of ", "");
		case MAP -> new AbstractMap.SimpleEntry<String,String>("Map of  ", "");
		case SET -> new AbstractMap.SimpleEntry<String,String>("Set of ", "");
		case SINGLE -> new AbstractMap.SimpleEntry<String,String>("", "");
		default -> new AbstractMap.SimpleEntry<String,String>("", "");
		};

	}
}
