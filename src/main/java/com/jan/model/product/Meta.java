package com.jan.model.product;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Embeddable
public class Meta {
    private Date createdAt;
    private Date updatedAt;
    private String barcode;
    private String qrCode;
}