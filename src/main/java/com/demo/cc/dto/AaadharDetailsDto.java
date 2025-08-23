package com.demo.cc.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AaadharDetailsDto {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String aadharNo;
	
	private String aadharName;
	
	private String issuedDate;
	
	private String expireDate;
	
}
