package com.sity.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity(name = "Publisher")
@Data // bundles all Constructors, Setters and Getters, toString and equalTo and Hashcode
public class Publisher {

    @Id
    @Column(name = "publisherId")
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "publisher")
    @JsonIgnoreProperties("publisher")
    private Set<Book> book;


}
