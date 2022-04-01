package com.michelabs.desbravandospringboot.repository;

import com.michelabs.desbravandospringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
