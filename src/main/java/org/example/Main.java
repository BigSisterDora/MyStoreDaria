package org.example;

import org.example.app.App;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.example.services.ProductService;
import org.example.services.UserService;
import org.example.storages.StorageProduct;
import org.example.storages.StorageUser;
import org.example.tools.Input;
import org.example.tools.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new StorageProduct();
        UserRepository userRepository = new StorageUser();
        ProductService productService = new ProductService(productRepository);
        UserService userService = new UserService(userRepository);
        Input input = new ConsoleInput();

        App app = new App(input, productService, userService);
        app.run();
    }
}
