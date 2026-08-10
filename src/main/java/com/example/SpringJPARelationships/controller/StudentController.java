package com.example.SpringJPARelationships.controller;

import com.example.SpringJPARelationships.model.Department;
import com.example.SpringJPARelationships.model.Student;
import com.example.SpringJPARelationships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    public  StudentController(StudentService studentService){
        this.studentService=studentService;
    }



    @PostMapping
    public ResponseEntity<String > createStudent(@RequestBody Student student , @RequestParam String dptName){
        studentService.createStudent(student , dptName);
        return ResponseEntity.ok("DONE");
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Student > getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<String> updateStudent(@RequestBody Student student, @RequestParam Long id){
        studentService.updateStudent( student ,id);
        return  ResponseEntity.ok("DONE");
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);
        return  ResponseEntity.ok("DONE");
    }

    @GetMapping
    public  ResponseEntity<List<Student>> getAllStudent( ){
        List<Student> student = studentService.getAllStudent( );
        return ResponseEntity.ok(student);
    }



}
