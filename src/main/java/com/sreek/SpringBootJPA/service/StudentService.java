package com.sreek.SpringBootJPA.service;

import com.sreek.SpringBootJPA.Repository.StudentRepository;
import com.sreek.SpringBootJPA.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudent(Long id) {
        return repository.findById(id);
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> removeStudent(Long id) {
        Optional<Student> student = repository.findById(id);
        if(student.isPresent()) {
            repository.deleteById(id);
        }
        return student;
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }

}

