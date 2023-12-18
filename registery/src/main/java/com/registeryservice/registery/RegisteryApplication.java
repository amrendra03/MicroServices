package com.registeryservice.registery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisteryApplication.class, args);
		System.out.println("Registry server Started...");
	}

}
