package ru.yarosh.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data

public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String article;
    private String description;
    private String category;
    private double price;
    private int quantity;
    private LocalDateTime lastQuantityChange;
    private LocalDateTime creationDate;

}
