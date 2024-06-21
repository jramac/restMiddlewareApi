package com.jan.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jan.model.category.Category;
import com.jan.model.product.Product;
import com.jan.model.product.ProductResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class WebApiDataCollectorCategories implements DataCollector<List<Category>> {

    private String apiUrl;

    private final RestTemplate restTemplate;

    public WebApiDataCollectorCategories(RestTemplate restTemplate, String apiUrl) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Category> getData() {
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        Gson gson = new Gson();
        Type categoryListType = new TypeToken<List<Category>>(){}.getType();
        List<Category> categories = gson.fromJson(jsonResponse, categoryListType);
        return categories;
    }
}

