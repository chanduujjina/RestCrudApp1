package com.demo.test;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Sample {//request dto
	
	
	@NotNull
	@Min(18)
	private Integer id;
	
	@NotNull
	private String name;
	
	
	@NotNull
	private String type;
	
	
	@Pattern(regexp="\\d{10}")
	private String phoNeNumber;
	
	
	public String getPhoNeNumber() {
		return phoNeNumber;
	}

	public void setPhoNeNumber(String phoNeNumber) {
		this.phoNeNumber = phoNeNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
