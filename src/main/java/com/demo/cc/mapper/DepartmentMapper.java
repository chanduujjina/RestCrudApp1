package com.demo.cc.mapper;

import org.mapstruct.Mapper;

import com.demo.cc.dto.DepartmentDto;
import com.demo.cc.model.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	
	Department toEntity(DepartmentDto departmentDto);
	
	DepartmentDto todto(Department department);

}
