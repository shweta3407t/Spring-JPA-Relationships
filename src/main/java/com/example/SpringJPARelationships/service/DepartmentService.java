package com.example.SpringJPARelationships.service;

import com.example.SpringJPARelationships.model.Department;
import com.example.SpringJPARelationships.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    public  DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }



    @Transactional
    public  void  createDepartment(Department department){
        departmentRepository.createDepartment(department);
    }


    @Transactional
    public  Department getDepartmentById(Long id){
        return  departmentRepository.getDepartmentById(id);
    }


    @Transactional
    public List<Department > getAllDepartment(){
        return  departmentRepository.getAllDepartment();
    }


    @Transactional
    public  void  updateDepartment(Department departmentRequest , Long id){
        Department department=getDepartmentById(id);

        department.setName(departmentRequest.getName());

    }

    @Transactional
    public  void  deleteDepartment(Long id){
        Department department=getDepartmentById(id);

        departmentRepository.DeleteDepartment(department);
    }
}

