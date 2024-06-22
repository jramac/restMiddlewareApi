package com.jan.model.user;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name = "bank_details")
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_expire")
    private String cardExpire;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    private String currency;

    private String iban;
}