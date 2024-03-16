package ru.yarosh.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Модель товара.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    /**
     * Наименование товара.
     */
    @NotBlank(message = "Name is required")
    @NotNull
    private String name;

    /**
     * Артикул товара.
     */
    @NotBlank(message = "Article is required")
    @NotNull
    private String article;

    /**
     * Описание товара.
     */
    @NotBlank(message = "Description is required")
    @NotNull
    private String description;

    /**
     * Категория товара.
     */
    @NotBlank(message = "Category is required")
    @NotNull
    private String category;

    /**
     * Цена товара.
     */
    @NotBlank(message = "Price is required")
    @NotNull
    private double price;

    /**
     * Количество товара.
     */
    @NotBlank(message = "Quantity is required")
    @NotNull
    private int quantity;

    /**
     * Дата и время последнего изменения количества товара.
     */
    @NotBlank(message = "LastQuantityChange is required")
    @NotNull
    private LocalDateTime lastQuantityChange;

    /**
     * Дата и время создания товара.
     */
    @NotBlank(message = "CreationDate is required")
    @NotNull
    private LocalDateTime creationDate;

}
