package com.jan.model.user;
import lombok.Data;

@Data
public class BankDetails {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
}