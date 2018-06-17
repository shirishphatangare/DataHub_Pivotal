package com.example.employeehierarchyservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeehierarchyservice.model.Employee;


@Repository
public interface EmployeeHierarchyRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByManager(long manager);

}
