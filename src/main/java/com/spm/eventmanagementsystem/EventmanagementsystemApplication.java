package com.spm.eventmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //This make the Not authorized error
// go away in postman
public class EventmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementsystemApplication.class, args);
	}

}

//comment new