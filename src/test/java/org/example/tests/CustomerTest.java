package org.example.tests;

import org.example.models.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer("Alice", 150.0);
        assertEquals("Alice", customer.getName());
        assertEquals(150.0, customer.getBalance());
    }

    @Test
    public void testGetName() {
        Customer customer = new Customer("Bob", 200.0);
        assertEquals("Bob", customer.getName());
    }

    @Test
    public void testGetBalance() {
        Customer customer = new Customer("Carol", 300.0);
        assertEquals(300.0, customer.getBalance());
    }

    @Test
    public void testSetBalance() {
        Customer customer = new Customer("Dave", 400.0);
        customer.setBalance(350.0);
        assertEquals(350.0, customer.getBalance());
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer("Eve", 500.0);
        customer.setName("Eve Adams");
        assertEquals("Eve Adams", customer.getName());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Frank", 600.0);
        String expected = "Customer{name='Frank', balance=600.0}";
        assertEquals(expected, customer.toString());
    }
}
