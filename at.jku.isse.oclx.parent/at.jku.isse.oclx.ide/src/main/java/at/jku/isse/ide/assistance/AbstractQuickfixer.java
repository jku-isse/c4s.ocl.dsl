package at.jku.isse.ide.assistance;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import at.jku.isse.designspace.rule.arl.parser.ArlType;
import at.jku.isse.oclx.IteratorExp;
import at.jku.isse.oclx.MethodCallExp;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.validation.ElementToTypeMap;
import at.jku.isse.validation.ElementToTypeMap.TypeAndCardinality;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.validation.OclxASTUtils;
import at.jku.isse.validation.TypeExtractor;

public class AbstractQuickfixer {

	protected final SchemaRegistry schemaReg;
	protected final TypeExtractor typeExtractor;
	protected final MethodRegistry methodReg;
	protected ElementToTypeMap el2TypeMap;

	public AbstractQuickfixer(SchemaRegistry schemaReg, TypeExtractor typeExtractor, MethodRegistry methodReg) {
		super();
		this.schemaReg = schemaReg;
		this.typeExtractor = typeExtractor;
		this.methodReg = methodReg;
	}

	protected Set<ArlType> resolveNextLogicalElement(MethodExp methodExp, TypeAndCardinality precedingElType) {
		var nextEl = OclxASTUtils.findNextLogicalElementFor(methodExp);
		if (nextEl != null) {
				if (nextEl instanceof PropertyAccessExp ) // nothing we can do
					return Collections.emptySet();
				if (nextEl instanceof MethodCallExp nextMethodExp) {
					return methodReg.getInputTypeForMethod(nextMethodExp.getName());
				}
				if (nextEl instanceof IteratorExp) {
					return Set.of(ArlType.COLLECTION);
				}
				//TODO process other elements involving boolean operators etc, that requires completion of findNextLogicalElement(...)
				else return Collections.emptySet();
		}
		return Collections.emptySet();
	}

	protected TypeAndCardinality resolveInputToMethodResourceToType(EObject modelElement) {
		if (modelElement instanceof MethodExp methodExp) {
			var prevNav = OclxASTUtils.findPrecedingOperatorFor(methodExp);
			if (prevNav != null) {
				var completeWithType = el2TypeMap.getReturnTypeMap().get(prevNav);
				return completeWithType;
			}
		}
		return null;
	}

}