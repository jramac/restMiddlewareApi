package com.jan.model.product;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Dimensions {
    private double width;
    private double height;
    private double depth;
}