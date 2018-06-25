package com.example.employeedetailsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedetailsservice.model.Employee;
import com.example.employeedetailsservice.model.EmployeeInfo;
import com.example.employeedetailsservice.service.EmployeeDetailsService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class EmployeeDetailsController {
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	private EurekaClient discoveryClient;
	
	public String getServiceInstanceInformation() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("EMPLOYEE-DETAILS-SERVICE", false);
	    String instanceInformation = "";
	    if(instance != null)
	    	instanceInformation = instance.getHostName() + "---" + instance.getInstanceId() + "---" + instance.getIPAddr();
	    else {
	    	// For test case
	    	instanceInformation = "default port";
	    }
	    return instanceInformation;
	}

	   
	@PreAuthorize("#oauth2.hasScope('read') and (hasRole('ADMIN') or hasRole('USER'))")
	@GetMapping(value="/employee/find/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public EmployeeInfo findById(@PathVariable(value = "id") long id, @RequestHeader("Authorization") String bearerToken){
		System.out.println("*********** STEP 3 - EMPLOYEE DETAILS SERVICE ****************");
		Employee emp = employeeDetailsService.findById(id);
		
		if (emp == null) {
			throw new RuntimeException(); // For Hystrix Failover Demo
		}
		
		EmployeeInfo empInfo = new EmployeeInfo(emp.getId(),emp.getFirstname(),emp.getLastname(),emp.getRole(),emp.getManager(),emp.getPhone(),emp.getEmail(),emp.getAddress1(),emp.getAddress2(),emp.getCity(),emp.getState(),emp.getZip(),emp.getCountry(), getServiceInstanceInformation());
		return empInfo;
	}
	  
}
