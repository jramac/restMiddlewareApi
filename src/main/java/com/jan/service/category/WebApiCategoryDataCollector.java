package com.jan.service.category;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jan.model.category.Category;
import com.jan.service.AbstractDataCollector;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

public class WebApiCategoryDataCollector extends AbstractDataCollector<Category> {

    private String apiUrl;
    private final RestTemplate restTemplate = new RestTemplate();
    public WebApiCategoryDataCollector(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    public List<Category> getData() {
        return parseData();
    }
    @Override
    public List<Category> parseData() {
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        Gson gson = new Gson();
        Type categoryListType = new TypeToken<List<Category>>(){}.getType();
        List<Category> categories = gson.fromJson(jsonResponse, categoryListType);
        return categories;
    }
}

