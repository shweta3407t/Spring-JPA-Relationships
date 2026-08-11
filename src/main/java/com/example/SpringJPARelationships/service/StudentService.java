package com.example.SpringJPARelationships.service;

import com.example.SpringJPARelationships.model.Department;
import com.example.SpringJPARelationships.model.Student;
import com.example.SpringJPARelationships.repository.DepartmentRepository;
import com.example.SpringJPARelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    public  StudentService(StudentRepository studentRepository , DepartmentRepository departmentRepository)
    {
        this.studentRepository=studentRepository;
        this.departmentRepository=departmentRepository;
    }

//for manyToOne
    //create Student with existing department
    @Transactional
    public  void  createStudent(Student student  , Long deptId){
        Department department=departmentRepository.getDepartmentById(deptId);
//                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + deptId));

        student.setDepartment(department);
        department.getStudents().add(student);//for oneToMany

        studentRepository.createStudent(student);
    }



    //    //create student and department at a time
    @Transactional
    public  void  createStudentWithDepartment(Student student  ,   String deptName){
         Department department =new Department();
         department.setName(deptName);

         student.setDepartment(department);//for oneToMany
        student.setDepartment(department);


        departmentRepository.createDepartment(department);
         studentRepository.createStudent(student);
    }






    @Transactional
    public  Student  getStudentById(Long id){
        return  studentRepository.getStudentById(id);
    }



    @Transactional
    public  void  updateStudent(Student studentRequest , Long id){
        Student student= studentRepository.getStudentById(id);

        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        student.setDepartment(studentRequest.getDepartment());
    }

////postman request for update method
//    {
//        "name" : "ankita" ,
//            "age" : 22 ,
//            "email" : "ankita@gmail.com",
//            "department" : {
//        "name" : "sales"
//    }
//
//    }

    @Transactional
    public  void  deleteStudent(Long id){
        Student student=studentRepository.getStudentById(id);
        studentRepository.deleteStudent(student);
    }

    @Transactional
    public List<Student > getAllStudent( ){
        return  studentRepository.getAllStudent( );
    }

}
