package org.example;

import org.example.helpers.AppHelperProductDataInput;
import org.example.services.ProductService;
import org.example.services.UserService;
import org.example.tools.Input;
import org.example.tools.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        UserService userService = new UserService();
        Input input = new ConsoleInput();

        App app = new App(input, productService, userService);
        app.run();
    }
}
