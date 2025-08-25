package com.demo.cc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aadhar_info")
@Data
@NoArgsConstructor
public class AaadharDetails {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String aadharNo;
	
	private String aadharName;
	
	private String issuedDate;
	
	private String expireDate;
	
	@OneToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	

}
