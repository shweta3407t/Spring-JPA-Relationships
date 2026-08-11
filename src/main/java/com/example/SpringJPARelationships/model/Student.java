package com.example.SpringJPARelationships.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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


    //relationships

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "dept_id" , nullable = false )
    private  Department department;








//    //map Collection
//
//    @ElementCollection
//    @CollectionTable(name = "std_address" , joinColumns = @JoinColumn(name = "std_id"))
//    private List<Address> addresses;
//
//    @ElementCollection
//    @CollectionTable(name = "std_skills" , joinColumns = @JoinColumn(name = "std_id"))
//    private List<String> skills;


//    @Embedded
//    private  Address address;
//
//
//    @Column(precision = 5 , scale = 2)
//    private BigDecimal percentage;
//
//
//    private LocalDate dateOfBirth;
//
//    private LocalDate createdAt;
//
//
//
//    @Lob
//    private String studentDescription;
//
//    @Transient
//    private  String displayName;
//
//    @Convert(converter = BooleanToStringConverter.class)
//    private  Boolean isMonitor;




}
