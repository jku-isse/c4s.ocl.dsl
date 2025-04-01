package at.jku.isse.validation;

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
import at.jku.isse.passiveprocessengine.core.BuildInType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.CARDINALITIES;
import at.jku.isse.validation.ElementToTypeMap.TypeAndCardinality;
import lombok.Getter;

public class MethodRegistry {
	
	private AtomicBoolean doInit = new AtomicBoolean(true);
	private final Map<PPEInstanceType, Set<OperationDeclaration>> sourceTypeIndex = new HashMap<>();
	private final Map<CARDINALITIES, Set<OperationDeclaration>> sourceCardinalityIndex = new HashMap<>();
	@Getter private List<OperationDeclaration> declarations;
	
	public MethodRegistry() {
		initRegistry(); 
	}

	private void initRegistry() {
		if (doInit.compareAndExchange(true, false)) {
			new OperationCallExpression(new LiteralExpression("SomeString"), "size", Collections.emptyList()); // we need to ensure that OperationDeclarations are initiated, by creating some arbitrary correct expression
			declarations = OperationCallExpression.OperationDeclaration.getOperationDeclarations();
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
		// we cant use equals here as as soon as we get ANY it will match!
		if (ArlType.ANY == arlType) 
			return typeHint;
		if (ArlType.STRING == arlType) {
			return BuildInType.STRING;		
		} else if (ArlType.BOOLEAN == arlType) {
			return BuildInType.BOOLEAN;
		//} else if (arlType.equals(ArlType.DATE)) { //checking this runs into EvaluationException
		//	return BuildInType.DATE;
		} else if (ArlType.REAL == arlType) {
			return BuildInType.FLOAT;
		//} else if (arlType.equals(ArlType.NUMBER)) { //checking this runs into EvaluationException
		//	return BuildInType.FLOAT; // to be on the safe side
		} else if (ArlType.INTEGER == arlType) {
			return BuildInType.INTEGER;
		} else if (ArlType.LIST == arlType //collection operations typically need to be compatible with (source) type
				 || ArlType.MAP == arlType
			     || ArlType.SET == arlType 
			    || ArlType.COLLECTION == arlType 
				) { 
				return typeHint;
		} 
		else //lets see if that works 
			return BuildInType.METATYPE; // serves as ANY replacement, when we are unable to infer anything
	}

	public TypeAndCardinality getReturnTypeForMethodName(String name, PPEInstanceType typeMethodCalledOn) {
		var optDecl = declarations.stream().filter(decl -> decl.name.equals(name)).findAny();
		if (optDecl.isPresent()) {
			return getReturnType(optDecl.get(), typeMethodCalledOn);
		} else
			return null;
	}
	
	public TypeAndCardinality getInputTypeForMethodName(String name, PPEInstanceType typeMethodCalledOnHint) {
		return declarations.stream()
				.filter(decl -> decl.name.equals(name))
				.findAny().map(decl -> {	
			if (decl.sourceType.collection.equals(CollectionKind.SINGLE)) {
				return new TypeAndCardinality(convertSingle(decl.sourceType, typeMethodCalledOnHint), convertCardinality(decl.sourceType));
			} else {
				return new TypeAndCardinality(typeMethodCalledOnHint, CARDINALITIES.SINGLE);
			}
		}).orElse(null);
	}

	public Set<ArlType> getInputTypeForMethod(String name) {
		return declarations.stream()
				.filter(decl -> decl.name.equals(name))
				.map(decl -> decl.sourceType)
				.collect(Collectors.toSet());
	}
	
	public List<OperationDeclaration> findOperationsForName(String name) {
		return declarations.stream()
				.filter(decl -> decl.name.equals(name))
				.toList();
	}
	
	public boolean canMethodBeCalledOnType(String name, TypeAndCardinality source) {
		return declarations.stream()
				.filter(decl -> decl.name.equals(name))
				.anyMatch(decl -> {		
			if (source.getCardinality().equals(CARDINALITIES.SINGLE)) { //compare type
				if (!decl.sourceType.collection.equals(CollectionKind.SINGLE)) // requires collection as input
					return false;
				var validType = convertSingle(decl.sourceType, source.getType());
				return source.getType().equals(validType) || validType.equals(BuildInType.METATYPE);
			} else { // compare collection type
				if (decl.sourceType.collection.equals(CollectionKind.SINGLE)) // requires single as input
					return false;
				var methodCollectionKind = decl.sourceType.collection;
				switch(source.getCardinality()) {					
				case LIST:
					return methodCollectionKind.equals(CollectionKind.LIST) || methodCollectionKind.equals(CollectionKind.COLLECTION);					
				case MAP:
					return methodCollectionKind.equals(CollectionKind.MAP) || methodCollectionKind.equals(CollectionKind.COLLECTION);
				case SET:
					return methodCollectionKind.equals(CollectionKind.SET) || methodCollectionKind.equals(CollectionKind.COLLECTION);
//				case SINGLE: wont happen as checked above
//					break;
				default:
					return false;					
				}				
			}
		});

	}
	
}
