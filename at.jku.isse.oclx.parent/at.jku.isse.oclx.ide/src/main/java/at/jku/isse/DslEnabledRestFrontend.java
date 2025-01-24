//package at.jku.isse;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.SocketAddress;
//import java.nio.channels.AsynchronousServerSocketChannel;
//import java.nio.channels.AsynchronousSocketChannel;
//import java.nio.channels.Channels;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.function.Function;
//
//import org.eclipse.lsp4j.jsonrpc.Launcher;
//import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
//import org.eclipse.lsp4j.services.LanguageClient;
//import org.eclipse.xtext.ide.server.LanguageServerImpl;
//import org.eclipse.xtext.ide.server.ServerModule;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//
//import com.google.inject.Guice;
//import com.google.inject.Injector;
//
//@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
//public class DslEnabledRestFrontend extends SpringBootServletInitializer implements ApplicationListener<ApplicationReadyEvent>   {
//
//	private static ApplicationContext ctx;
//	
//    public static void main(String[] args) {
//
//    	 ctx = SpringApplication.run(DslEnabledRestFrontend.class, args);
//
//        System.out.println("Successfully initialized!");
//        System.out.println("======================================================================================================");
//    }
//
//	@Override
//	public void onApplicationEvent(ApplicationReadyEvent event) {
//		
//		try {
//			Injector injector = Guice.createInjector(new ServerModule());
//			LanguageServerImpl languageServer = injector.getInstance(LanguageServerImpl.class);
//			Function<MessageConsumer, MessageConsumer> wrapper = consumer -> {
//				MessageConsumer result = consumer;
//				return result;
//			};
//			Launcher<LanguageClient> launcher = createSocketLauncher(languageServer, LanguageClient.class,
//					new InetSocketAddress("localhost", 5007), Executors.newCachedThreadPool(), wrapper);
//			languageServer.connect(launcher.getRemoteProxy());
//			Future<?> future = launcher.startListening();
//			while (!future.isDone()) {
//				Thread.sleep(10_000l);
//			}
//		} catch (IOException | InterruptedException e) {			
//			e.printStackTrace();
//		}
//	}
//
//	static <T> Launcher<T> createSocketLauncher(Object localService, Class<T> remoteInterface,
//			SocketAddress socketAddress, ExecutorService executorService,
//			Function<MessageConsumer, MessageConsumer> wrapper) throws IOException {
//		AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open().bind(socketAddress);
//		AsynchronousSocketChannel socketChannel;
//		try {
//			socketChannel = serverSocket.accept().get();
//			return Launcher.createIoLauncher(localService, remoteInterface, Channels.newInputStream(socketChannel),
//					Channels.newOutputStream(socketChannel), executorService, wrapper);
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
