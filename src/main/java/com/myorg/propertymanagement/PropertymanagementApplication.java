package com.myorg.propertymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertymanagementApplication {

	public static void main(String[] args) {
//		Dotenv dotenv = Dotenv.load();
//
//		// Set environment variables
//		System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("SPRING_DATASOURCE_URL"));
//		System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
//		System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));

		SpringApplication.run(PropertymanagementApplication.class, args);
	}

}
