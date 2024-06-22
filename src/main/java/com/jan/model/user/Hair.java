package com.jan.model.user;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Hair {
    private String color;
    private String type;
}