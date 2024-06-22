package com.jan.service;

import com.google.gson.Gson;
import com.jan.model.user.User;
import com.jan.model.user.UserResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WebApiDataCollectorUsers implements DataCollector<List<User>> {

    private String apiUrl;

    private final RestTemplate restTemplate;

    public WebApiDataCollectorUsers(RestTemplate restTemplate, String apiUrl) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getData() {
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(jsonResponse, UserResponse.class);
        return userResponse.getUsers();
    }
}

