package org.example.helpers;

import org.example.models.Product;
import org.example.tools.Input;

public class AppHelperProductDataInput {
    public Product createProduct(Input input) {
        int id = input.readInt("Enter product ID: ");
        String name = input.readString("Enter product name: ");
        double price = input.readDouble("Enter product price: ");
        int quantity = input.readInt("Enter product quantity: ");
        return new Product(id, name, price, quantity);
    }
}