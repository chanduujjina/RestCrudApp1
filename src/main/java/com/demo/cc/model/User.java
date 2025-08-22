package com.demo.cc.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "name")
	private String userName;
	
	@Column
	private String email;
	
	@Column
	private LocalDate dob;
	
	@Column
	private String phoneNumber;
	
	@Column
	private LocalDate expireDate;
	
	@Column
	private Integer age;

}
