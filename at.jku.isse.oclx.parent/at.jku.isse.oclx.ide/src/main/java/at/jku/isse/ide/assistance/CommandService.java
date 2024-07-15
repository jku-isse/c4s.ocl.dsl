package at.jku.isse.ide.assistance;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.util.CancelIndicator;

public class CommandService implements IExecutableCommandService {

	@Override
	public List<String> initialize() {
		return List.of("execute.oclx");
	}

	@Override
	public Object execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator) {
		if ("execute.oclx".equals(params.getCommand())) {
			if (params.getArguments().isEmpty()) {
				return "Param URI missing";
			}
			String uri = (String) params.getArguments().get(0);
			try {
				return access.doRead(uri, (ILanguageServerAccess.Context it) -> processExecuteCommand(it)).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				return e.getMessage();
			}
		} else {
			return "Unknown command "+params.getCommand();
		}
	}
	
	private String processExecuteCommand(ILanguageServerAccess.Context ctx) {
		
		
		
		return "executed";
	}

}
