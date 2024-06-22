package com.jan.model.user;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Crypto {
    private String coin;
    private String wallet;
    private String network;
}