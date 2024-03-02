package ru.yarosh.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yarosh.warehouse.model.Product;
import ru.yarosh.warehouse.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

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

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
