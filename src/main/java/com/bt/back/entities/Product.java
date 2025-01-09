package com.bt.back.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
public class Product {
    @Id
    private String id;
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @Positive(message = "El precio debe ser mayor que 0")
    private double price;
    private String description;
    private int stock;
    private String category;
}
