package com.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	@GetMapping("/hi/{firstName}/{lastName}")
	public String sayHi(@PathVariable(value = "firstName") String name,@PathVariable(value = "lastName") String lastName) {//endpoint
		return "Hi "+name + " "+ lastName;
	}
	
	
	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable String name) {//endpoint
		return "hello "+name;
	}
	
	@GetMapping("/buildName/{name}")
	public String buildName(@PathVariable String name, @RequestParam(value = "middleName",required = true) String middleName,@RequestParam(value = "lastName",required = false) String lastName) {
		return name + " "+middleName  + " "+lastName ;
	}

}
