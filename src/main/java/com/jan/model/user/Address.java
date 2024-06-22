package com.jan.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class Address {
    private String address;
    private String city;
    private String state;
    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "postal_code")
    private String postalCode;

    @Embedded
    private Coordinates coordinates;

    private String country;
}