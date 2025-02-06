/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse;

import com.google.inject.Binder;

import at.jku.isse.designspace.artifactconnector.core.repository.CoreTypeFactory;
import at.jku.isse.passiveprocessengine.core.SchemaRegistry;
import at.jku.isse.passiveprocessengine.rdfwrapper.config.EventStreamingWrapperFactory;
import at.jku.isse.validation.MethodRegistry;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class OCLXRuntimeModule extends AbstractOCLXRuntimeModule {

	private final EventStreamingWrapperFactory factory;
	
	public  OCLXRuntimeModule() {
		factory = new EventStreamingWrapperFactory.FactoryBuilder().build();	
		factory.getCoreTypeFactory().getBaseArtifactType();
		OCLXTestArtifacts testArt = new OCLXTestArtifacts(factory.getInstanceRepository(), factory.getSchemaRegistry());
		testArt.getJiraInstanceType();		
	}

	public Class<? extends MethodRegistry> bindMethodRegistry() {
		return MethodRegistry.class;
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(SchemaRegistry.class).toInstance(factory.getSchemaRegistry());
	}
}
