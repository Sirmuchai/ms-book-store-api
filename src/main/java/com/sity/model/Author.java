package com.sity.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sity.model.Book;

@Entity(name = "author")
@PrimaryKeyJoinColumn(name = "personId")
public class Author extends Person{

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "author")
    @JsonIgnoreProperties("author")
    private Set<Book> book;


    public Author(Long id, String firstName, String lastName, String email, Set<Book> book) {
        super(id, firstName, lastName, email);
        this.book = book;
    }

    public Author() {
    }


    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

}
