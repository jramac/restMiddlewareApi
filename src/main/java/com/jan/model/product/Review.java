package com.jan.model.product;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Embeddable
public class Review {

    private double rating;
    private String comment;
    private Date date;
    @Column(name = "reviever_name")
    private String reviewerName;
    @Column(name = "reviever_email")
    private String reviewerEmail;

}