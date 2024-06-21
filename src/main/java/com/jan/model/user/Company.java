package com.jan.model.user;
import lombok.Data;

@Data
public class Company {
    private String department;
    private String name;
    private String title;
    private Address address;
}