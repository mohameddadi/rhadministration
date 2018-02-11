package com.administrationrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TestApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
