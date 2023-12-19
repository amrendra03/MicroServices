package com.rating.ratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingserviceApplication.class, args);
		System.out.println("rating service started...");
	}

}
