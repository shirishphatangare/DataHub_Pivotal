package com.example.employeemaster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemaster.config.EmployeeServiceProxy;
import com.example.employeemaster.config.ManagerServiceProxy;
import com.example.employeemaster.model.Employee;
import com.example.employeemaster.model.EmployeeInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

	@RestController
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableResourceServer
	@EnableCircuitBreaker
	public class EmployeeMasterController {
	    
		@Autowired
		private EmployeeServiceProxy employeeServiceProxy; 
	    
		@Autowired
		private ManagerServiceProxy managerServiceProxy; 
		
		@PreAuthorize("#oauth2.hasScope('read') and (hasRole('ADMIN') or hasRole('USER'))")
	    @HystrixCommand(
	    		fallbackMethod = "reliablefindmeFeign", 
	    		groupKey = "EmployeeServiceUIGroupKey", 
				commandKey = "EmployeeServiceUIFindEmployeeCommandKey", 
				threadPoolKey = "EmployeeServiceThreadPoolKey",
				commandProperties= { @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="60000"),
									 @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="5")})
	    @GetMapping(value = "/dashboard-feign/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    public EmployeeInfo findmeFeign(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken) {
	    	System.out.println("*********** STEP 2 - EMPLOYEE MASTER SERVICE ****************");
	    	EmployeeInfo emp = employeeServiceProxy.getEmployeeData(id, bearerToken);
	        return emp;
	    }  
	    
	    public EmployeeInfo reliablefindmeFeign(Long id,String bearerToken) {
	    	EmployeeInfo emp = new EmployeeInfo(1000,"Not Found", "Not Found", "Not Found",5000,"Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","9999");
	    	return emp;
	    }
	    
	    @PreAuthorize("#oauth2.hasScope('read') and hasRole('ADMIN')")
	    @HystrixCommand(fallbackMethod = "reliablefindmanagerFeign", 
	    				groupKey = "EmployeeServiceUIGroupKey", 
	    				commandKey = "EmployeeServiceUIFindManagerCommandKey", 
	    				threadPoolKey = "ManagerServiceThreadPoolKey",
	    				commandProperties= { @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="60000"),
	    									 @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="5")})
	    @GetMapping(value = "/dashboard-feign/manager/{manager}",produces=MediaType.APPLICATION_JSON_VALUE)
	    public List<Employee> findmanagerFeign(@PathVariable Long manager,@RequestHeader("Authorization") String bearerToken) {
	    	System.out.println("*********** STEP 2 - EMPLOYEE MASTER SERVICE ****************");
	    	List<Employee> empList = managerServiceProxy.getManagerData(manager,bearerToken);
	        return empList;
	    }

	    
	    public List<Employee> reliablefindmanagerFeign(Long manager,String bearerToken) {
	    	List<Employee> empList = new ArrayList<Employee>();
	    	empList.add(new Employee(1000,"Not Found", "Not Found", "Not Found",5000,"Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found"));
	    	empList.add(new Employee(1000,"Not Found", "Not Found", "Not Found",5000,"Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found"));	    	
	    	return empList;
	    }
	}
