package com.sity.service;

import com.sity.model.Book;
import com.sity.model.request.BookRequest;
import com.sity.model.response.BookResponse;

import java.util.List;


public interface BookService {

    //Read Operation
    public List<Book> fetchListOfBooks();

    public Book fetchBookById(Integer bookId);

    public List<Book> searchBookByTitle(String titleKeyword);

    //Save Operations
    public Book addBook(BookRequest bookRequest);

    //Update Operations
    public Book updateBook(Book book, Integer bookId);

    //Delete Operations
    public void deleteBookById(Integer bookId);
}
