<<<<<<< HEAD
package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
=======
package com.example.demo.student;

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
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping
    public StudentResponse  registerNewStudent (@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        System.out.println("The id of the student to be deleted is " + studentId);
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public StudentResponse updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required=false) String name,
            @RequestParam(required = false) String email
            )
    {
        return studentService.updateStudent(studentId, name, email);
    }
}
>>>>>>> 41f8d8a2c4ec7fdb1df48c8e50e6fceaaa4f4717
