package org.example.storages;

import org.example.models.Product;
import org.example.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class StorageProduct implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> loadProducts() {
        return products;
    }
}
