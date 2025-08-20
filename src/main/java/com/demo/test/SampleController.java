package com.demo.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/manageSample")

public class SampleController {
	
	@PostMapping
	public ResponseEntity<Sample> saveSample( @Valid @RequestBody Sample sample){
		return new ResponseEntity<>(sample, HttpStatus.CREATED);
	}

}
