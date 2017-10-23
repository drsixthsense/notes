package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class NotesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(NotesApplication.class).web(true).run(args);
	}

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
		return application.sources(NotesApplication.class).web(true);
	}
}
