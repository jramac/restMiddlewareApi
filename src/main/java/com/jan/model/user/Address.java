package com.jan.model.user;

import lombok.Data;

@Data
public class Address {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;
    private Coordinates coordinates;
    private String country;
}