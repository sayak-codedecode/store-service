package com.mystore.store_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @Size(max = 255, message = "Description can't be longer than 255 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private double price;

    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;
}
