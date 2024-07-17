package at.jku.isse.ide.ppe.integration;

import java.io.IOException;

import org.eclipse.lsp4j.jsonrpc.JsonRpcException;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.jsonrpc.MessageIssueException;
import org.eclipse.lsp4j.jsonrpc.json.MessageJsonHandler;
import org.eclipse.lsp4j.jsonrpc.messages.Message;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.BinaryMessage;

public class WebSocketMessageConsumer implements MessageConsumer {
    private final MessageJsonHandler jsonHandler;
    private final WebSocketSession session;

    public WebSocketMessageConsumer(MessageJsonHandler jsonHandler, WebSocketSession session) {
        this.session = session;
        this.jsonHandler = jsonHandler;
    }

    @Override
    public void consume(Message message) throws MessageIssueException, JsonRpcException {
        try {
            String content = jsonHandler.serialize(message);
            if (session.isOpen()) {
            	BinaryMessage binaryMessage = new BinaryMessage(content.getBytes());
            	session.sendMessage(binaryMessage);
            	//TextMessage textMessage = new TextMessage(content);
                //session.sendMessage(textMessage);
            }
        } catch (IOException exception) {
            throw new JsonRpcException(exception);
        }
    }

}
