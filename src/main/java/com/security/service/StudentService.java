package com.security.service;

import com.security.model.Student;
import com.security.repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentsRepo repo;

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public Optional<Student> getStudentById(int stuId){
        return repo.findById(stuId);
    }

    public void addStudent(Student student){
        repo.save(student);
    }

    public void updateStudent(Student student){
        repo.save(student);
    }

    public void deleteStudent(int stuId){
        repo.deleteById(stuId);
    }
}
