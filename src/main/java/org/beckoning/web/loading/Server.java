package org.beckoning.web.loading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource({"classpath*:spring/spring-database.xml"})
public class Server extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Server.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}
	
}
