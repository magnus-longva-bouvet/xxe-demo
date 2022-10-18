package no.sikkerhetshull.xxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class XxeApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(XxeApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", System.getenv("port")));
		app.run(args);
	}

}
