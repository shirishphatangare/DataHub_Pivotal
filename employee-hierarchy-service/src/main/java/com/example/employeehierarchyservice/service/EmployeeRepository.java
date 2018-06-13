package com.example.employeehierarchyservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeehierarchyservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByManager(long manager);

}
