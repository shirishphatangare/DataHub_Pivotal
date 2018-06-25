package com.example.employeehierarchyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeehierarchyservice.model.Employee;
import com.example.employeehierarchyservice.service.EmployeeHierarchyService;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class EmployeeHierarchyController {

	@Autowired
	EmployeeHierarchyService employeeHierarchyService;
		
	@PreAuthorize("#oauth2.hasScope('read') and hasRole('ADMIN')")		   
	@GetMapping(value="/manager/find/{manager}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByManager(@PathVariable Long manager,@RequestHeader("Authorization") String bearerToken){
		System.out.println("*********** STEP 3 - EMPLOYEE HIERARCHY SERVICE ****************");
		List <Employee> emp = employeeHierarchyService.findByManager(manager);
		
		if (emp.size() == 0) {
			throw new RuntimeException(); // For Hystrix Failover Demo
		}
		return emp;
	}
	   
}
