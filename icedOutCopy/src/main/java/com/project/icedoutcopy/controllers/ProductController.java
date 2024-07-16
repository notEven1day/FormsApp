package com.project.icedoutcopy.controllers;

import com.project.icedoutcopy.models.Product;
import com.project.icedoutcopy.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
