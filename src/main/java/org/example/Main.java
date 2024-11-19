package org.example;

import org.example.models.Product;
import org.example.models.Customer;
import org.example.store.StoreManager;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static StoreManager storeManager = new StoreManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Устанавливаем локализацию для корректного ввода чисел с точкой
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an action:");
            System.out.println("0 - Exit");
            System.out.println("1 - Add Product");
            System.out.println("2 - List Products");
            System.out.println("3 - Add Customer");
            System.out.println("4 - List Customers");
            System.out.println("5 - Buy Product");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    storeManager.addProduct(new Product(productName, price, quantity));
                    System.out.println("Product added.");
                    break;
                case 2:
                    System.out.println("Product list:");
                    for (Product product : storeManager.getProducts()) {
                        System.out.println(product.getName() + " - " + product.getPrice() + " (" + product.getQuantity() + ")");
                    }
                    break;
                case 3:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer balance: ");
                    double balance = scanner.nextDouble();
                    storeManager.addCustomer(new Customer(customerName, balance));
                    System.out.println("Customer added.");
                    break;
                case 4:
                    System.out.println("Customer list:");
                    for (Customer customer : storeManager.getCustomers()) {
                        System.out.println(customer.getName() + " - Balance: " + customer.getBalance());
                    }
                    break;
                case 5:
                    System.out.print("Enter customer name: ");
                    String buyerName = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int purchaseQuantity = scanner.nextInt();
                    Customer customer = storeManager.findCustomerByName(buyerName);
                    Product product = storeManager.findProductByName(itemName);
                    if (customer != null && product != null) {
                        storeManager.makePurchase(customer, product, purchaseQuantity);
                        System.out.println("Purchase completed.");
                    } else {
                        System.out.println("Invalid customer or product.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
