package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@SpringBootApplication
@EntityScan("com.sample.model")
public class StartApp {
	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	}

}
