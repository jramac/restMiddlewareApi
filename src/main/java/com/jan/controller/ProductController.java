package com.jan.controller;

import com.jan.model.product.Product;
import com.jan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productRepository.findByCategory(category);
    }

    @GetMapping("/price")
    public List<Product> getProductsByPrice(@RequestParam Double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }

    @GetMapping("/name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productRepository.findByTitleContainingIgnoreCase(name);
    }
}
