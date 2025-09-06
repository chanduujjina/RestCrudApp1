package com.demo.cc.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.cc.dto.DepartmentDto;
import com.demo.cc.model.Department;
import com.demo.cc.service.DepartmentService;

@ExtendWith(MockitoExtension.class)
public class TestDepartmentController {
	
	@InjectMocks
	private DepartmentController departmentController;
	
	@Mock
	private DepartmentService departmentService;
	
	@Test
	public void testSaveDepartmentDetails() {
		List<DepartmentDto> departmentDetailsFromUI = getDepartmentDetails();
		List<Department> departmentsFromDB = getDepartment();
		
		Mockito.when(departmentService.saveDeptdetails(Mockito.anyList())).thenReturn(departmentsFromDB);
		departmentController.saveDepartmentDetails(departmentDetailsFromUI);
	}
	
	private List<DepartmentDto> getDepartmentDetails(){
		List<DepartmentDto> departmentDtos = new ArrayList<>();
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setName("IT");
		departmentDto.setDescription("Information Technology");
		departmentDtos.add(departmentDto);
		return departmentDtos;
	}
	
	private List<Department> getDepartment(){
		List<Department> departmentList = new ArrayList<>();
		Department department = new Department();
		department.setName("IT");
		department.setDescription("Information Technology");
		department.setId(1L);
		departmentList.add(department);
		return departmentList;
	}

}
