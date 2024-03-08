package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
//@Table(name="Student_Table")
//This will create a table with this name if not given this annotation
// by default table will be created with class name
public class Student {

    @Id
    //to generate the id automatically (first column)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    //@Column(name = "Stud_Id")
    private long studId;

    private String studName;
    private int age;
    private String grade;

    public Student(String studName, int age, String grade) {
        this.studName = studName;
        this.age = age;
        this.grade = grade;
    }
}
