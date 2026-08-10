package com.example.SpringJPARelationships.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "dept_id" )
    private Long id;

    @Column(name =  "dept_name", nullable = false , unique = true)
    private  String name;
}
