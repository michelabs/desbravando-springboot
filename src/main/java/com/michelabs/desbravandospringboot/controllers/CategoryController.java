package com.michelabs.desbravandospringboot.controllers;

import com.michelabs.desbravandospringboot.entities.Category;
import com.michelabs.desbravandospringboot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> listCategories = categoryService.findAllCategories();
        return ResponseEntity.ok().body(listCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category findCategoryById = categoryService.findCategoryById(id);
        return ResponseEntity.ok().body(findCategoryById);
    }

}
