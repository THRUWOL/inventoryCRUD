package ru.yarosh.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yarosh.warehouse.model.Product;

import java.util.UUID;

/**
 * Репозиторий для работы с товарами.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
