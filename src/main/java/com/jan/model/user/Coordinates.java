package com.jan.model.user;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Coordinates {
    private double lat;
    private double lng;
}