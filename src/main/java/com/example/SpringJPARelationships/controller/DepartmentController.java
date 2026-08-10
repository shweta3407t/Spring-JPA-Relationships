package com.example.SpringJPARelationships.controller;

import com.example.SpringJPARelationships.model.Department;
import com.example.SpringJPARelationships.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
    private DepartmentService departmentService;

    public  DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }


    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);

        return  ResponseEntity.ok("DONE");
    }



    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@RequestParam Long id){

         Department department=departmentService.getDepartmentById(id);

        return  ResponseEntity.ok(department);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment( ){
        List<Department> departmentList = departmentService.getAllDepartment( );

        return  ResponseEntity.ok(departmentList);
    }




    @PutMapping ("/{id}")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department , @PathVariable Long id){
          departmentService.updateDepartment( department , id);

        return  ResponseEntity.ok("DONE");

    }




    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
          departmentService.deleteDepartment( id);

        return  ResponseEntity.ok("DONE");

    }


}
