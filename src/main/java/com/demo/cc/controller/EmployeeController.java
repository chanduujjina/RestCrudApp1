package com.demo.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cc.dto.EmployeeDto;
import com.demo.cc.dto.SearchCritria;
import com.demo.cc.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/empManage")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto employeeDto){
	  try {
		  service.saveEmployee(employeeDto);
		  return new ResponseEntity<>("Employee details saved sucessfully", HttpStatus.CREATED);
	  }
	  catch(Exception ex) {
		  ex.printStackTrace();
		    log.error("error while saving into db",ex.getMessage());
			return new ResponseEntity<>("Error while saving details into db", HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@GetMapping("/getEmployee/{name}/{email}")
	public ResponseEntity<EmployeeDto> getEmployeeByNameAngEmail(@PathVariable("name") String name,@PathVariable("email") String email){
		EmployeeDto employeeDto = service.getEmployeeByNameAndGender(name, email) ;
		
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
	}
	
	@PutMapping("/employee/byAttribute")
	public ResponseEntity<List<EmployeeDto>> getEmployees(@RequestBody SearchCritria searchCritria){
		List<EmployeeDto> employeesByAttributes = service.getEmployeesByAttributes(searchCritria);
		
		return new ResponseEntity<>(employeesByAttributes, HttpStatus.OK);
	}
	
	
	

}
