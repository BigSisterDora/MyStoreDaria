package org.example.tests;

import org.example.models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User("Eve", 500.0);
        assertEquals(1, user.getId()); // Предполагается, что это первый созданный пользователь
        assertEquals("Eve", user.getName());
        assertEquals(500.0, user.getBalance());
    }

    @Test
    public void testGetName() {
        User user = new User("Frank", 750.0);
        assertEquals("Frank", user.getName());
    }

    @Test
    public void testSetName() {
        User user = new User("Grace", 800.0);
        user.setName("Grace Hopper");
        assertEquals("Grace Hopper", user.getName());
    }

    @Test
    public void testGetBalance() {
        User user = new User("Heidi", 900.0);
        assertEquals(900.0, user.getBalance());
    }

    @Test
    public void testSetBalance() {
        User user = new User("Ivan", 1000.0);
        user.setBalance(950.0);
        assertEquals(950.0, user.getBalance());
    }
}
