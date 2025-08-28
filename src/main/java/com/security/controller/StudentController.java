package com.security.controller;

import com.security.model.Student;
import com.security.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

//    private List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

    @GetMapping("/students/{stuId}")
    public Optional<Student> getStudentById(@PathVariable int stuId){
        return service.getStudentById(stuId);
    }

    @PostMapping("/students")
    public void addStudents(@RequestBody Student student){
        service.addStudent(student);
    }

    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody int stuId){
         service.deleteStudent(stuId);
    }
}
