package at.jku.isse.ide.ppe.integration;

import java.nio.charset.Charset;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.xtext.ide.server.ServerModule;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lombok.extern.slf4j.Slf4j;

//see also: https://nadeeshaangunasinghe.medium.com/building-a-dsl-domain-specific-language-with-xtext-implement-a-websocket-based-language-server-1734478d31a4

@Slf4j
public class LspWebSocketHandler extends AbstractWebSocketHandler{



	static final Injector injector = Guice.createInjector(new ServerModule());
    private final LanguageServer languageServer;
    private final WebSocketIncomingMessageHandler messageJsonHandler;

    public LspWebSocketHandler() {
        this.languageServer = injector.getInstance(LanguageServer.class);
        this.messageJsonHandler = new WebSocketIncomingMessageHandler();
        log.info("Started Language Server Session");
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // Setup the websocket launcher builder
        WebSocketLauncherBuilder launcherBuilder = new WebSocketLauncherBuilder();
        launcherBuilder
                .setSession(session)
                .setMessageHandler(this.messageJsonHandler)
                .setLocalService(this.languageServer)
                .setRemoteInterface(LanguageClient.class);
        
        // Create a launcher instance
        Launcher<LanguageClient> launcher = launcherBuilder.create();

        // This is mandatory, since the `connect` method will only be available if it satisfies the following condition
        if (this.languageServer instanceof LanguageClientAware) {
            ((LanguageClientAware) this.languageServer).connect(launcher.getRemoteProxy());
        }        
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // handle the text message (JSON-Rpc message)
        this.messageJsonHandler.onMessage(message.getPayload());
    }
	
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		String strMsg = new String(message.getPayload().array(), Charset.forName("UTF-8"));
		//super.handleBinaryMessage(session, message);
		
		if (strMsg.startsWith("Content-Length")) {
			//skip
		} else {
		//	Thread.sleep(10_000l); //for debug purpose
			this.messageJsonHandler.onMessage(strMsg);
		}
	}
	
	
}
