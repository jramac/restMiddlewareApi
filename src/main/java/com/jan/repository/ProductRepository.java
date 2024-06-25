package com.jan.repository;

import com.jan.model.product.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //@Cacheable("products")
    List<Product> findByCategory(String category);
    //@Cacheable("products")
    List<Product> findByPriceLessThanEqual(Double price);
    //@Cacheable("products")
    List<Product> findByTitleContainingIgnoreCase(String title);
}
