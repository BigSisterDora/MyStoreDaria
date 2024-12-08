package org.example.services;

import org.example.models.User;
import org.example.repository.UserRepository;
import org.example.tools.Input;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(Input input) {
        String name = input.readString("Введите имя пользователя: ");
        double balance = input.readDouble("Введите начальный баланс пользователя: ");
        return new User(name, balance); // ID создается автоматически
    }

    public Optional<User> getUserById(int id) {
        return userRepository.loadUsers()
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public void addUser(User user) {
        userRepository.saveUser(user);
        System.out.println("Пользователь добавлен: " + user);
    }

    public void listUsers() {
        System.out.println("Список пользователей:");
        for (User user : userRepository.loadUsers()) {
            System.out.println(user);
        }
    }

    public void editUser(Input input) {
        int id = input.readInt("Введите ID пользователя для редактирования: ");
        Optional<User> userOptional = getUserById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(input.readString("Введите новое имя пользователя: "));
            user.setBalance(input.readDouble("Введите новый баланс пользователя: "));
            System.out.println("Пользователь успешно обновлен: " + user);
        } else {
            System.out.println("Пользователь с таким ID не найден!");
        }
    }

    public void deleteUser(Input input) {
        int id = input.readInt("Введите ID пользователя для удаления: ");
        boolean removed = userRepository.loadUsers()
                .removeIf(user -> user.getId() == id);

        if (removed) {
            System.out.println("Пользователь с ID " + id + " успешно удален.");
        } else {
            System.out.println("Пользователь с таким ID не найден!");
        }
    }
}
