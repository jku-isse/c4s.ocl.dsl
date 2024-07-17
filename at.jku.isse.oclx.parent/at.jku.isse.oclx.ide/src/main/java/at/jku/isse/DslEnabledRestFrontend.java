package at.jku.isse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class DslEnabledRestFrontend extends SpringBootServletInitializer   {

	private static ApplicationContext ctx;
	
    public static void main(String[] args) {

    	 ctx = SpringApplication.run(DslEnabledRestFrontend.class, args);

        System.out.println("Successfully initialized!");
        System.out.println("======================================================================================================");
    }

}
