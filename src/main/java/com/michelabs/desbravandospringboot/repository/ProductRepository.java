package com.michelabs.desbravandospringboot.repository;

import com.michelabs.desbravandospringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
