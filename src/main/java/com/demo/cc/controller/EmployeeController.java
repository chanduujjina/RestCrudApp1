package com.demo.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cc.dto.EmployeeDto;
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

}
