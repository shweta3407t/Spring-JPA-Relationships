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



    //create Student with existing department
    @PostMapping
    public ResponseEntity<String > createStudent(@RequestBody Student student , @RequestParam Long deptId ){
        studentService.createStudent(student , deptId);
        return ResponseEntity.ok("DONE");
    }


//    create student and department at a time
    @PostMapping("/{deptName}")
    public ResponseEntity<String > createStudentWithDepartment(@RequestBody Student student , @PathVariable String deptName){
        studentService.createStudentWithDepartment(student , deptName);
        return ResponseEntity.ok("DONE");
    }



    //get
    @GetMapping("/{id}")
    public  ResponseEntity<Student > getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }


    //update
    @PutMapping("/{id}")
    public  ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent( student ,id);
        return  ResponseEntity.ok("DONE");
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return  ResponseEntity.ok("DONE");
    }

    @GetMapping
    public  ResponseEntity<List<Student>> getAllStudent( ){
        List<Student> student = studentService.getAllStudent( );
        return ResponseEntity.ok(student);
    }



}
