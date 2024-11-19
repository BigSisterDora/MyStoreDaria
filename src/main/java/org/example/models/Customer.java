package org.example.models;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name; // Позволяет изменить имя клиента
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance; // Позволяет изменить баланс клиента
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', balance=" + balance + "}";
    }
}
