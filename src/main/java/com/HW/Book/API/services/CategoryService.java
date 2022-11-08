package com.HW.Book.API.services;

import com.HW.Book.API.repository.BookRepository;
import com.HW.Book.API.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;


}
