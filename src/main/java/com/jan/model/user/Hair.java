package com.jan.model.user;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Hair {
    @Column(name = "hair_color")
    private String color;
    @Column(name = "hair_type")
    private String type;
}