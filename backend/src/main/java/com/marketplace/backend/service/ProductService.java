package com.marketplace.backend.service;

import com.marketplace.backend.model.Product;
import com.marketplace.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.marketplace.backend.dto.ProductDTO;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product createProduct(ProductDTO dto) {

    Product product = new Product();

    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setStock(dto.getStock());

    return repository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());

        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}