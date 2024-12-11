package org.example.tests;

import org.example.models.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreationWithId() {
        Product product = new Product(1, "Apple", 1.5, 10);
        assertEquals(1, product.getId());
        assertEquals("Apple", product.getName());
        assertEquals(1.5, product.getPrice());
        assertEquals(10, product.getQuantity());
    }

    @Test
    public void testProductCreationWithoutId() {
        Product product = new Product("Banana", 0.75, 20);
        // Предполагается, что ID будет установлен позже
        assertEquals(0, product.getId());
        assertEquals("Banana", product.getName());
        assertEquals(0.75, product.getPrice());
        assertEquals(20, product.getQuantity());
    }

    @Test
    public void testSetName() {
        Product product = new Product("Cherry", 2.0, 15);
        product.setName("Cherry Deluxe");
        assertEquals("Cherry Deluxe", product.getName());
    }

    @Test
    public void testSetPrice() {
        Product product = new Product("Date", 3.0, 5);
        product.setPrice(3.5);
        assertEquals(3.5, product.getPrice());
    }

    @Test
    public void testSetQuantity() {
        Product product = new Product("Elderberry", 4.0, 8);
        product.setQuantity(12);
        assertEquals(12, product.getQuantity());
    }

    @Test
    public void testToString() {
        Product product = new Product(2, "Fig", 2.5, 10);
        String expected = "2: Fig - $2.5 (10 pcs)";
        assertEquals(expected, product.toString());
    }
}
