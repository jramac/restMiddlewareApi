package com.jan.model.product;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.jan.model.product.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String category;
    private double price;
    private double discountPercentage;
    private double rating;
    private int stock;

    @ElementCollection
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tag")
    private List<String> tags;

    private String brand;
    private String sku;
    private double weight;

    @Embedded
    private Dimensions dimensions;

    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;



    private String returnPolicy;
    private int minimumOrderQuantity;

    @Embedded
    private Meta meta;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image")
    private List<String> images;

    private String thumbnail;
}