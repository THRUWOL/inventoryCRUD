package ru.yarosh.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Name is required")
    @NotNull
    private String name;

    @NotBlank(message = "Article is required")
    @NotNull
    private String article;

    @NotBlank(message = "Description is required")
    @NotNull
    private String description;

    @NotBlank(message = "Category is required")
    @NotNull
    private String category;

    @NotBlank(message = "Price is required")
    @NotNull
    private double price;

    @NotBlank(message = "Quantity is required")
    @NotNull
    private int quantity;

    @NotBlank(message = "LastQuantityChange is required")
    @NotNull
    private LocalDateTime lastQuantityChange;

    @NotBlank(message = "CreationDate is required")
    @NotNull
    private LocalDateTime creationDate;

}
