package com.HW.Book.API.controller;

import com.HW.Book.API.model.Book;
import com.HW.Book.API.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Iterable<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books/{categoryId}/books")
    public void createBook(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Book book){
        bookService.createBook(book, categoryId);
    }


    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBookById(@PathVariable Long categoryId, @RequestBody Book book) {
        bookService.updateBookById(book, categoryId);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/books/{categoryId}/books")
    public Iterable<Book> getByCategoryId(@PathVariable Long categoryId) {
        return bookService.getByCategoryId(categoryId);
    }

    @GetMapping("/searchBooks")
    public Iterable<Book> searchBooks(@RequestParam("query") String query) {
        return bookService.findBookByName(query);
    }
}
