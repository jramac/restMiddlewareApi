package com.jan.repository;

import com.jan.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
    List<Product> findByPriceLessThanEqual(Double price);
    List<Product> findByTitleContainingIgnoreCase(String title);
}
