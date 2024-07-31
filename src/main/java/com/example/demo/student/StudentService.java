package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {
    public List<Student> getStudents (){
        Long id = 3L;
        String name = "Shrini";
        String email = "shrinik@gmail.com";
        Integer age = 45;
        LocalDate dob = LocalDate.of(1970, Month.JULY, 26);
        Student sampleStudent = new Student(id, name, email, age, dob);
        return List.of(sampleStudent);
    }
}
