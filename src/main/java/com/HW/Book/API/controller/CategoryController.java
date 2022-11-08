package com.HW.Book.API.controller;

import com.HW.Book.API.model.Category;
import com.HW.Book.API.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/category")
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }


    @GetMapping("/category/id")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId) {
        categoryService.verifyCategory(categoryId);
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PutMapping("/category/id")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        categoryService.verifyCategory(categoryId);
        categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/category/id")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        categoryService.verifyCategory(categoryId);
        return categoryService.deleteCategory(categoryId);
    }
}
