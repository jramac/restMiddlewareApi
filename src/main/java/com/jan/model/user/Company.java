package com.jan.model.user;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@Table(name = "companies")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String department;

    private String name;

    private String title;

    @Embedded
    private Address address;
}