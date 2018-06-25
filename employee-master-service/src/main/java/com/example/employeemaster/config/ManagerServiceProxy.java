package com.example.employeemaster.config;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.employeemaster.model.Employee;

@FeignClient(name="zuul-service")
@RibbonClient(name="EMPLOYEE-HIERARCHY-SERVICE")
public interface ManagerServiceProxy {
	@GetMapping("/manager/find/{manager}" )
	public List <Employee> getManagerData(@PathVariable("manager") Long manager, @RequestHeader("Authorization") String bearerToken);
}
