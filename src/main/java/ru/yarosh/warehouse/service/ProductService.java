package ru.yarosh.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yarosh.warehouse.model.Product;
import ru.yarosh.warehouse.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для управления товарами.
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Создает новый товар.
     *
     * @param product информация о товаре, которую необходимо создать
     * @return созданный товар
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Получает список всех товаров.
     *
     * @return список всех товаров
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Получает товар по его идентификатору.
     *
     * @param id идентификатор товара
     * @return товар с указанным идентификатором, если он существует, иначе null
     */
    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Обновляет информацию о товаре.
     *
     * @param id             идентификатор товара, информацию о котором необходимо обновить
     * @param updatedProduct обновленная информация о товаре
     * @return обновленный товар, если товар существует, иначе null
     */
    public Product updateProduct(UUID id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct == null) {
            return null;
        }

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setArticle(updatedProduct.getArticle());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setId(updatedProduct.getId());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setCreationDate(updatedProduct.getCreationDate());
        existingProduct.setLastQuantityChange(updatedProduct.getLastQuantityChange());

        return productRepository.save(existingProduct);
    }

    /**
     * Удаляет товар по его идентификатору.
     *
     * @param id идентификатор товара, который необходимо удалить
     */
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
