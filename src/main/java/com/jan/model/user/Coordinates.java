package com.jan.model.user;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Coordinates {
    private double lat;
    private double lng;
}