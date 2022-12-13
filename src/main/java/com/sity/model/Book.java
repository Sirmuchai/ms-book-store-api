package com.sity.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    @Column(name="bookId")
    private Integer id;
    private String title;
    private String category;
    private Long isbn;
    private boolean isPublished;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_publisher",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    @JsonIgnoreProperties("book")
    private Set<Publisher> publisher;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonIgnoreProperties("book")
    private Set<Author> author;
   //No args constructor
    public Book(){
    }
    //Class constrcutor with variables


    public Book(Integer id, String title, String category, Long isbn, boolean isPublished, Set<Publisher> publisher, Set<Author> author) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.isbn = isbn;
        this.isPublished = isPublished;
        this.publisher = publisher;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Set<Publisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(Set<Publisher> publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", isbn=" + isbn +
                ", isPublished=" + isPublished +
                ", publisher=" + publisher +
                ", author=" + author +
                '}';
    }
}
