package com.example.SpringJPARelationships.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(unique = true)
    private  Long id;

    private String bio ;

    @OneToOne
    @JoinColumn(name = "user_id"  )
    private  Student student;

}
