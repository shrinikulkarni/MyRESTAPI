package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            Student priya = new Student(
                            "Priya",
                            "pd@gmail.com",
                             LocalDate.of(2000,1,5)
                        );
            Student alex = new Student(
                            "Alex",
                            "Ax@gmail.com",
                            LocalDate.of(2003,12,15)
            );
            repository.saveAll(
                    List.of (priya,alex)
            );

        };
    };
}
