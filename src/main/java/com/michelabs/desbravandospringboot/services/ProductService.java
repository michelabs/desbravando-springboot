package com.michelabs.desbravandospringboot.services;

import com.michelabs.desbravandospringboot.entities.Product;
import com.michelabs.desbravandospringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;


    public List<Product> findAllProducts(){
       return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        Optional<Product> findProductsById = productRepository.findById(id);
        return findProductsById.get();
    }
}
