package com.administrationrh;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.administrationrh.service.StorageService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TestApplication extends SpringBootServletInitializer{

	@Resource
	StorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
