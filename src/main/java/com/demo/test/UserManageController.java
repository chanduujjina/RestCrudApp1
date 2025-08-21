package com.demo.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/userManage")
public class UserManageController {
	
	@PostMapping(value = "/save",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserInfo userInfo){
		return new ResponseEntity<String>("Validation is sucess proceed further to save", HttpStatus.CREATED);
	}

}
