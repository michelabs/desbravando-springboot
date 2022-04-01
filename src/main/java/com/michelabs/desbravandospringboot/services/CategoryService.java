package com.michelabs.desbravandospringboot.services;

import com.michelabs.desbravandospringboot.entities.Category;
import com.michelabs.desbravandospringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;


    public List<Category> findAllCategories(){
       return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        Optional<Category> findCategoryById = categoryRepository.findById(id);
        return findCategoryById.get();
    }
}
