package com.jan.model.product;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Column(name = "discount_percentage")
    private double discountPercentage;
    private double rating;
    private int stock;

    @ElementCollection
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tag")
    private List<String> tags;
    @Column(name = "brand")
    private String brand;
    private String sku;
    private double weight;

    @Embedded
    private Dimensions dimensions;
    @Column(name = "warranty_information")
    private String warrantyInformation;
    @Column(name = "shipping_information")
    private String shippingInformation;
    @Column(name = "availability_status")
    private String availabilityStatus;


    @Column(name = "return_policy")
    private String returnPolicy;
    @Column(name = "minimum_order_quantity")
    private int minimumOrderQuantity;

    @Embedded
    private Meta meta;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image")
    private List<String> images;

    @ElementCollection
    @CollectionTable(name = "product_reviews", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "review")
    private List<Review> reviews;

    private String thumbnail;
}
