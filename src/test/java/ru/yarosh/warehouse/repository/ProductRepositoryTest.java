package ru.yarosh.warehouse.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.yarosh.warehouse.model.Product;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testCRUDOperations() {
        Product product = new Product();
        product.setName("Hat");
        product.setArticle("E1337");
        product.setDescription("elite item");
        product.setCategory("elite category");
        product.setPrice(2288.0);
        product.setQuantity(1);
        product.setLastQuantityChange(LocalDateTime.now());
        product.setCreationDate(LocalDateTime.now());
        productRepository.save(product);

        Optional<Product> savedProduct = productRepository.findById(product.getId());
        assertTrue(savedProduct.isPresent());
        assertEquals("Hat", savedProduct.get().getName());

        savedProduct.get().setName("Cap");
        productRepository.save(savedProduct.get());
        Optional<Product> updatedProduct = productRepository.findById(product.getId());
        assertTrue(updatedProduct.isPresent());
        assertEquals("Cap", updatedProduct.get().getName());

        productRepository.delete(updatedProduct.get());
        Optional<Product> deletedProduct = productRepository.findById(product.getId());
        assertTrue(deletedProduct.isEmpty());
    }

}
