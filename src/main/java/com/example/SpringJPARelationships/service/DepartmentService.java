package com.example.SpringJPARelationships.service;

import com.example.SpringJPARelationships.model.Department;
import com.example.SpringJPARelationships.model.Student;
import com.example.SpringJPARelationships.repository.DepartmentRepository;
import com.example.SpringJPARelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentRepository studentRepository;




    //create
    @Transactional
    public  void  createDepartment(Department department ){
        departmentRepository.createDepartment(department);
    }

    @Transactional
    public  void  createDepartmentWithStudent(Department department , Student studentRequest ){

         Student student=new Student();

         student.setName(studentRequest.getName());
         student.setAge(studentRequest.getAge());
         student.setEmail(studentRequest.getEmail());
         student.setDepartment(department);

         department.getStudents().add(student);

         studentRepository.createStudent(student);
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

