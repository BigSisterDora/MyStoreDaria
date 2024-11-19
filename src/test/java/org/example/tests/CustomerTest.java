package org.example.tests;

import org.example.models.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerCreation() {
        // Проверяем, что объект Customer создается с правильными значениями
        Customer customer = new Customer("Alice", 150.0);
        assertEquals("Alice", customer.getName());
        assertEquals(150.0, customer.getBalance());
    }

    @Test
    public void testGetName() {
        // Проверяем, что getName() возвращает корректное имя
        Customer customer = new Customer("Bob", 200.0);
        assertEquals("Bob", customer.getName());
    }

    @Test
    public void testGetBalance() {
        // Проверяем, что getBalance() возвращает корректный баланс
        Customer customer = new Customer("Carol", 300.0);
        assertEquals(300.0, customer.getBalance());
    }

    @Test
    public void testSetBalance() {
        // Проверяем, что setBalance() корректно изменяет баланс
        Customer customer = new Customer("Dave", 400.0);
        customer.setBalance(350.0);
        assertEquals(350.0, customer.getBalance());
    }
}
