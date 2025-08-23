package com.demo.cc.model;

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

@Entity
@Table(name = "employee_info")
@Data
@NoArgsConstructor
public class Employee {
	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String gender;
	
	private String phoneNumber;
	
	@OneToOne(mappedBy =  "employee",targetEntity= PassportDetails.class,cascade = CascadeType.ALL,orphanRemoval = true)//transaction table
	private PassportDetails passportDetails;
	
	
	@OneToOne(mappedBy =  "employee",targetEntity= AaadharDetails.class,cascade = CascadeType.ALL,orphanRemoval = true)//transaction table
	private AaadharDetails aadharDSetails;
	
	@OneToMany(mappedBy = "employee",targetEntity = Address.class,cascade = CascadeType.ALL,orphanRemoval = true)//transaction table
	private List<Address> addresses;
	
	@OneToOne
	@JoinColumn(name = "dept_id")
	private Department department;//master table
	
	

}
