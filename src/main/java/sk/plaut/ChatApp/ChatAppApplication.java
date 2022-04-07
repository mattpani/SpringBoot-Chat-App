package sk.plaut.ChatApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.WebApplicationInitializer;

import javax.annotation.ManagedBean;
import javax.servlet.annotation.WebListener;

@SpringBootApplication
@WebListener
@ManagedBean
@EnableAsync
public class ChatAppApplication extends SpringBootServletInitializer implements WebApplicationInitializer {


	public static void main(String[] args) {
		SpringApplication.run(ChatAppApplication.class, args);
	}
}
