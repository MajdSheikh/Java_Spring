package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloHuman {

	@RequestMapping("/")
	public String hello(@RequestParam(value="q") String searchQuery) {
	
		if(searchQuery == null) {
			return "Hello Human";
		}
		else {
			return "Hello " + searchQuery;
		}

    }
}
	



