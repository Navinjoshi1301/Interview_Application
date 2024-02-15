package com.interview.interviewapp.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.interviewapp.entities.Student;
import com.interview.interviewapp.services.StudentServices;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class StudentController {
    @Autowired
    private StudentServices services;
    //add a student
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student student2=null;
       try {
         student2= services.addStudent(student);
         return ResponseEntity.of(Optional.of(student2));
       } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
       
    }
    //add studentss
    
    @PostMapping("/students")
    public ResponseEntity<List <Student
    >>addStudents(@RequestBody List<Student> students) { 
        List<Student>students2=null;
        try {
            students2=services.addStudents(students);
            return ResponseEntity.of(Optional.of(students2));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    // get student by id
    @GetMapping("/student/{Id}")
    public ResponseEntity<Student> getStudent(@PathVariable int Id){
        Student student=services.getStudentbyId(Id);
        if(student==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(student));
    }
    //get studentss
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){

        List<Student> list=services.getStudents(); 
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       return ResponseEntity.of(Optional.of(list));
    }
    //deletestudent 
    @DeleteMapping("/students/{Id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int Id){

        try {
            services.deleteStudentbyId(Id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

       

    }
    //update level
    @PutMapping("/students/{Id}")
    public ResponseEntity<Student> updateStudentLevel(@RequestBody Student student, @PathVariable int Id){

        try {
             services.updateLevel(student,Id);
             return ResponseEntity.ok().body(student);
        } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    }