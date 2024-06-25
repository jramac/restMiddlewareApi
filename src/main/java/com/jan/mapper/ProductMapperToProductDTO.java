package com.jan.mapper;

import com.jan.model.dto.ProductSummaryDTO;
import com.jan.model.product.Product;

public class ProductMapperToProductDTO {
    public static ProductSummaryDTO toProductSummaryDTO(Product product) {
        String shortDescription = product.getDescription().length() > 100
                ? product.getDescription().substring(0, 100) + "..."
                : product.getDescription();

        return new ProductSummaryDTO(
                product.getTitle(),
                product.getPrice(),
                product.getImages().isEmpty() ? null : product.getImages().get(0), // Assuming the first image is the main image
                shortDescription
        );
    }
}
