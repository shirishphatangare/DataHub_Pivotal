package com.example.employeehierarchyservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeehierarchyservice.entity.Employee;
import com.example.employeehierarchyservice.service.EmployeeRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class EmployeeHierarchyController {
		@Autowired
		EmployeeRepository employeeRepository;
		
		@Autowired
		private EurekaClient discoveryClient;


		public String getServiceInstanceInformation() {
			InstanceInfo instance = discoveryClient.getNextServerFromEureka("EMPLOYEE-HIERARCHY-SERVICE", false);
			String instanceInformation = instance.getHostName() + "---" + instance.getInstanceId() + "---" + instance.getIPAddr();
			return instanceInformation;
		}	
			   
		@RequestMapping("/manager/find/{manager}")
		public List<Employee> findByManager(@PathVariable Long manager,@RequestHeader("Authorization") String bearerToken){
			System.out.println("*********** STEP 3 - EMPLOYEE HIERARCHY SERVICE ****************");
			List <Employee> emp = employeeRepository.findByManager(manager);
			return emp;
		}
	   
}
