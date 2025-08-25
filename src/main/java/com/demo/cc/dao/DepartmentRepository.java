package com.demo.cc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cc.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	 
	Department findByName(String name);

}
