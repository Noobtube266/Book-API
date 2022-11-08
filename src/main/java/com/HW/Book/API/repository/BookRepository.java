package com.HW.Book.API.repository;

import com.HW.Book.API.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

    Iterable<Book> findByCategoryId(long categoryId);

    @Query
    Iterable<Book>  findBooksByName(String name);
}
