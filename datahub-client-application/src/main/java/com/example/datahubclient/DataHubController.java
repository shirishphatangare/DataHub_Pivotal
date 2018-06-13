package com.example.datahubclient;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

	@Controller
	public class DataHubController {
	    
		@Autowired
	    private RestTemplate restTemplate;
		
	    
		@RequestMapping("/index")
		public String welcome(Map<String, Object> model) {
			return "index";
		}
		
		
		@RequestMapping("/empDetails/{id}")
		public String getEmployeeDetails(Map<String, Object> model,@PathVariable Long id, @RequestHeader("Authorization") String bearerToken) {
			String url = "https://zuul-service-dev.cfapps.io/dashboard-feign/" + id;
	        HttpHeaders requestHeaders = new HttpHeaders();
	        requestHeaders.add("Authorization", bearerToken);
	        HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders);
	        System.out.println("requestHeaders:" + requestHeaders.toString());
	        ResponseEntity<EmployeeInfo> emp = restTemplate.exchange(url, HttpMethod.GET, httpEntity, EmployeeInfo.class);
	        model.put("employee", emp.getBody());
	        
	        Long managerId = emp.getBody().getManager();
	        String url1 = "https://zuul-service-dev.cfapps.io/dashboard-feign/" + managerId;
	        HttpHeaders requestHeaders1 = new HttpHeaders();
	        requestHeaders1.add("Authorization", bearerToken);
	        HttpEntity<?> httpEntity1 = new HttpEntity<Object>(requestHeaders1);
	        System.out.println("requestHeaders:" + requestHeaders1.toString());
	        ResponseEntity<EmployeeInfo> manager = restTemplate.exchange(url1, HttpMethod.GET, httpEntity1, EmployeeInfo.class);
	        model.put("manager", manager.getBody());

	        return "empDetails";
		}
		
		
		@RequestMapping("/empHierarchy/{id}")
		public String getEmployeeHierarchy(Map<String, Object> model,@PathVariable Long id, @RequestHeader("Authorization") String bearerToken) {
			String url = "https://zuul-service-dev.cfapps.io/dashboard-feign/" + id;
	        HttpHeaders requestHeaders = new HttpHeaders();
	        requestHeaders.add("Authorization", bearerToken);
	        HttpEntity<?> httpEntity = new HttpEntity<Object>(requestHeaders);
	        System.out.println("requestHeaders:" + requestHeaders.toString());
	        ResponseEntity<EmployeeInfo> manager = restTemplate.exchange(url, HttpMethod.GET, httpEntity, EmployeeInfo.class);
	        model.put("manager", manager.getBody());
			
			
			
			String url1 = "https://zuul-service-dev.cfapps.io/dashboard-feign/manager/" + id;
	        HttpHeaders requestHeaders1 = new HttpHeaders();
	        requestHeaders1.add("Authorization", bearerToken);
	        HttpEntity<?> httpEntity1 = new HttpEntity<Object>(requestHeaders1);
	        System.out.println("requestHeaders:" + requestHeaders1.toString());
	        ResponseEntity<Collection> emp = restTemplate.exchange(url1, HttpMethod.GET, httpEntity1, Collection.class);
	        model.put("employeeList", emp.getBody());
	        
	        return "empHierarchy";
		}
	}
