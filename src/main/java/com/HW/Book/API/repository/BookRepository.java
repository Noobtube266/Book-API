package com.HW.Book.API.repository;

import com.HW.Book.API.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

    Iterable<Book> getByCategoryId(Long categoryId);

    @Query(value = "Select * From book WHERE name LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    Iterable<Book>  searchBooks(String query);
}
