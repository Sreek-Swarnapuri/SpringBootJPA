package com.sreek.SpringBootJPA.controller;

import com.sreek.SpringBootJPA.entity.Student;
import com.sreek.SpringBootJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> geStudent(@Param("id") Long id) {
        return service.getStudent(id);
    }

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @PutMapping("/update-student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/remove-student/{id}")
    public Optional<Student> removeStudent(@Param("id") Long id) {
        return service.removeStudent(id);
    }

}
