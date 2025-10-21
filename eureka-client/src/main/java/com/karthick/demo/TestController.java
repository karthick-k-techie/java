package com.karthick.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
@GetMapping
public String test() {
	return "Testing Eruka Client...";
}

@GetMapping("/hello")
public String hello() {
	//return new RestTemplate().getForObject("http://eureka-client/", String.class);
	return new RestTemplate().getForObject("http://localhost:8080/hello/", String.class);
}


}
