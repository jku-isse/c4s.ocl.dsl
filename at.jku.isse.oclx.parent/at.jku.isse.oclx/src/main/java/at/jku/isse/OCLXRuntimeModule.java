/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse;

import com.google.inject.Binder;

import at.jku.isse.designspace.artifactconnector.core.repository.CoreTypeFactory;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.passiveprocessengine.designspace.DesignSpaceSchemaRegistry;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class OCLXRuntimeModule extends AbstractOCLXRuntimeModule {

	final DesignSpaceSchemaRegistry designspace;
	
	public  OCLXRuntimeModule() {
		
		designspace = BaseSpringConfig.getSchemaRegistry(BaseSpringConfig.getLanguageWorkspace(), BaseSpringConfig.getProjectWorkspace()); // DS5
		//designspace = BaseSpringConfig.getSchemaRegistry(); //DS4
		CoreTypeFactory coreType = BaseSpringConfig.getBaseTypeFactory(designspace);
		coreType.getBaseArtifactType();
		TestArtifacts testArt = new TestArtifacts(designspace, designspace);
		testArt.getJiraInstanceType();
		//designspace.getAllNonDeletedInstanceTypes().stream().forEach(type -> System.out.println(type.getName()));
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(SchemaRegistry.class).toInstance(designspace);
	}
}
