package com.demo.cc.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {
	
	private Integer userId;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	@Email
	private String email;
	
	@Past
	private LocalDate dob;
	
	@Pattern(regexp = "\\d{10}")
	private String phoneNumber;
	
	@FutureOrPresent
	private LocalDate expireDate;
	
	@Min(18) @Max(99)
	private Integer age;
	
}
