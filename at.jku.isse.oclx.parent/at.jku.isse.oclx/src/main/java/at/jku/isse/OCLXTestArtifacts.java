package at.jku.isse;

import java.util.Optional;
import java.util.Set;

import at.jku.isse.designspace.artifactconnector.core.repository.CoreTypeFactory;
import at.jku.isse.passiveprocessengine.core.BuildInType;
import at.jku.isse.passiveprocessengine.core.InstanceRepository;
import at.jku.isse.passiveprocessengine.core.PPEInstance;
import at.jku.isse.passiveprocessengine.core.PPEInstanceType;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;

public class OCLXTestArtifacts {

	public static final String DEMOISSUETYPE = "DemoIssue";
	public static final String DEMOREVIEW = "Review";
	public static final String DEMOREVIEWFINDING = "Reviewfinding";
	public static final String TYPEPREFIX = "root/types/demo/";
	public static enum CoreProperties { state, requirements, bugs, parent, html_url, upstream, downstream, referencesSingle, referencesGroup, successCriteria, reviewfindings }
	public static enum JiraStates { Open, InProgress, Closed, ReadyForReview, Released}

	InstanceRepository repository;
	SchemaRegistry schemaRegistry;
	
	public OCLXTestArtifacts(InstanceRepository repository, SchemaRegistry schemaRegistry) {
		this.repository = repository;
		this.schemaRegistry = schemaRegistry;		
	}
	
	public PPEInstanceType getJiraInstanceType() {
		Optional<PPEInstanceType> thisType = schemaRegistry.findNonDeletedInstanceTypeByFQN(TYPEPREFIX+DEMOISSUETYPE);
		var baseType =  schemaRegistry.getTypeByName(CoreTypeFactory.BASE_TYPE_NAME);
			if (thisType.isPresent())
				return thisType.get();
			else {
				PPEInstanceType typeIssue = schemaRegistry.createNewInstanceType(TYPEPREFIX+DEMOISSUETYPE, baseType);				
				schemaRegistry.registerTypeByName(typeIssue);
				typeIssue.createSinglePropertyType(CoreProperties.state.toString(), BuildInType.STRING);
				typeIssue.createSetPropertyType(CoreProperties.requirements.toString(), typeIssue);
				typeIssue.createSetPropertyType(CoreProperties.bugs.toString(),  typeIssue);
				typeIssue.createSinglePropertyType(CoreProperties.parent.toString(),  typeIssue);
				typeIssue.createSetPropertyType(CoreProperties.upstream.toString(),  typeIssue);
				typeIssue.createSetPropertyType(CoreProperties.downstream.toString(),  typeIssue);
				
				typeIssue.createSinglePropertyType(CoreProperties.referencesSingle.toString(),  baseType);
				typeIssue.createSetPropertyType(CoreProperties.referencesGroup.toString(),  baseType);
				//typeJira.createOpposablePropertyType(CoreProperties.upstream.toString(), Cardinality.SET, typeJira, CoreProperties.downstream.toString(), Cardinality.SET);				
				//typeJira.createSinglePropertyType(CoreProperties.html_url.toString(), BuildInType.STRING);
				
				// add two subtypes both with same property
				PPEInstanceType typeReview = schemaRegistry.createNewInstanceType(TYPEPREFIX+DEMOREVIEW, typeIssue);				
				schemaRegistry.registerTypeByName(typeReview);
				PPEInstanceType typeReviewfinding = schemaRegistry.createNewInstanceType(TYPEPREFIX+DEMOREVIEWFINDING, typeIssue);				
				schemaRegistry.registerTypeByName(typeReviewfinding);
				
				typeReview.createSetPropertyType(CoreProperties.reviewfindings.toString(), typeIssue);
				typeReview.createSinglePropertyType(CoreProperties.successCriteria.toString(), BuildInType.STRING);
				typeReviewfinding.createSinglePropertyType(CoreProperties.successCriteria.toString(), BuildInType.STRING);
				return typeIssue;
			}
	}

	public PPEInstance getJiraInstance(String name, PPEInstance... reqs) {
		PPEInstance jira = repository.createInstance(name, getJiraInstanceType());
		jira.setSingleProperty(CoreTypeFactory.URL.toString(),"http://localhost:7171/home");
		jira.setSingleProperty(CoreTypeFactory.EXTERNAL_TYPE.toString(),"none");
		jira.setSingleProperty(CoreTypeFactory.EXTERNAL_DEFAULT_ID.toString(), name);
		setStateToJiraInstance(jira, JiraStates.Open);
		for(PPEInstance inst : reqs) {
			jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.requirements.toString(), Set.class).add(inst);
		}
		return jira;
	}

	public void addReqsToJira(PPEInstance jira, PPEInstance... reqs) {
		for(PPEInstance inst : reqs) {
			jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.requirements.toString(), Set.class).add(inst);
		}
	}

	public void addJiraToRequirements(PPEInstance issue, PPEInstance reqToAdd) {
		issue.getTypedProperty(OCLXTestArtifacts.CoreProperties.requirements.toString(), Set.class).add(reqToAdd);
	}
	
	public void removeJiraFromReqs(PPEInstance jira, PPEInstance reqToRemove) {
		jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.requirements.toString(), Set.class).remove(reqToRemove);
	}

	public void setStateToJiraInstance(PPEInstance inst, JiraStates state) {
		inst.setSingleProperty(CoreProperties.state.toString(), state.toString());
	}

	public void addJiraToJiraBug(PPEInstance jira, PPEInstance bugToAdd) {
		jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.bugs.toString(), Set.class).add(bugToAdd);
	}

	public void removeJiraFromJiraBug(PPEInstance jira, PPEInstance bugToRemove) {
		jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.bugs.toString(), Set.class).remove(bugToRemove);
	}

	public void addParentToJira(PPEInstance inst, PPEInstance parent) {
		inst.setSingleProperty(CoreProperties.parent.toString(),parent);
	}

	public void addUpstream(PPEInstance inst, PPEInstance toAdd) {
		inst.getTypedProperty(OCLXTestArtifacts.CoreProperties.upstream.toString(), Set.class).add(toAdd);
	}

	public void addDownstream(PPEInstance inst, PPEInstance toAdd) {
		inst.getTypedProperty(OCLXTestArtifacts.CoreProperties.downstream.toString(), Set.class).add(toAdd);
	}

	public void removeUpstream(PPEInstance inst, PPEInstance toRemove) {
		inst.getTypedProperty(OCLXTestArtifacts.CoreProperties.upstream.toString(), Set.class).remove(toRemove);
	}

	public void removeDownstream(PPEInstance inst, PPEInstance toRemove) {
		inst.getTypedProperty(OCLXTestArtifacts.CoreProperties.downstream.toString(), Set.class).remove(toRemove);
	}

	public static JiraStates getState(PPEInstance inst) {
		String state= (String) inst.getTypedProperty(CoreProperties.state.toString(), String.class, JiraStates.Open.toString());
		return JiraStates.valueOf(state);
	}

	public static String printProperties(PPEInstance jira) {
		PPEInstance parent = jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.parent.toString(), PPEInstance.class);				
		String state = jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.state.toString(), String.class);
		Set<PPEInstance> requirements = jira.getTypedProperty(OCLXTestArtifacts.CoreProperties.requirements.toString(), Set.class);
		
		StringBuffer sb = new StringBuffer("Issue:"+jira.getName()+"::"+getState(jira)+"\r\n");
		if (parent != null)
			sb.append("  Parent: "+parent.getName()+"::"+getState(parent)+"\r\n");
		requirements.stream().forEach(req -> sb.append("  Req: "+req.getName()+"::"+getState(req)+"\r\n"));
		return sb.toString();
	}
	
	public PPEInstanceType getDemoGitIssueType() {
		PPEInstanceType typeGitDemo = schemaRegistry.createNewInstanceType("git_issue");
		typeGitDemo.createSetPropertyType("linkedIssues", typeGitDemo);
		typeGitDemo.createSetPropertyType("labels", BuildInType.STRING);
		typeGitDemo.createSinglePropertyType("state", BuildInType.STRING);
		typeGitDemo.createSinglePropertyType("title",  BuildInType.STRING);
		return typeGitDemo;
	}

	public PPEInstanceType getTestAzureIssueType() {
		PPEInstanceType typeAzureTest = schemaRegistry.createNewInstanceType("azure_workitem");
		PPEInstanceType typeAzureStateTest = schemaRegistry.createNewInstanceType("azure_workitemstate");
		PPEInstanceType typeAzureTypeTest = schemaRegistry.createNewInstanceType("azure_workitemtype");
		PPEInstanceType typeAzureLinkTypeTest = schemaRegistry.createNewInstanceType("workitem_link");

		typeAzureTest.createSetPropertyType("relatedItems", typeAzureLinkTypeTest);
		typeAzureTest.createSinglePropertyType("state", typeAzureStateTest);
		typeAzureTest.createSinglePropertyType("workItemType", typeAzureTypeTest);

		typeAzureLinkTypeTest.createSinglePropertyType("linkTo", typeAzureTest);
		typeAzureLinkTypeTest.createSinglePropertyType("linkType", typeAzureTypeTest);


		return typeAzureTest;
	}
}

