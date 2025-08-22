package com.demo.test;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Sample {//request dto
	
	
	@NotNull
	@Min(18)
	private Integer id;
	
	@NotNull
	@Range(min=2,max=30)
	private String name;
	
	
	@NotNull
	private String type;
	
	@Email(message="invalid email id")
	private String email;
	@Past
	private LocalDate Date;
	@FutureOrPresent
	private LocalDate Date1;
	@URL(message="invalid url")
	private String website;
	
	
	
	public String getWebsite() {
		return website;
	}

	
	public void setWebsite(String website) {
		this.website = website;
	}

	public LocalDate getDate() {
		return Date;
	}
	
	public void setDate(LocalDate date) {
		Date = date;
	}
	
	public LocalDate getDate1() {
		return Date1;
	}
	
	public void setDate1(LocalDate date1) {
		Date1 = date1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

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
