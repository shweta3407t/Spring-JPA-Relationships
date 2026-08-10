package com.example.SpringJPARelationships.repository;

import com.example.SpringJPARelationships.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public  void  createDepartment(Department department){
        entityManager.persist(department);
    }

    public  Department getDepartmentById(long id){
        return  entityManager.find(Department.class , id);
    }


    public List<Department> getAllDepartment(){
        return  entityManager.createQuery("FROM Department" , Department.class).getResultList();
    }


    public void  DeleteDepartment(Department department){
        entityManager.remove(department);
    }

}
