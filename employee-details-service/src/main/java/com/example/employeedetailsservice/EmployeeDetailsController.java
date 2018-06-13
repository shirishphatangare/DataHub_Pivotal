package com.example.employeedetailsservice;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedetailsservice.entity.Employee;
import com.example.employeedetailsservice.entity.EmployeeInfo;
import com.example.employeedetailsservice.service.EmployeeRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class EmployeeDetailsController {
		@Autowired
		EmployeeRepository employeeRepository;
		
		@Autowired
		private EurekaClient discoveryClient;

		public String getServiceInstanceInformation() {
		    InstanceInfo instance = discoveryClient.getNextServerFromEureka("EMPLOYEE-DETAILS-SERVICE", false);
		    String instanceInformation = instance.getHostName() + "---" + instance.getInstanceId() + "---" + instance.getIPAddr();
		    return instanceInformation;
		}

	   
	  @RequestMapping("/employee/find/{id}")
	   public EmployeeInfo findById(@PathVariable(value = "id") long id, @RequestHeader("Authorization") String bearerToken){
		  Optional <Employee> emp = employeeRepository.findById(id);
		  EmployeeInfo empInfo = new EmployeeInfo(emp.get().getId(),emp.get().getFirstname(),emp.get().getLastname(),emp.get().getRole(),emp.get().getManager(),emp.get().getPhone(),emp.get().getEmail(),emp.get().getAddress1(),emp.get().getAddress2(),emp.get().getCity(),emp.get().getState(),emp.get().getZip(),emp.get().getCountry(), getServiceInstanceInformation());
	      return empInfo;
	   }
	  
	  @RequestMapping("/employee/findTest/{id}")
	   public EmployeeInfo findByIdTest(@PathVariable(value = "id") long id){
		  Optional <Employee> emp = employeeRepository.findById(id);
		  EmployeeInfo empInfo = new EmployeeInfo(emp.get().getId(),emp.get().getFirstname(),emp.get().getLastname(),emp.get().getRole(),emp.get().getManager(),emp.get().getPhone(),emp.get().getEmail(),emp.get().getAddress1(),emp.get().getAddress2(),emp.get().getCity(),emp.get().getState(),emp.get().getZip(),emp.get().getCountry(), getServiceInstanceInformation());
	      return empInfo;
	   }
	   
	   @RequestMapping("/employee/findall")
	   public Collection<Employee> findAll(@RequestHeader("Authorization") String bearerToken){
	      return employeeRepository.findAll();
	   }

}
