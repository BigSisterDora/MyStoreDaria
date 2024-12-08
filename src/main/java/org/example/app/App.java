package org.example.app;

import org.example.helpers.AppHelperProductDataInput;
import org.example.helpers.AppHelperUserDataInput;
import org.example.models.Product;
import org.example.models.User;
import org.example.services.ProductService;
import org.example.services.UserService;
import org.example.tools.Input;


import java.util.Scanner;

public class App {
    private final Input input;
    private final ProductService productService;
    private final UserService userService;
    private Scanner scanner = new Scanner(System.in);

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

            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    AppHelperProductDataInput appHelperProductDataInput = new AppHelperProductDataInput();
                    productService.addProduct(appHelperProductDataInput);
                    break;
                case 2:
                    productService.listProducts();
                    break;
                case 3:
                    AppHelperUserDataInput appHelperUserDataInput = new AppHelperUserDataInput();
                    userService.addUser(appHelperUserDataInput);
                    break;
                case 4:
                    userService.listUsers();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Выберите номер задачи из списка!");
            }
        } while (repeat);
        System.out.println("До свидания!");
    }
}