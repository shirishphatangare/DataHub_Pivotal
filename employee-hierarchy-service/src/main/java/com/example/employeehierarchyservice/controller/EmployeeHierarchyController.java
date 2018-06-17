package com.example.employeehierarchyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeehierarchyservice.model.Employee;
import com.example.employeehierarchyservice.service.EmployeeHierarchyService;

@RestController
public class EmployeeHierarchyController {

	@Autowired
	EmployeeHierarchyService employeeHierarchyService;
		
			   
	@RequestMapping("/manager/find/{manager}")
	public List<Employee> findByManager(@PathVariable Long manager,@RequestHeader("Authorization") String bearerToken){
		System.out.println("*********** STEP 3 - EMPLOYEE HIERARCHY SERVICE ****************");
		List <Employee> emp = employeeHierarchyService.findByManager(manager);
		return emp;
	}
	   
}
