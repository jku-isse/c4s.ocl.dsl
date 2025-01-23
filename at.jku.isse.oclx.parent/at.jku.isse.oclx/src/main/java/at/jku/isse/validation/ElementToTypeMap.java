package at.jku.isse.validation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.CARDINALITIES;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.PPEPropertyType;
import lombok.Data;
import lombok.NonNull;

public class ElementToTypeMap {


	private final TypeAndCardinality selfType;
	private final Map<EObject, TypeAndCardinality> returnTypeMap = new HashMap<>();	
	private final Map<PropertyAccessExp, PPEPropertyType> propertyAccessMap = new HashMap<>();
	
	
	public ElementToTypeMap(PPEInstanceType ctxType) {
		super();
		this.selfType = new TypeAndCardinality(ctxType, CARDINALITIES.SINGLE);
	}

	public void tryAddToReturnTypeMap(@NonNull EObject object, TypeAndCardinality copyTypeOnly, CARDINALITIES cardinality) {
		if (copyTypeOnly != null && copyTypeOnly.getType() != null) {
			returnTypeMap.put(object, new TypeAndCardinality(copyTypeOnly.getType(), cardinality));
		}
	}

	public TypeAndCardinality getSelfType() {
		return selfType;
	}

	public Map<EObject, TypeAndCardinality> getReturnTypeMap() {
		return returnTypeMap;
	}

	public Map<PropertyAccessExp, PPEPropertyType> getPropertyAccessMap() {
		return propertyAccessMap;
	}
	
	@Data
	public static class TypeAndCardinality {
		private final PPEInstanceType type;
		private final CARDINALITIES cardinality;		
	}
}
