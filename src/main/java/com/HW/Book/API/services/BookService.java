package com.HW.Book.API.services;

import com.HW.Book.API.model.Book;
import com.HW.Book.API.repository.BookRepository;
import com.HW.Book.API.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createBook(Book book, Long categoryId){
        categoryRepository.findById(categoryId).map(category ->{
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public ResponseEntity<?> getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    public void updateBookById(Book book, Long categoryId) {
        categoryRepository.findById(categoryId).map(category ->{
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }
    public void deleteBookById(Long bookId){
        bookRepository.deleteById(bookId);
    }
    public Iterable<Book> getByCategoryId(Long categoryId){
        return bookRepository.getByCategoryId(categoryId);
    }
    public Iterable<Book> findBookByName(String query){
        return bookRepository.searchBooks(query);
    }
}
