package org.example.helpers;

import org.example.models.User;
import org.example.tools.Input;

public class AppHelperUserDataInput {
    public User createUser(Input input) {
        int id = input.readInt("Enter user ID: ");
        String name = input.readString("Enter user name: ");
        return new User(id, name);
    }
}