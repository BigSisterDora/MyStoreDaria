package org.example.services;

import org.example.helpers.AppHelperUserDataInput;
import org.example.models.User;

public class UserService {
    public void addUser(AppHelperUserDataInput appHelperUserDataInput) {
        User user = appHelperUserDataInput.createUser();
        System.out.println("User added: " + user);
    }

    public void listUsers() {
        // Logic for listing users
    }
}