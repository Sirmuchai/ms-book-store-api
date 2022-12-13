package com.sity.service.Impl;

import com.sity.exceptions.NotFoundException;
import com.sity.model.Book;
import com.sity.model.request.BookRequest;
import com.sity.model.response.BookResponse;
import com.sity.repository.AuthorRepository;
import com.sity.repository.BookRepository;
import com.sity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Annotation

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Read Operation

    @Override
    public List<Book> fetchListOfBooks(){
        return bookRepository.findAll();

    }

    @Override
    public Book fetchBookById(Integer bookId){
        return bookRepository.findById(bookId).orElseThrow(()-> new NotFoundException(String.format("Book with %d does not exist in our DB!", bookId)));
    }

    public List<Book> searchBookByTitle(String titleKeyword){
        return bookRepository.findByTitleContaining(titleKeyword);
    }

    public Book addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setCategory(bookRequest.category());
        book.setIsbn(bookRequest.isbn());
        book.setPublisher(bookRequest.publisher());
        book.setAuthor(bookRequest.author());
        book.setPublished(bookRequest.isPublished());
        return bookRepository.save(book);

    }

    @Override
    public Book updateBook(Book book, Integer bookId) {
        return null;
    }

    @Override
    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);

    }


}
