package com.bt.back.services;

import com.bt.back.entities.Product;
import com.bt.back.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        log.info("Obteniendo todos los productos");
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        log.info("Obteniendo producto con ID: {}", id);
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Product saveProduct(Product product) {
        log.info("Guardando nuevo producto: {}", product.getName());
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        log.info("Actualizando producto con ID: {}", id);
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setStock(product.getStock());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(String id) {
        log.info("Eliminando producto con ID: {}", id);
        productRepository.deleteById(id);
    }
}
