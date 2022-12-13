package com.sity.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity(name = "Publisher")
public class Publisher {

    @Id
    @Column(name = "publisherId")
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "publisher")
    @JsonIgnoreProperties("publisher")
    private Set<Book> book;

    public Publisher() {
    }

    public Publisher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Publisher(Integer id, String name, Set<Book> book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
