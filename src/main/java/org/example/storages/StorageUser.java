package org.example.storages;

import org.example.models.User;
import org.example.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class StorageUser extends UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public void saveUser(User user) {
        users.add(user);
        System.out.println("Пользователь сохранен: " + user);
    }

    @Override
    public List<User> loadUsers() {
        return users;
    }
}
