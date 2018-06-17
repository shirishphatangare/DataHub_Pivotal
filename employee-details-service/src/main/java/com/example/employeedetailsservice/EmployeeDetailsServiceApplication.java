package com.example.employeedetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer

public class EmployeeDetailsServiceApplication {

	public static void main(String[] args) {
		System.out.println("Inside EmployeeDetailsServiceApplication..");
		SpringApplication.run(EmployeeDetailsServiceApplication.class, args);
	}

}