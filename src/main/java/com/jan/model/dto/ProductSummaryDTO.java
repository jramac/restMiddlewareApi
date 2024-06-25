package com.jan.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductSummaryDTO {
    private String name;
    private double price;
    private String image;
    private String shortDescription;
    public ProductSummaryDTO(String name, double price, String image, String shortDescription) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.shortDescription = shortDescription;
    }
}
