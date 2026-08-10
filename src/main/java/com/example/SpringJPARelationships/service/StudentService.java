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


    @Transactional
    public  void  createStudent(Student student  , String deptName){
        Department department =new Department();
        department.setName(deptName);
        departmentRepository.createDepartment(department);

        studentRepository.createStudent(student );

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
    }

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
