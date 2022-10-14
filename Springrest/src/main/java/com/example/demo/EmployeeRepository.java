package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//JPQL
	
	@Query("select employee from Employee employee where empname=?1")
	public List<Employee> findbyname(String name);
}
