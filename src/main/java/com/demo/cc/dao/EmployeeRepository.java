package com.demo.cc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.cc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>,JpaSpecificationExecutor<Employee>{
	
	Employee findByNameAndEmail(String name,String email);
	
	
	Employee findByNameOrPhoneNumber(String name,String phoneNumber);
	
	
	//@Query(value = "from Employee")
	//List<Employee> getAllByJPQL();
	
	

}
