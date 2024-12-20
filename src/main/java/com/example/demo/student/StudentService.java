<<<<<<< HEAD
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
=======
package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService (StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    /*
    public List<Student> getStudents (){
        Long id = 3L;
        String name = "Shrini";
        String email = "shrinik@gmail.com";
        Integer age = 45;
        LocalDate dob = LocalDate.of(1970, Month.JULY, 26);
        Student sampleStudent = new Student(id, name, email, age, dob);
        return List.of(sampleStudent);
    }
    */
    public List<Student> getStudents (){
        return studentRepository.findAll();
    }

    public StudentResponse addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
          throw new IllegalStateException("email taken already");
        }
        System.out.println("Incoming student object: " + student);
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("DOB: " + student.getDob());
        Student savedStudent = studentRepository.save(student);
        String message = "Student with name " + savedStudent.getName() + " has been created";
        return new StudentResponse(message, savedStudent.getId());
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public StudentResponse updateStudent(Long studentId, String name, String email)
    {
        Student student = studentRepository.findById(studentId)
                .orElseThrow( ()-> new IllegalStateException("student with id " + studentId + "does not exist"));
        String message1 = "Student old info : " + student.getName() + " and " + student.getEmail() + "*****";
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(),name))
        {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email))
        {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent())
            {
                throw new IllegalStateException("Email" + email + " is taken already");
            }
            student.setEmail(email);
         }
        Student savedStudent = studentRepository.save(student);
        String message2 = "Student new info : " + student.getName() + " and " + student.getEmail();
        String message = message1 + message2;
        return new StudentResponse(message,studentId);
    }


}
>>>>>>> 41f8d8a2c4ec7fdb1df48c8e50e6fceaaa4f4717
