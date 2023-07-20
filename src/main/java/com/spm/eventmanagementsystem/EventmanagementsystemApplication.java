package com.spm.eventmanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //This make the Not authorized error
// go away in postman
public class EventmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementsystemApplication.class, args);
	}

	//This model mapper was added by using the modelmapper dependency
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}

//comment new