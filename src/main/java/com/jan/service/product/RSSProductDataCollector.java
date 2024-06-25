package com.jan.service.product;

import com.jan.model.product.Product;
import com.jan.service.AbstractDataCollector;

import java.util.List;

public class RSSProductDataCollector extends AbstractDataCollector<Product> {
    private List<Product> productList;
    private String url;

    public RSSProductDataCollector(String url){
        this.url = url;
    }
    // TODO: 24.06.2024. implementirati parser
    @Override
    public List<Product> parseData(){
        return null;
    }
    @Override
    public List<Product> getData() {
        return parseData();
    }
}
