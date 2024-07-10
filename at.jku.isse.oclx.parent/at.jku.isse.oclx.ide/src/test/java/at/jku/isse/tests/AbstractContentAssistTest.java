package at.jku.isse.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ResourceHelper;
import com.google.inject.Inject;

public class AbstractContentAssistTest {

	// adapted from https://github.com/eclipse/xtext-core/blob/master/org.eclipse.xtext.testing/src/org/eclipse/xtext/testing/util/ParseHelper.java
	
	
	@Inject
	private ResourceHelper resourceHelper;
	
	
	protected String c = "<|>";
	
	
	
	public XtextResource parse(CharSequence text) throws Exception {
		Resource resource = resourceHelper.resource(text);
		if (resource instanceof XtextResource) {
			return (XtextResource) resource;
		} else
			return null;
	}

	

}
