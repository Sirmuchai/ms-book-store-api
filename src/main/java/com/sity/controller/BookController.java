package com.sity.controller;

import com.sity.model.Book;
import com.sity.model.request.BookRequest;
import com.sity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Annotation
@RestController
@RequestMapping("api/v1")
public class BookController {

    @Autowired private BookService bookService;

    @GetMapping("/hey")
    public ResponseEntity<String> sayhey(){
        return ResponseEntity.ok("This is secure");
    }




    @GetMapping("/books")
    public List<Book> fetchListOfBooks(){
        return bookService.fetchListOfBooks();
    }

    @GetMapping("/book/{id}")
    public Book fetchBookById(@PathVariable("id") Integer bookId){
        return bookService.fetchBookById(bookId);
    }

    @GetMapping("/books/{titleKeyword}")
    public List<Book> searchBookById(@PathVariable("titleKeyword") String keyword){
        return bookService.searchBookByTitle(keyword);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody BookRequest bookRequest){
        return bookService.addBook(bookRequest);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBookById(@PathVariable("id") Integer bookId){
        bookService.deleteBookById(bookId);
    }


}
