package ru.yarosh.warehouse.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.yarosh.warehouse.model.Product;
import ru.yarosh.warehouse.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        Product product = new Product(UUID.randomUUID(), "Product", "12345", "Description 1", "Category 1", 10.0, 100, LocalDateTime.now(), LocalDateTime.now());
        when(productRepository.save(product)).thenReturn(product);

        Product createdProduct = productService.createProduct(product);

        assertNotNull(createdProduct);
        assertEquals("Product", createdProduct.getName());

    }

    @Test
    void getAllProducts() {
        Product product1 = new Product(UUID.randomUUID(), "Product 1", "12345", "Description 1", "Category 1", 10.0, 100, LocalDateTime.now(), LocalDateTime.now());
        Product product2 = new Product(UUID.randomUUID(), "Product 2", "67890", "Description 2", "Category 2", 20.0, 200, LocalDateTime.now(), LocalDateTime.now());
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("Product 1", products.get(0).getName());
        assertEquals("Product 2", products.get(1).getName());
    }

    @Test
    void getProductById() {
        UUID productId = UUID.randomUUID();
        Product product = new Product(productId, "Product", "12345", "Description", "Category", 10.0, 100, LocalDateTime.now(), LocalDateTime.now());
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Product retrievedProduct = productService.getProductById(productId);

        assertEquals("Product", retrievedProduct.getName());
    }

    @Test
    void updateProduct() {
        UUID productId = UUID.randomUUID();
        Product existingProduct = new Product(productId, "Product", "12345", "Description 1", "Category 1", 10.0, 100, LocalDateTime.now(), LocalDateTime.now());
        Product updatedProduct = new Product(productId, "Updated Product", "54321", "Updated Description", "Updated Category", 20.0, 200, LocalDateTime.now(), LocalDateTime.now());
        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);

        Product updated = productService.updateProduct(productId, updatedProduct);

        assertNotNull(updated);
        assertEquals("Updated Product", updated.getName());
        assertEquals("Updated Description", updated.getDescription());
    }

    @Test
    void deleteProduct() {
        UUID productId = UUID.randomUUID();
        Product product = new Product(productId, "Product", "12345", "Description 1", "Category 1", 10.0, 100, LocalDateTime.now(), LocalDateTime.now());

        productService.deleteProduct(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }
}
