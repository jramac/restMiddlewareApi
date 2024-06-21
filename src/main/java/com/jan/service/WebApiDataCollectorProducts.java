package com.jan.service;

import com.google.gson.Gson;
import com.jan.model.product.ProductResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class WebApiDataCollectorProducts implements DataCollector<ProductResponse> {

    private String apiUrl;

    private final RestTemplate restTemplate;

    public WebApiDataCollectorProducts(RestTemplate restTemplate, String apiUrl) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductResponse getData() {
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        Gson gson = new Gson();
        ProductResponse productResponse = gson.fromJson(jsonResponse, ProductResponse.class);
        return productResponse;
    }
}

