package org.example.tests;

import org.example.models.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Apple", 1.5, 10);
        assertEquals("Apple", product.getName());
        assertEquals(1.5, product.getPrice());
        assertEquals(10, product.getQuantity());
    }
}