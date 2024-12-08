package org.example.helpers;

import org.example.models.Product;
import org.example.tools.Input;

public class AppHelperProductDataInput {
    public Product createProduct(Input input) {
        System.out.println("Добавление нового продукта:");
        String name = input.readString("Введите название продукта: ");
        double price = input.readDouble("Введите цену продукта: ");
        int quantity = input.readInt("Введите количество продукта: ");
        return new Product(name, price, quantity); // ID создается автоматически
    }
}
