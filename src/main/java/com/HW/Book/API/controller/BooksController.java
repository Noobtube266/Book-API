package com.HW.Book.API.controller;

import com.HW.Book.API.model.Book;
import com.HW.Book.API.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BooksController {

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return BookService.getAllBooks();
    }

    @PostMapping("/books/{categoryId}/books")
    public ResponseEntity<?> createBook(@PathVariable(value = "CategoryId") Long categoryId @Valid @RequestBody Book book) {
        return BookService.createBook(categoryId, book);
    }


    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBook(@PathVariable Long bookId) {
        return service.getBookById(bookId);
    }

    @PutMapping("/books/{categoryId}/books")
    public ResponseEntity<?> updatePoll(@RequestBody Book book, @PathVariable Long bookId) {
        return service.updateBook(book, bookId);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        return service.deleteBook(bookId);
    }

    @GetMapping("/books/{categoryId/books")
    public ResponseEntity<?> getByCategory(@PathVariable )

}
