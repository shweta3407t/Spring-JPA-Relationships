package com.example.SpringJPARelationships.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Department {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name =  "dept_id" )
    private Long id;

    @Column(name =  "dept_name" , unique = true , nullable = false)
    private  String name;

    @OneToMany(mappedBy = "department")
    private  List<Student> students ;
}
