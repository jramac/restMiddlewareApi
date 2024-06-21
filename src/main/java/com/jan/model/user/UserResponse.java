package com.jan.model.user;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private List<User> users;
    private int total;
    private int skip;
    private int limit;
}