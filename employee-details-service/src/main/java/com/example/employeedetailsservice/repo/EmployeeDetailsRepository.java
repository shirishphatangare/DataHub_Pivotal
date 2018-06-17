package com.example.employeedetailsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeedetailsservice.model.Employee;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<Employee, Long>{
	
}
