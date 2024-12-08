package org.example.services;

import org.example.models.Product;
import org.example.repository.ProductRepository;
import org.example.storages.StorageProduct;

public class ProductService {
    private ProductRepository productRepository = new StorageProduct();

    public void addProduct(AppHelperProductDataInput appHelperProductDataInput) {
        Product product = appHelperProductDataInput.createProduct();
        productRepository.saveProduct(product);
    }

    public void listProducts() {
        for (Product product : productRepository.loadProducts()) {
            System.out.println(product);
        }
    }
}