package com.demo.cc.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cc.dao.DepartmentRepository;
import com.demo.cc.dao.EmployeeDao;
import com.demo.cc.dto.EmployeeDto;
import com.demo.cc.mapper.EmployeeMapper;
import com.demo.cc.model.Department;
import com.demo.cc.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void saveEmployee(EmployeeDto employeeDto) {
		Employee employee = employeeMapper.toEntity(employeeDto);
		
		Department department = departmentRepository.findByName(employeeDto.getDeptName());
		if (null != department) {
			employee.setDepartment(department);
			department.setEmployees(Arrays.asList(employee));
		}
		dao.saveEmployee(employee);
	}

}
