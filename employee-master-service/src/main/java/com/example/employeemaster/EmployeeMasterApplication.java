package com.example.employeemaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients("com.example.employeemaster")
public class EmployeeMasterApplication {

	public static void main(String[] args) {
		System.out.println("Inside EmployeeMasterApplication...");
		SpringApplication.run(EmployeeMasterApplication.class, args);
	}
	
}
