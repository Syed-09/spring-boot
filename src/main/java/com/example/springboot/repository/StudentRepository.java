package com.example.springboot.repository;

import com.example.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//this replaces -- DAO in spring mvc
public interface StudentRepository extends JpaRepository<Student, Long> {

//    You can also give your custom queries here instead using default methods

    Student findByStudName(String name);

    @Query(nativeQuery = true, value = "SELECT * from Student where age =(SELECT MAX(age) FROM Student)")
    Student findOldestStudent();
}