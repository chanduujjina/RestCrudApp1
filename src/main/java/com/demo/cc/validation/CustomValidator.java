package com.demo.cc.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomValidator {
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("status", HttpStatus.BAD_REQUEST);
		map.put("error", "Validation Failed");
	    Map<String,String> fieldErrors = new HashMap<>();
	    
	    ex.getBindingResult().getFieldErrors().forEach(error->{
	    	fieldErrors.put(error.getField(), error.getDefaultMessage());
	    });
	    map.put("body", fieldErrors);
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(exception = HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String,Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("status", HttpStatus.BAD_REQUEST);
		map.put("error", ex.getMessage());
	    
	    
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handleMissingParam(MissingServletRequestParameterException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("parameter", ex.getParameterName());
        error.put("message", "Request parameter is missing or required");
        return ResponseEntity.badRequest().body(error);
    }

}
