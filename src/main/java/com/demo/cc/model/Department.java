package com.demo.cc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dept_info")
@NoArgsConstructor
@Data
public class Department {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	

	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employees = new ArrayList<>(); 
	

}
