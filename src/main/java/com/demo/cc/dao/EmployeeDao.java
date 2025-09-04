package com.demo.cc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.cc.dto.SearchCritria;
import com.demo.cc.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository repository;
	
	

	public void saveEmployee(Employee employee) {
		repository.save(employee);
		
	}
	
	public Employee getEmployeeByNameAndemail(String name,String email) {
		return repository.findByNameAndEmail(name, email);
	}
	
	public List<Employee> getEmployeeByAttributes(SearchCritria searchCritria){
		return repository.findAll(EmployeeSpecfication.filterData(searchCritria));
	}

	
}
