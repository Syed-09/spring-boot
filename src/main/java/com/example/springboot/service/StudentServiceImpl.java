package com.example.springboot.service;


import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository repository;
    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStuds = repository.findAll();
        return allStuds;
    }
    @Override
    public Student getStudentById(long id) {
        Optional<Student> optionalStudent = repository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public boolean deleteStudentById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true; // Student deleted successfully
        }
        return false; // Student not found or unable to delete
    }
}