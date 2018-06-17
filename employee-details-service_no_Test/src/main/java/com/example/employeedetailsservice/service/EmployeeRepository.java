package com.example.employeedetailsservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeedetailsservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
