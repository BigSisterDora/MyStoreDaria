package org.example.helpers;

import org.example.models.User;
import org.example.tools.Input;

public class AppHelperUserDataInput {
    private final Input input;

    public AppHelperUserDataInput(Input input) {
        this.input = input;
    }

    public User createUser() {
        System.out.println("Добавление нового пользователя:");
        String name = input.readString("Введите имя пользователя: ");
        double balance = input.readDouble("Введите начальный баланс пользователя: ");
        return new User(name, balance); // ID создается автоматически
    }
}
