package com.jan.controller;

import com.jan.mapper.ProductMapperToProductDTO;
import com.jan.model.dto.ProductSummaryDTO;
import com.jan.model.product.Product;
import com.jan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    //  /products
    @Cacheable("productsSummary")
    @GetMapping
    public List<ProductSummaryDTO> getAllProductsSummary() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapperToProductDTO::toProductSummaryDTO)
                .collect(Collectors.toList());
    }
    //  /details
    @Cacheable("products")
    @GetMapping("/details")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    //  /products/targetId
    @Cacheable("productId")
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
    //  /category?category=targetCategory
    @Cacheable("category")
    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productRepository.findByCategory(category);
    }
    //  /price?price=targetPrice
    @Cacheable("price")
    @GetMapping("/price")
    public List<Product> getProductsByPrice(@RequestParam Double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }
    // /name?name=targetName
    @Cacheable("name")
    @GetMapping("/name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productRepository.findByTitleContainingIgnoreCase(name);
    }
}
