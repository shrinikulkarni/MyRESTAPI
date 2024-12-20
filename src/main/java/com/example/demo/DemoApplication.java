package com.example.demo;

import com.example.demo.student.Student;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("***********************");
		System.out.println("Student Service running");
		System.out.println("***********************");
	};
	@GetMapping("/api/hello")
	public String sayHello() {
		return "Hello, Swagger!";
	}
}

	/*
	@GetMapping
	public String defaultMapping()
	{
		return ("This is default home mapping");
	}
	/*

	@GetMapping
	public List <String> hello()
	{
		return List.of("Hello","World");
	}
	*/
    /*
	@GetMapping
	public List <Student> hello()
	{
		return List.of (
				new Student (1234L, "Shrini",
						"shrink@gmail.com",
						 46,
						LocalDate.of(1972,Month.JULY,5)
				)
		);
	}
*/
