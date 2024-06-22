package com.jan.model.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "maiden_name")
    private String maidenName;

    private int age;

    private String gender;

    private String email;

    private String phone;

    private String username;

    private String password;

    @Column(name = "birth_date")
    private String birthDate;

    private String image;

    @Column(name = "blood_group")
    private String bloodGroup;

    private double height;

    private double weight;

    @Column(name = "eye_color")
    private String eyeColor;

    @Embedded
    private Hair hair;

    private String ip;

    @Embedded
    private Address address;

    @Column(name = "mac_address")
    private String macAddress;

    private String university;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private BankDetails bank;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    private String ein;

    private String ssn;

    @Column(name = "user_agent")
    private String userAgent;

    @Embedded
    private Crypto crypto;

    private String role;
}