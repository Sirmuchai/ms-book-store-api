package com.sity.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Person")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;



}
