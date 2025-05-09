/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse.ide;

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.ide.server.hover.HoverService;

import at.jku.isse.ide.assistance.CommandService;
import at.jku.isse.ide.assistance.OclxContentProposalProvider;
import at.jku.isse.ide.assistance.QuickFixCodeActionService;
import at.jku.isse.ide.assistance.TypeHoverService;
import at.jku.isse.validation.MethodRegistry;
import at.jku.isse.validation.TypeExtractor;
import at.jku.isse.validation.TypeExtractor.ErrorCollector;
import at.jku.isse.validation.TypeExtractor.NoOpErrorCollector;

/**
 * Use this class to register ide components.
 */
public class OCLXIdeModule extends AbstractOCLXIdeModule {

	
	public OCLXIdeModule() {

	}
	
	public Class<? extends IExecutableCommandService> bindIExecutableCommandService() {
		return CommandService.class;
	}
	
	public Class<? extends ICodeActionService2> bindCodeActionService2() {
		return QuickFixCodeActionService.class;
	}
	
	
	public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return OclxContentProposalProvider.class;
	}
	
	public Class<TypeExtractor> bindTypeExtractor() {
		return TypeExtractor.class;
	}
	
	public Class<? extends ErrorCollector> bindNoOpErrorCollector() {
		return NoOpErrorCollector.class;
	}
	
	public Class<? extends HoverService> bindHoverService() {
		return TypeHoverService.class;
	}
	

	
}
