package com.example.employeeauthserver;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class EmployeeAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAuthServerApplication.class, args);
	}
	
	@RequestMapping("/user")
	Principal getUser(Principal user) {
		return user;
	}
	
}
