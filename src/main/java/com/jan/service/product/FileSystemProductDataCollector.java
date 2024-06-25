package com.jan.service.product;

import com.jan.model.product.Product;
import com.jan.service.AbstractDataCollector;

import java.util.List;

public class FileSystemProductDataCollector extends AbstractDataCollector<Product> {
    private String url;

    public FileSystemProductDataCollector(String url){
        this.url = url;
    }
    // TODO: 24.06.2024. implementirati parser
    @Override
    public List<Product> getData() {
        return null;
    }

    @Override
    public List<Product> parseData() {
        return null;
    }
}
