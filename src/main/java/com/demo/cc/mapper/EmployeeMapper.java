package com.demo.cc.mapper;

import java.util.Arrays;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.demo.cc.dto.EmployeeDto;
import com.demo.cc.model.Employee;

@Mapper(componentModel = "spring",uses = {PassportMapper.class,AadharMapper.class,AddressMapper.class,DepartmentMapper.class})
public interface EmployeeMapper {
	
	Employee toEntity(EmployeeDto employeeDto);
	
	@AfterMapping
	default void setNestedObjects(@MappingTarget Employee employee) {
		if (employee != null) {
			if (employee.getPassportDetails() != null) {
			employee.getPassportDetails().setEmployee(employee);
			}
			if (employee.getAadharDSetails() != null) {
				employee.getAadharDSetails().setEmployee(employee);
			}
			
			if (employee.getAddresses() != null && !employee.getAddresses().isEmpty()) {
				employee.getAddresses().stream().forEach(addr -> addr.setEmployee(employee));
			}
			
			
			
		}
	}

}
