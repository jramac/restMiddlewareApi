package com.jan.model.category;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String slug;
    private String name;
    private String url;
}