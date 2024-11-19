package org.example.store;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.models.Purchase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreManager {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();
    private final String DATA_FILE = "storeData.dat";

    public StoreManager() {
        loadData();
    }

    public void addProduct(Product product) {
        if (product.getQuantity() > 0) {
            products.add(product);
            saveData();
        } else {
            System.out.println("Cannot add product with zero quantity.");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveData();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(products);
            oos.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            products = (List<Product>) ois.readObject();
            customers = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Starting with empty store.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public void makePurchase(Customer customer, Product product, int quantity) {
        if (product.getQuantity() >= quantity && customer.getBalance() >= product.getPrice() * quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            customer.setBalance(customer.getBalance() - product.getPrice() * quantity);
            purchases.add(new Purchase(product, customer, quantity));

            // Удаление продукта, если количество стало 0
            if (product.getQuantity() == 0) {
                products.remove(product);
                System.out.println("Product " + product.getName() + " is out of stock and has been removed from the list.");
            }

            saveData();
        } else {
            System.out.println("Not enough product quantity or customer balance.");
        }
    }

    public void editProduct(String productName, String newName, double newPrice, int newQuantity) {
        Product product = findProductByName(productName);
        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            saveData();
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(String productName) {
        Product product = findProductByName(productName);
        if (product != null) {
            products.remove(product);
            saveData();
            System.out.println("Product removed: " + productName);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void editCustomer(String customerName, String newName, double newBalance) {
        Customer customer = findCustomerByName(customerName);
        if (customer != null) {
            customer.setName(newName);
            customer.setBalance(newBalance);
            saveData();
            System.out.println("Customer updated: " + customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void removeCustomer(String customerName) {
        Customer customer = findCustomerByName(customerName);
        if (customer != null) {
            customers.remove(customer);
            saveData();
            System.out.println("Customer removed: " + customerName);
        } else {
            System.out.println("Customer not found.");
        }
    }
}
