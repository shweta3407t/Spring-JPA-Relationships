package com.example.SpringJPARelationships.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_id")
    private Long id;

    @Column(name = "std_name" , length = 200 , nullable = false)
    private String name;

    @Column(name = "std_age" , length = 200 , nullable = false)
    private  int age;

    @Column(name = "std_email" , length = 200 , nullable = false , unique = true)
    private  String email;




    @Embedded
    private  Address address;


    @Column(precision = 5 , scale = 2)
    private BigDecimal percentage;


    private LocalDate dateOfBirth;

    private LocalDate createdAt;



    @Lob
    private String studentDescription;

    @Transient
    private  String displayName;

    @Convert(converter = BooleanToStringConverter.class)
    private  Boolean isMonitor;




}
