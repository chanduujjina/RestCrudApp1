package com.demo.cc.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EmployeeDto {
	

	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String gender;
	
	private String phoneNumber;
	
	private PassportDetailsDto passportDetails;
	
	
	private AaadharDetailsDto aadharDSetails;
	
	private List<AddressDto> addresses;
	
	private String deptName;
	
	private DepartmentDto department;//master table
	
	

}
