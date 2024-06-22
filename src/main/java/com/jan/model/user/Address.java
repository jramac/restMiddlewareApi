package com.jan.model.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Address {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;

    @Embedded
    private Coordinates coordinates;

    private String country;
}