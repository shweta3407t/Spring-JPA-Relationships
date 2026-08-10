package com.example.SpringJPARelationships.repository;

import com.example.SpringJPARelationships.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public StudentRepository(EntityManager e) {
        this.entityManager = e;
    }





    //create
    public void createStudent(Student student) {

        entityManager.persist(student);
    }

    //get
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }


    //delete
    public List<Student> getAllStudent() {
        return entityManager.createQuery("FROM Student" , Student.class).getResultList();
    }

}
