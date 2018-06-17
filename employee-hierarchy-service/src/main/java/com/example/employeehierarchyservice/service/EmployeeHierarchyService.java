package com.example.employeehierarchyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeehierarchyservice.model.Employee;
import com.example.employeehierarchyservice.repo.EmployeeHierarchyRepository;

@Service
public class EmployeeHierarchyService {
	
	@Autowired
	EmployeeHierarchyRepository employeeHierarchyRepository;
	

	public List<Employee> findByManager(long manager){
		List <Employee> emp = employeeHierarchyRepository.findByManager(manager);
		return emp;
	}
}
