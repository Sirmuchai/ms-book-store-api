package com.sity.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sity.model.Book;
import lombok.Data;

@Entity(name = "author")
@Data
@PrimaryKeyJoinColumn(name = "personId")
public class Author extends Person{

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "author")
    @JsonIgnoreProperties("author")
    private Set<Book> book;

}
