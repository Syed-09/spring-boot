package com.example.springboot.service;


import com.example.springboot.model.Student;

import java.util.List;

public interface StudentService {
    public void addStudent(Student student);
    public List<Student> getAllStudents();

    public Student getStudentById(long studId);

    public boolean deleteStudentById(long studId);

}
