package com.example.webService.RestFullService.Helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/helloworld")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World");

	}
	
	@GetMapping(path="/helloworld/{name}")
	public HelloWorldBean getHelloWorld(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World : %s", name));
		
	}
}


