package com.jan.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jan.model.product.Product;
import com.jan.model.product.ProductResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class WebApiDataCollector implements DataCollector {

    private String apiUrl;

    private final RestTemplate restTemplate;

    public WebApiDataCollector(RestTemplate restTemplate,String apiUrl) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductResponse getData() {
        // Make HTTP GET request to API and return JSON response
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<Product>>(){}.getType();
        ProductResponse productResponse = gson.fromJson(jsonResponse, ProductResponse.class);
        return productResponse;
    }
}

