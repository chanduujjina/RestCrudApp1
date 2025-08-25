package com.demo.cc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cc.dao.DepartmentDao;
import com.demo.cc.dto.DepartmentDto;
import com.demo.cc.mapper.DepartmentMapper;
import com.demo.cc.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public void saveDeptdetails(List<DepartmentDto> deptList) {
		
		List<Department> deptdbList = new ArrayList<>();
		
		for (DepartmentDto departmentDto : deptList) {
			Department entity = departmentMapper.toEntity(departmentDto);
			deptdbList.add(entity);
		}
		
		departmentDao.saveDeptDetails(deptdbList);
	}


}
