package com.demo.cc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
