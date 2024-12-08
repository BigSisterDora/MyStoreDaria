package org.example.repository;

import org.example.models.User;
import java.util.ArrayList;
import java.util.List;

public abstract class UserRepository {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public abstract void saveUser(User user);

    public abstract List<User> loadUsers();
}
