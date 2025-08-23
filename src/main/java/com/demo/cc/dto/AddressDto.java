package com.demo.cc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AddressDto {
	
	
	private Long id;
	
	private String addType;
	private String line1;
	
	private String line2;
	
	private String state;
	
	private String country;
	

}
