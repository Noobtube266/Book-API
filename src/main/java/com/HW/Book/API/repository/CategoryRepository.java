package com.HW.Book.API.repository;

import com.HW.Book.API.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Book, Long> {
}
