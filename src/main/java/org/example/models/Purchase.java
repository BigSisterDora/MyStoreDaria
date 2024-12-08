package org.example.models;

public class Purchase {
    private Product product;
    private Customer customer;
    private int quantity;

    public Purchase(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

}
