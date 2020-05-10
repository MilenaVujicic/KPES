package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan("com.sample.model")
public class StartApp {
	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	}

}
