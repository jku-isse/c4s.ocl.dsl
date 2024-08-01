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

public class WebSocketOutgoingMessageConsumer implements MessageConsumer {
    private final MessageJsonHandler jsonHandler;
    private final WebSocketSession session;

    private static final String CONTENTHEADERPREFIX = "Content-Length: ";
    
    public WebSocketOutgoingMessageConsumer(MessageJsonHandler jsonHandler, WebSocketSession session) {
        this.session = session;
        this.jsonHandler = jsonHandler;
    }

    @Override
    public void consume(Message message) throws MessageIssueException, JsonRpcException {
        try {
            String content = jsonHandler.serialize(message);
            if (session.isOpen()) {
            	String inclHeader = CONTENTHEADERPREFIX+content.length()+"\n\n";
            	BinaryMessage binaryMessage = new BinaryMessage(inclHeader.getBytes());
            	session.sendMessage(binaryMessage);
            	//String overall = inclHeader+content;
            	BinaryMessage binaryMessage2 = new BinaryMessage(content.getBytes());
            	session.sendMessage(binaryMessage2);
            	//TextMessage textMessage = new TextMessage(content);
               // session.sendMessage(textMessage);
            }
        } catch (IOException exception) {
            throw new JsonRpcException(exception);
        }
    }

}
