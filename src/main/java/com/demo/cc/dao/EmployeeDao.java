package com.demo.cc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.cc.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository repository;

	public void saveEmployee(Employee employee) {
		repository.save(employee);
		
	}
}
