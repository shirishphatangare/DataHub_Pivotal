package com.example.employeemaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

	@RefreshScope
	@RestController
	public class EmployeeMasterController {
	    
		@Autowired
		private EmployeeServiceProxy employeeServiceProxy; 
	    
		@Autowired
		private ManagerServiceProxy managerServiceProxy; 

	    @HystrixCommand(fallbackMethod = "reliablefindmeFeign")
	    @RequestMapping(value = "/dashboard-feign/{id}")
	    public EmployeeInfo findmeFeign(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken) {
	    	System.out.println("*********** STEP 2 - EMPLOYEE MASTER SERVICE ****************");
	    	EmployeeInfo emp = employeeServiceProxy.getEmployeeData(id, bearerToken);
	        return emp;
	    }  
	    
	    public EmployeeInfo reliablefindmeFeign(Long id,String bearerToken) {
	    	EmployeeInfo emp = new EmployeeInfo(1000,"Not Found", "Not Found", "Not Found",5000,"Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","Not Found","9999");
	    	return emp;
	    }
	    
	    
	    @HystrixCommand(fallbackMethod = "reliablefindmanagerFeign")
	    @RequestMapping(value = "/dashboard-feign/manager/{manager}")
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
