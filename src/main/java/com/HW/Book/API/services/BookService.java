package com.HW.Book.API.services;

import com.HW.Book.API.exception.ResourceNotFoundException;
import com.HW.Book.API.model.Book;
import com.HW.Book.API.repository.BookRepository;
import com.HW.Book.API.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@org.springframework.stereotype.Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createBook(Long categoryId, Book book){
        categoryRepository.findById(categoryId).map(category ->{
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public ResponseEntity<?> getBookById(Long bookId) {
        Book book = bookrepository.findById(bookId).orElse(null)
    }


    public void updateBookById(Long categoryId, Book book) {
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }

    public void deleteBookById(Long bookId){
        bookRepository.deleteById(bookId);
    }
    Iterable<Book> findByCategoryId(long categoryId){
        return bookRepository.findByCategoryId(categoryId);
    }
}
