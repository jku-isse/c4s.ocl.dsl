package at.jku.isse.ide.assistance;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import at.jku.isse.designspace.rule.arl.expressions.LiteralExpression;
import at.jku.isse.designspace.rule.arl.expressions.OperationCallExpression;
import at.jku.isse.designspace.rule.arl.expressions.OperationCallExpression.OperationDeclaration;
import at.jku.isse.designspace.rule.arl.parser.ArlType;
import at.jku.isse.designspace.rule.arl.parser.ArlType.CollectionKind;
import at.jku.isse.ide.assistance.ElementToTypeMap.TypeAndCardinality;
import at.jku.isse.passiveprocessengine.core.BuildInType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.CARDINALITIES;

public class MethodRegistry {
	
	private AtomicBoolean doInit = new AtomicBoolean(true);
	Map<PPEInstanceType, Set<OperationDeclaration>> sourceTypeIndex = new HashMap<>();
	Map<CARDINALITIES, Set<OperationDeclaration>> sourceCardinalityIndex = new HashMap<>();
	
	public MethodRegistry() {
		initRegistry(); 
	}

	private void initRegistry() {
		if (doInit.compareAndExchange(true, false)) {
			new OperationCallExpression(new LiteralExpression("SomeString"), "size", Collections.emptyList()); // we need to ensure that OperationDeclarations are initiated, by creating some arbitrary correct expression
			List<OperationDeclaration> declarations = OperationCallExpression.OperationDeclaration.getOperationDeclarations();
			declarations.stream().forEach(decl -> {
				if (decl.sourceType.collection.equals(CollectionKind.SINGLE)) {
					insertSingleOperation(decl);
				} else {
					insertCollectionOperation(decl);
				}
			});
		}
	}
	
//	private List<OperationDeclaration> insertDummyData() {
//		List<OperationDeclaration> declarations = new ArrayList<>();
//		declarations.add(new OperationDeclaration(ArlType.BOOLEAN, "includes", ArlType.COLLECTION, ArlType.ANY));
//		declarations.add(new OperationDeclaration(ArlType.ANY, "any", ArlType.COLLECTION));
//		declarations.add(new OperationDeclaration(ArlType.SET, "union", ArlType.SET, ArlType.SET));
//		declarations.add(new OperationDeclaration(ArlType.BOOLEAN, "isDefined", ArlType.INSTANCE));
//		declarations.add(new OperationDeclaration(ArlType.INTEGER, "count", ArlType.COLLECTION, ArlType.ANY));
//		declarations.add(new OperationDeclaration(ArlType.INTEGER, "size", ArlType.COLLECTION));
//		declarations.add(new OperationDeclaration(ArlType.LIST, "characters", ArlType.STRING));
//		declarations.add(new OperationDeclaration(ArlType.BOOLEAN, "startsWith", ArlType.STRING, ArlType.STRING));
//		return declarations;
//	}
	
	private void insertCollectionOperation(OperationDeclaration decl) {
		switch(decl.sourceType.collection) {
		case ANY: // not relevant here
			break;
		case COLLECTION:
			sourceCardinalityIndex.computeIfAbsent(CARDINALITIES.MAP, k -> new HashSet<OperationDeclaration>()).add(decl);
			sourceCardinalityIndex.computeIfAbsent(CARDINALITIES.SET, k -> new HashSet<OperationDeclaration>()).add(decl);
			sourceCardinalityIndex.computeIfAbsent(CARDINALITIES.LIST, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case LIST:
			sourceCardinalityIndex.computeIfAbsent(CARDINALITIES.LIST, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case MAP:
			sourceCardinalityIndex.computeIfAbsent(CARDINALITIES.MAP, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case SET:
			sourceCardinalityIndex.computeIfAbsent(CARDINALITIES.SET, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case SINGLE: // unable to arrive here
			break;
		default:
			break;
		}
	}

	private void insertSingleOperation(OperationDeclaration decl) {
		switch(decl.sourceType.type) {
		case ANY: //not relevant here
			break;
		case BOOLEAN:
			sourceTypeIndex.computeIfAbsent(BuildInType.BOOLEAN, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case DATE:
			sourceTypeIndex.computeIfAbsent(BuildInType.DATE, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case INSTANCE: // lets see if that works
			sourceTypeIndex.computeIfAbsent(BuildInType.METATYPE, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case INTEGER:
			sourceTypeIndex.computeIfAbsent(BuildInType.INTEGER, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case NULL: // not relevant here
			break;
		case NUMBER:
			sourceTypeIndex.computeIfAbsent(BuildInType.INTEGER, k -> new HashSet<OperationDeclaration>()).add(decl);
			sourceTypeIndex.computeIfAbsent(BuildInType.FLOAT, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case REAL:
			sourceTypeIndex.computeIfAbsent(BuildInType.FLOAT, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case STRING:
			sourceTypeIndex.computeIfAbsent(BuildInType.STRING, k -> new HashSet<OperationDeclaration>()).add(decl);
			break;
		case TUPLE: // not relevant here
			break;
		default: // nothing to do
			break;
		}
	}
		
	
	public Set<OperationDeclaration> getOperationsForSingleType(PPEInstanceType type) {
		//initRegistry();
		if (BuildInType.isAtomicType(type)) {
			return sourceTypeIndex.get(type);
		} else
			return sourceTypeIndex.get(BuildInType.METATYPE);
	}
	
	public Set<OperationDeclaration> getOperationsForCollection(CARDINALITIES cardinality) {
		//initRegistry();
		return sourceCardinalityIndex.get(cardinality);
	}
	
	public List<TypeAndCardinality> getParameterTypesFor(OperationDeclaration opDec, PPEInstanceType sourceTypeHint) {
		//initRegistry();
		return opDec.parameterTypes.stream().map(param -> {
			PPEInstanceType type = convertSingle(param, sourceTypeHint != null ? sourceTypeHint : BuildInType.METATYPE); // parameters typically need to be compatible with source type for collections / ANY
			CARDINALITIES cardinality = convertCardinality(param);
			return new TypeAndCardinality(type, cardinality);
		}).collect(Collectors.toList());
	}
	
	public TypeAndCardinality getReturnType(OperationDeclaration opDec, PPEInstanceType sourceTypeHint) {
	//	initRegistry();
		ArlType arlType = opDec.returnType;
		PPEInstanceType type = convertSingle(arlType, sourceTypeHint != null ? sourceTypeHint : BuildInType.METATYPE); //sourceType needed where collections operation are agnostic of collection content
		CARDINALITIES cardinality = convertCardinality(arlType);
		return new TypeAndCardinality(type, cardinality);
	}
	
	private CARDINALITIES convertCardinality(ArlType arlType) {
		if (arlType.equals(ArlType.LIST)) {
			return CARDINALITIES.LIST;
		} else if (arlType.equals(ArlType.MAP)) {
			return CARDINALITIES.MAP;
		} else if (arlType.equals(ArlType.SET)) {
			return CARDINALITIES.SET;
		} else if (arlType.equals(ArlType.COLLECTION)) { // too unspecific, we assume more lenient LIST then, should not be used
			return CARDINALITIES.LIST;
		} else if (arlType.equals(ArlType.LIST)) {
			return CARDINALITIES.LIST;
		} else return CARDINALITIES.SINGLE; //this includes ANY, as we dont allow collections of collections, a return of ANY can never be a collection
	}

	private PPEInstanceType convertSingle(ArlType arlType, PPEInstanceType typeHint) {
		if (arlType.equals(ArlType.INTEGER)) {
			return BuildInType.INTEGER;
		} else if (arlType.equals(ArlType.BOOLEAN)) {
			return BuildInType.BOOLEAN;
		} else if (arlType.equals(ArlType.DATE)) {
			return BuildInType.DATE;
		} else if (arlType.equals(ArlType.REAL)) {
			return BuildInType.FLOAT;
		} else if (arlType.equals(ArlType.NUMBER)) {
			return BuildInType.FLOAT; // to be on the safe side
		} else if (arlType.equals(ArlType.INTEGER)) {
			return BuildInType.INTEGER;
		} else if ( arlType.equals(ArlType.LIST) //collection operations or ANY typically need to be compatible with (source) type
				 || arlType.equals(ArlType.MAP)
			     || arlType.equals(ArlType.SET) 
			    || arlType.equals(ArlType.COLLECTION)
			    || arlType.equals(ArlType.ANY)
				) { 
				return typeHint;
		} 
		else //lets see if that works 
			return BuildInType.METATYPE; // serves as ANY replacement, when we are unable to infer anything
	}
	
}
