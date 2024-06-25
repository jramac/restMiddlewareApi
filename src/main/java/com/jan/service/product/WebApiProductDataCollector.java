package com.jan.service.product;

import com.google.gson.Gson;
import com.jan.model.product.Product;
import com.jan.model.product.ProductResponse;
import com.jan.service.AbstractDataCollector;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WebApiProductDataCollector extends AbstractDataCollector<Product> {
    private String apiUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public WebApiProductDataCollector(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    @Override
    public List<Product> parseData(){
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        Gson gson = new Gson();
        ProductResponse productResponse = gson.fromJson(jsonResponse, ProductResponse.class);
        List<Product> products = productResponse.getProducts();
        return products;
    }
    @Override
    public List<Product> getData() {
        return parseData();
    }

}
