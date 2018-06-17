package com.example.employeedetailsservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedetailsservice.model.Employee;
import com.example.employeedetailsservice.repo.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsService {
	
	@Autowired
	EmployeeDetailsRepository employeeRepository;
	
	public Employee findById(long id){
		Optional <Employee> emp = employeeRepository.findById(id);
		Employee employee = emp.get();
		return employee;
	}
}
