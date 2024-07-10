package at.jku.isse.ide.contentproposal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

import at.jku.isse.ide.contentproposal.ElementToTypeMap.TypeAndCardinality;
import at.jku.isse.oclx.NavigationOperator;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.VarReference;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType.CARDINALITIES;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.services.OCLXGrammarAccess;

/**
 * Proposals are provided for:
 *  context: available instance types
 *  self/varref/propertyaccess: available properties of that type (if any)
 *  suggest FORALL, EXISTS etc only after collection property
 *  TODO: for propertyaccess: available methodcalls inkl FORALL, EXISTS etc for collections
 *  dont allow navigation across collection properties --> require FORALL, EXIST, ...
 */
public class OclxContentProposalProvider extends IdeContentProposalProvider {

	@Inject
	private OCLXGrammarAccess grammarAccess;
	
	@Inject
	private SchemaRegistry schemaReg;
	
	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private TypeExtractor typeExtractor;

	@Override
	protected boolean filterKeyword(Keyword keyword, ContentAssistContext context) {
		if (grammarAccess.getIteratorNameAccess().getNameAlternatives_0().eContents().contains(keyword)) {
			EObject prevModel = context.getPreviousModel();
			if (prevModel instanceof NavigationOperator) {

				String prevNavOp = ((NavigationOperator)prevModel).getName();
				if (prevNavOp.equals(".")) {
					return false; // we only have FORALL, etc after -> but not .
				}
				// check if prev returnType is a list or set, as map is not supported by OCL/ARL
				Optional<ElementToTypeMap> optMap = typeExtractor.extractElementToTypeMap(context.getPreviousModel());
				if (optMap.isPresent() && optMap.get().getReturnTypeMap().containsKey(prevModel)) {
					return isAListOrSetProperty(optMap.get().getReturnTypeMap().get(prevModel).getCardinality());
				} 
			}  else if (prevModel instanceof PropertyAccessExp) {
				// check if prev returnType is a list or set, as map is not supported by OCL/ARL
				Optional<ElementToTypeMap> optMap = typeExtractor.extractElementToTypeMap(context.getPreviousModel());
				if (optMap.isPresent() && optMap.get().getReturnTypeMap().containsKey(prevModel)) {
					return isAListOrSetProperty(optMap.get().getReturnTypeMap().get(prevModel).getCardinality());
				} 
			}
			//default return value for ITERATOR keywords
			return false;
		}
		return true;
	}
	
	private boolean isACollectionProperty(CARDINALITIES cardinality) {
		switch(cardinality) {
		case LIST: 
		case MAP:
		case SET: return true;
		case SINGLE:
			default: return false;
		}
	}
	
	private boolean isAListOrSetProperty(CARDINALITIES cardinality) {
		switch(cardinality) {
		case LIST: 
		case SET: return true;
		case SINGLE:
		case MAP:
			default: return false;
		}
	}
	
	@Override
	protected void _createProposals(RuleCall ruleCall, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		boolean proposalCreated = resolveExpression(context.getPreviousModel(), context, acceptor);
		if (proposalCreated) {
			return;
		}
		// additional proposals for Collections when property or self/ref is a collection
		if ( grammarAccess.getContextRule().equals(ruleCall.getRule()) ) {
			// propose instance types
			acceptor.accept(getProposalCreator().createSnippet(createInstanceTypesSelection(), "Select from existing InstanceTypes",  context), 0);
			return;
		}
		//super._createProposals(ruleCall, context, acceptor);
	}
	
	
	
	private boolean resolveExpression(EObject completeFrom, ContentAssistContext context,
			IIdeContentProposalAcceptor acceptor) {
		AtomicBoolean proposalCreated = new AtomicBoolean(false);
		if (completeFrom instanceof SelfExp
				|| completeFrom instanceof VarReference
				|| completeFrom instanceof NavigationOperator
				|| completeFrom instanceof PropertyAccessExp) {
			Optional<ElementToTypeMap> optMap = typeExtractor.extractElementToTypeMap(completeFrom);
			optMap.ifPresent(elementToTypeMap -> {
				TypeAndCardinality completeWithType = elementToTypeMap.getReturnTypeMap().get(completeFrom);
					if (completeWithType != null) {
						if (isACollectionProperty(completeWithType.getCardinality())) 
							return;
						// prefixing with '.' navigation when Var, Self, or PropertyAccess
						//String prefix = "";//getNavigationPrefix(completeFrom, context.getPrefix());
						//String selection = createJointPropertySelection(completeWithType, prefix);
						//proposeProperties(acceptor, selection, context);
						Set<String> choices = completeWithType.getType().getPropertyNamesIncludingSuperClasses()
								.stream()
								.filter(name -> !name.startsWith("@"))
								.sorted()
								.collect(Collectors.toSet());
						proposeIndividualProperties(acceptor, choices, context);
						proposalCreated.set(true);
					} else {// might be an incomplete varref or property or method call --> this is better a QuickFix, not a completion
						if (completeFrom instanceof PropertyAccessExp) {
							PropertyAccessExp propertyAccess = (PropertyAccessExp) completeFrom;
							String partialName = propertyAccess.getName();
							NavigationOperator prevNav = ASTUtils.findPrecedingOperatorFor(propertyAccess);
							if (prevNav != null) {
								completeWithType = elementToTypeMap.getReturnTypeMap().get(prevNav);
								if (completeWithType != null) {
									// need to replace existing test from last navop
//									String selection = createSimilaritySortedPropertySelection(completeWithType.getType(), partialName, ".");
//									proposeProperties(acceptor, selection, context);
									List<String> choices = completeWithType.getType().getPropertyNamesIncludingSuperClasses()
											.stream()
											.filter(name -> !name.startsWith("@"))
											.map(str -> new AbstractMap.SimpleEntry<Double, String>( new JaroWinklerDistance()
													.apply(str, partialName), str) )
											.sorted(textComp)
											.map(entry -> entry.getValue())
											.collect(Collectors.toList());
									proposeReplaceIndividualProperties(acceptor, choices, context, partialName);
									proposalCreated.set(true);
								}
							}
						}
						//TODO: other expansion
					}
				});

		}
		return proposalCreated.get();
	}
	
	private void proposeProperties(IIdeContentProposalAcceptor acceptor, String selection, ContentAssistContext context) {
		acceptor.accept(getProposalCreator().createSnippet(selection, "Select from existing properties",  context), 0);
	}
	
	private void proposeIndividualProperties(IIdeContentProposalAcceptor acceptor, Collection<String> choices, ContentAssistContext context) {
		choices.stream().forEach(selection -> 
		//acceptor.accept(getProposalCreator().createSnippet(prefix+selection, selection,  context), 1)
		{
			ContentAssistEntry entry = getProposalCreator().createProposal(selection, context,
					(ContentAssistEntry it) -> {
						it.getEditPositions().add(new TextRegion(context.getOffset(), selection.length()));
						it.setKind(ContentAssistEntry.KIND_VALUE);
						it.setDescription("Autocomplete with valid property");
					});
			acceptor.accept(entry, 1);
		}

				);
	}
	
	private void proposeReplaceIndividualProperties(IIdeContentProposalAcceptor acceptor, Collection<String> choices, ContentAssistContext context, String replacementOf) {
		choices.stream().forEach(selection -> 
		//acceptor.accept(getProposalCreator().createSnippet(prefix+selection, selection,  context), 1)
		{
			ContentAssistEntry entry = new ContentAssistEntry();
			entry.setPrefix("");
			entry.setProposal(selection);
//			ContentAssistEntry entry = getProposalCreator().createProposal(selection, context,
//					(ContentAssistEntry it) -> {
//						it.getEditPositions().add(new TextRegion(context.getOffset()-replacementOf.length(), selection.length()));
//						it.setKind(ContentAssistEntry.KIND_VALUE);
//						it.setDescription("Replace with valid properties");
//					});
			entry.getEditPositions().add(new TextRegion(context.getOffset()-replacementOf.length(), selection.length()));
			entry.setKind(ContentAssistEntry.KIND_VALUE);
			entry.setDescription("Replace with valid property");
			acceptor.accept(entry, 1);
		}

				);
	}
	
//	private String getNavigationPrefix(EObject completeFrom, String prefix) {
//		// prefixing with '.' navigation when Var, Self, or PropertyAccess unless there is already one thereafter
//		if (prefix.equals("."))
//			return "."; 
//		if (prefix.equals("->") || prefix.equals("-"))
//			return "->";
//		
////		if (completeFrom instanceof NavigationOperator)
////			return "";
//		if (ASTUtils.findSuccessorNavigationOperator(completeFrom).isPresent()) {
//			return "";
//		} else return ".";
//		
//	}
	
	private String createInstanceTypesSelection() {
		return schemaReg.getAllNonDeletedInstanceTypes().stream()
		.map(type -> type.getName())
		.collect(Collectors.joining(",", "${1|", "|}"));
	}
	
	private String createJointPropertySelection(PPEInstanceType type, String navPrefix) {
		return type.getPropertyNamesIncludingSuperClasses()
				.stream()
				.filter(name -> !name.startsWith("@"))
				.sorted()
				.map(prop -> navPrefix+prop)
				.collect(Collectors.joining(",", "${1|", "|}"));
	}
	
	private String createSimilaritySortedPropertySelection(PPEInstanceType type, String compareTo, String navPrefix) {
		return getSimilaritySortedProperties(type, compareTo).stream()
				.map(prop -> navPrefix+prop)
				.collect(Collectors.joining(",", "${1|", "|}"));
	}
	
	public static List<String> getSimilaritySortedProperties(PPEInstanceType type, String compareTo) {
		return type.getPropertyNamesIncludingSuperClasses()
				.stream()
				.filter(name -> !name.startsWith("@"))
				.map(str -> new AbstractMap.SimpleEntry<Double, String>( new JaroWinklerDistance()
						.apply(str, compareTo), str) )
				.sorted(textComp)
				.map(entry -> entry.getValue())
				.collect(Collectors.toList());
	}
	
	public static TextComparator textComp = new TextComparator();
	
	private static class TextComparator implements Comparator<Entry<Double, String>> {

		@Override
		public int compare(Entry<Double, String> o1, Entry<Double, String> o2) { 
			return o2.getKey().compareTo(o1.getKey());
		}
	}
	
	
	
	
	
	
	

}
