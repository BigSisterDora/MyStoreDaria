package org.example.app;

import org.example.helpers.AppHelperProductDataInput;
import org.example.helpers.AppHelperUserDataInput;
import org.example.models.Product;
import org.example.models.User;
import org.example.services.ProductService;
import org.example.services.UserService;
import org.example.tools.Input;

public class App {
    private final Input input;
    private final ProductService productService;
    private final UserService userService;

    public App(Input input, ProductService productService, UserService userService) {
        this.input = input;
        this.productService = productService;
        this.userService = userService;
    }

    public void run() {
        boolean repeat = true;
        System.out.println("--------------- My Store --------------");
        do {
            System.out.println("Список задач: ");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Список продуктов");
            System.out.println("3. Добавить пользователя");
            System.out.println("4. Список пользователей");
            System.out.println("5. Купи продукт");
            System.out.println("6. Редактировать продукт");
            System.out.println("7. Удалить продукт");
            System.out.println("8. Редактировать пользователя");
            System.out.println("9. Удалить пользователя");

            System.out.print("Выберите номер задачи: ");
            int task = input.readInt("");

            switch (task) {
                case 0:
                    repeat = false;
                    break;

                case 1:
                    Product newProduct = productService.createProduct(input);
                    productService.addProduct(newProduct);
                    break;

                case 2:
                    productService.listProducts();
                    break;

                case 3:
                    AppHelperUserDataInput appHelperUserDataInput = new AppHelperUserDataInput(input);
                    User newUser = appHelperUserDataInput.createUser();
                    userService.addUser(newUser);
                    break;

                case 4:
                    userService.listUsers();
                    break;

                case 5:
                    productService.buyProduct(input, userService);
                    break;

                case 6:
                    productService.editProduct(input);
                    break;

                case 7:
                    productService.deleteProduct(input);
                    break;

                case 8:
                    userService.editUser(input);
                    break;

                case 9:
                    userService.deleteUser(input);
                    break;

                default:
                    System.out.println("Выберите номер задачи из списка!");
            }
        } while (repeat);
        System.out.println("До свидания!");
    }
}
