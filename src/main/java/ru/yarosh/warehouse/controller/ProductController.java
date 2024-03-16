package ru.yarosh.warehouse.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yarosh.warehouse.model.Product;
import ru.yarosh.warehouse.service.ProductService;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления товарами.
 */
@RestController
@RequestMapping("/api/products")
@OpenAPIDefinition(info = @Info(title = "Управление товаром"))
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Создает новый товар.
     *
     * @param product информация о товаре, которую необходимо создать
     * @return созданный товар
     */
    @PostMapping
    @Tag(name = "Добавить товар")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    /**
     * Получает список всех товаров.
     *
     * @return список всех товаров
     */
    @GetMapping
    @Tag(name = "Получить товары")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Получает товар по его идентификатору.
     *
     * @param id идентификатор товара
     * @return товар с указанным идентификатором, если он существует, иначе возвращает статус 404 Not Found
     */
    @GetMapping("/{id}")
    @Tag(name = "Получить товар")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        Product product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    /**
     * Обновляет информацию о товаре.
     *
     * @param id             идентификатор товара, информацию о котором необходимо обновить
     * @param updatedProduct обновленная информация о товаре
     * @return обновленный товар, если товар существует, иначе возвращает статус 404 Not Found
     */
    @PutMapping("/{id}")
    @Tag(name = "Обновить информацию о товаре")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @Valid @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    /**
     * Удаляет товар по его идентификатору.
     *
     * @param id идентификатор товара, который необходимо удалить
     * @return статус 204 No Content
     */
    @DeleteMapping("/{id}")
    @Tag(name = "Удалить товар")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
