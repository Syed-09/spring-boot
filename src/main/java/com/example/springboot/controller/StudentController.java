package com.example.springboot.controller;

//create a seperate controller for each model created
import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;
import com.example.springboot.service.StudentService;
import com.example.springboot.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

//Use this, if you want display data in browser's console using JavaScript(VS Code)
@CrossOrigin(origins = "http://127.0.0.1:3000")
//@CrossOrigin(origins = "*")

@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    StudentRepository repository;

    @PostMapping("/add-student") //use this than below
    //@RequestMapping(value = "/student", method = "post")
    public ResponseEntity<String> addStudent(@RequestBody Student stud){
        service.addStudent(stud);
        return new ResponseEntity<String>("Student created!",HttpStatus.CREATED);
        //you can add any string in place of http
    }

    @GetMapping("/get-all-students") //use this than below
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

//    @GetMapping("/get-stud-by-id")
//    public Student getStudById(){
//        return service.getStudentById(2);
//    }

    //use this while using student alone
    @GetMapping("/get-stud-by-id/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id) {
        Student student = service.getStudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("No Student with the ID",HttpStatus.NOT_FOUND);
        }
    }

    ////Use this while combining course and stud
//    @GetMapping("/get-stud-by-id")
//    public ResponseEntity<?> getStudentById(@RequestParam("id") long id) {
//        Student student = service.getStudentById(id);
//        if (student != null) {
//            return new ResponseEntity<>(student, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<String>("No Student with the ID",HttpStatus.NOT_FOUND);
//        }
//    }

//    @GetMapping("/delete-stud-by-id")
//    public ResponseEntity<String> delStudById(){
//        service.deleteStudentById(2);
//        return new ResponseEntity.ok("Student with ID " + id + " deleted successfully.);
//    }
    @DeleteMapping("/delete-stud-by-id/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id) {
        boolean deleted = service.deleteStudentById(id);
        if (deleted) {
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //    Using RequestBody and using Post Method
    @PostMapping("/stud")
    public Student getStudent(@RequestBody long studId) {
        Optional<Student> student = repository.findById(studId);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }


//    @GetMapping("/oldest-stud")
//    public ResponseEntity<Student> findOldest(){
//        return new ResponseEntity<>(service.findOlder)
//    }

//    @PostMapping("/get-stud-by-course")
//    public Student getStudent(@RequestBody long studId){
//        Optional<Student> student = repository.findById(studId);
//        return student.orElse(null);
//    }

}


