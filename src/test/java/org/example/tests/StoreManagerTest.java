package org.example.tests;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.store.StoreManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StoreManagerTest {

    @Test
    public void testAddProduct() {
        StoreManager storeManager = new StoreManager();
        Product product = new Product("Apple", 1.5, 10);
        storeManager.addProduct(product);
        assertEquals(1, storeManager.getProducts().size());
    }

    @Test
    public void testAddCustomer() {
        StoreManager storeManager = new StoreManager();
        Customer customer = new Customer("John Doe", 100.0);
        storeManager.addCustomer(customer);
        assertEquals(1, storeManager.getCustomers().size());
    }

    @Test
    public void testMakePurchase() {
        StoreManager storeManager = new StoreManager();
        Product product = new Product("Apple", 1.5, 10);
        Customer customer = new Customer("John Doe", 100.0);

        storeManager.addProduct(product);
        storeManager.addCustomer(customer);
        storeManager.makePurchase(customer, product, 2);

        assertEquals(8, product.getQuantity());        // Проверка, что количество продукта уменьшилось
        assertEquals(97.0, customer.getBalance());     // Проверка, что баланс клиента уменьшился
    }

    @Test
    public void testFindCustomerByName() {
        StoreManager storeManager = new StoreManager();
        Customer customer = new Customer("Jane Doe", 50.0);
        storeManager.addCustomer(customer);

        Customer foundCustomer = storeManager.findCustomerByName("Jane Doe");
        assertNotNull(foundCustomer);
        assertEquals("Jane Doe", foundCustomer.getName());
    }

    @Test
    public void testFindProductByName() {
        StoreManager storeManager = new StoreManager();
        Product product = new Product("Orange", 2.0, 20);
        storeManager.addProduct(product);

        Product foundProduct = storeManager.findProductByName("Orange");
        assertNotNull(foundProduct);
        assertEquals("Orange", foundProduct.getName());
    }
}
