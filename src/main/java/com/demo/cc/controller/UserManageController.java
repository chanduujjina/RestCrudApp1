package com.demo.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cc.dto.UserDto;
import com.demo.cc.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/userManage")
public class UserManageController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/save",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto){
		UserDto dto = userService.saveUser(userDto);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<UserDto> getEmployeeById(@PathVariable Integer id){
		
		UserDto userById = userService.getUserById(id);
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
	}
	
	@GetMapping("/employeebyName/{name}")
	public ResponseEntity<UserDto> getEmployeeByName(@PathVariable String name){
		
		UserDto userDto = userService.getUserByName(name);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}

}
