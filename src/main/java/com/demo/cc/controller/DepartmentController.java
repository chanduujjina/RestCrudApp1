package com.demo.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cc.dto.DepartmentDto;
import com.demo.cc.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/manageDept")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<String> saveDepartmentDetails(@RequestBody List<DepartmentDto> departmentDtos){
		try {
			departmentService.saveDeptdetails(departmentDtos);
			return new ResponseEntity<>("Department details saved sucessfully", HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("error while saving into db",e.getMessage());
			return new ResponseEntity<>("Error while saving details into db", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
