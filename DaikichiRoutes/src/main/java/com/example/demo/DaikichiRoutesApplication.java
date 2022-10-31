package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController

@RequestMapping("/Daikichi")


public class DaikichiRoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiRoutesApplication.class, args);
	}

    @RequestMapping("")

    public String DaikichiController() {
    	return "Welcome";
    }
    
    @RequestMapping("/today")
    public String Today() {
    	return "Today you will find luck in your endeavors!";
    }
    
    @RequestMapping("/tomorrow")

    public String Tomoroow() {
    	return "tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

}
