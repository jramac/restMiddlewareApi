package com.jan.model.product;

import lombok.Data;

import java.util.List;
@Data
public class ProductResponse {
    private List<Product> products;
    private int total;
    private int skip;
    private int limit;
}