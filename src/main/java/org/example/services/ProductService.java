package org.example.services;

import org.example.models.Product;
import org.example.repository.ProductRepository;
import org.example.tools.Input;
import org.example.models.User;

import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;
    private int productIdCounter = 1;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Input input) {
        String name = input.readString("Введите название продукта: ");
        double price = input.readDouble("Введите цену продукта: ");
        int quantity = input.readInt("Введите количество продукта: ");
        return new Product(productIdCounter++, name, price, quantity);
    }

    public void addProduct(Product product) {
        productRepository.saveProduct(product);
        System.out.println("Продукт добавлен: " + product);
    }

    public void listProducts() {
        System.out.println("Список продуктов:");
        for (Product product : productRepository.loadProducts()) {
            System.out.println(product);
        }
    }

    public void buyProduct(Input input, UserService userService) {
        int productId = input.readInt("Введите ID продукта для покупки: ");
        int quantity = input.readInt("Введите количество для покупки: ");
        int userId = input.readInt("Введите ID пользователя: ");

        Optional<Product> productOptional = productRepository.loadProducts()
                .stream()
                .filter(product -> product.getId() == productId)
                .findFirst();

        Optional<User> userOptional = userService.getUserById(userId);

        if (productOptional.isPresent() && userOptional.isPresent()) {
            Product product = productOptional.get();
            User user = userOptional.get();

            double totalCost = product.getPrice() * quantity;

            if (product.getQuantity() >= quantity) {
                if (user.getBalance() >= totalCost) {
                    product.setQuantity(product.getQuantity() - quantity);
                    user.setBalance(user.getBalance() - totalCost);

                    System.out.println("Покупка успешна! Остаток баланса пользователя: $" + user.getBalance());

                    if (product.getQuantity() == 0) {
                        productRepository.loadProducts().remove(product);
                        System.out.println("Товар " + product.getName() + " удален из списка, так как его количество равно 0.");
                    }
                } else {
                    System.out.println("Недостаточно средств на балансе пользователя.");
                }
            } else {
                System.out.println("Недостаточно товара на складе.");
            }
        } else {
            System.out.println("Продукт или пользователь с указанным ID не найден.");
        }
    }


    public void editProduct(Input input) {
        int id = input.readInt("Введите ID продукта для редактирования: ");
        Optional<Product> productOptional = productRepository.loadProducts()
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst();

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(input.readString("Введите новое название продукта: "));
            product.setPrice(input.readDouble("Введите новую цену продукта: "));
            product.setQuantity(input.readInt("Введите новое количество продукта: "));
            System.out.println("Продукт успешно обновлен: " + product);
        } else {
            System.out.println("Продукт с таким ID не найден!");
        }
    }

    public void deleteProduct(Input input) {
        int id = input.readInt("Введите ID продукта для удаления: ");
        productRepository.loadProducts()
                .removeIf(product -> product.getId() == id);
        System.out.println("Продукт удален.");
    }
}
