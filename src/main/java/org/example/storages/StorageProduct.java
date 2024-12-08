package org.example.storages;

import org.example.models.Product;
import org.example.repository.ProductRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageProduct implements ProductRepository {
    private List<Product> products = new ArrayList<>();
    private String fileName = "products.dat";

    @Override
    public void saveProduct(Product product) {
        products.add(product);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(products);
        } catch (IOException e) {
            System.out.println("Error saving product: " + e.getMessage());
        }
    }

    @Override
    public List<Product> loadProducts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            products = (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
        return products;
    }
}
