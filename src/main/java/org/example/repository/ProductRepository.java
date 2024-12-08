package org.example.repository;

import org.example.models.Product;

import java.util.List;

public interface ProductRepository {
    void saveProduct(Product product);

    List<Product> loadProducts();
}