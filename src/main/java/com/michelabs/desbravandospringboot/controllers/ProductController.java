package com.michelabs.desbravandospringboot.controllers;

import com.michelabs.desbravandospringboot.entities.Category;
import com.michelabs.desbravandospringboot.entities.Product;
import com.michelabs.desbravandospringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> listProducts = productService.findAllProducts();
        return ResponseEntity.ok().body(listProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product findProductById = productService.findProductById(id);
        return ResponseEntity.ok().body(findProductById);
    }

}
