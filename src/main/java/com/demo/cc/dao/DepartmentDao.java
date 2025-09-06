package com.demo.cc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.cc.model.Department;

@Repository
public class DepartmentDao {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> saveDeptDetails(List<Department> deptList) {
		return departmentRepository.saveAll(deptList);
	}
	
	

}
