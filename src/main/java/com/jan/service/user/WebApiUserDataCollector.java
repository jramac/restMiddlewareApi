package com.jan.service.user;

import com.google.gson.Gson;
import com.jan.model.user.User;
import com.jan.model.user.UserResponse;
import com.jan.service.AbstractDataCollector;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WebApiUserDataCollector extends AbstractDataCollector<User> {
    private final RestTemplate restTemplate = new RestTemplate();
    private String apiUrl;

    public WebApiUserDataCollector(String apiUrl){
        this.apiUrl=apiUrl;
    }
    @Override
    public List<User> getData() {
        return parseData();
    }

    @Override
    public List<User> parseData() {
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(jsonResponse, UserResponse.class);
        return userResponse.getUsers();
    }
}
