package com.demo.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo")
public class RestCrudApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudApp1Application.class, args);
	}

}
