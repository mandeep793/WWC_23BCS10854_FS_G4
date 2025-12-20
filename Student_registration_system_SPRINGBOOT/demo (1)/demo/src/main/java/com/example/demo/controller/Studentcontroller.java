package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.service.Studentservice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RestController
@RequestMapping("/students") //base url
public class Studentcontroller {
    
    private final Studentservice studentservice;
    public Studentcontroller(){
        this.studentservice=new Studentservice();
    }
    @GetMapping("/all") //list of all students in json format-- http://localhost:8080/students/all
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentservice.getAllStudents();
        return ResponseEntity.ok(students);           
    }
    @GetMapping("/student") //http://localhost:8080/students/student?id=5
    public ResponseEntity<Student> getStudentById(@RequestParam int id){
        Student student=studentservice.getStudentbyId(id);
        if(student!=null){
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    // postman testing --http://localhost:8080/students/add?id=7&name=garuav&email=g@gamil.com&course=infosys
    public ResponseEntity<Student> addStudent(@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam String course){
        studentservice.addStudent(id,name,email,course);
        Student student=studentservice.getStudentbyId(id);
        return ResponseEntity.ok(student);
    } 

    @GetMapping("/delete") //http://localhost:8080/students/delete?id=5
        public ResponseEntity<Student> deleteStudent(@RequestParam int id){
            Student student=studentservice.deleteStudent(id);
            if(student!=null){
            return ResponseEntity.ok(student);
        }
        else{
            return ResponseEntity.notFound().build();
        }  
        }
}

    //tested the created APIs so far using postman
 

    


