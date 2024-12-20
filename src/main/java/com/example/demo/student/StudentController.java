package com.example.demo.student;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController
{
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseBody
    @Operation(summary = "Get All Students", description = "Fetch list of students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    @Operation(summary = "Create a new student", description = "Create a new student")
    public StudentResponse  registerNewStudent (@RequestBody Student student){
        return studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    @Operation(summary = "Delete Student by ID", description = "Delete Student by ID")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        System.out.println("The id of the student to be deleted is " + studentId);
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    @Operation(summary = "Update Student details by ID", description = "Update Student details by ID")
    public StudentResponse updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required=false) String name,
            @RequestParam(required = false) String email
            )
    {
        return studentService.updateStudent(studentId, name, email);
    }
}

