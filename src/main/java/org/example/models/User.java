package org.example.models;

public class User {
    private static int idCounter = 1; // Генерация ID
    private int id;
    private String name;
    private double balance;

    public User(String name, double balance) {
        this.id = idCounter++;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return id + ": " + name + " (Баланс: $" + balance + ")";
    }
}
