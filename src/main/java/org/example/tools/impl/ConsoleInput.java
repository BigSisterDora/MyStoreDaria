package org.example.tools.impl;

import org.example.tools.Input;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(Locale.US); // Поддержка чисел с точкой в локали
    }

    @Override
    public int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите корректное целое число!");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // Сброс строки после ввода числа
        return result;
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите корректное число (например, 0.70)!");
            scanner.next();
        }
        double result = scanner.nextDouble();
        scanner.nextLine(); // Сброс строки после ввода числа
        return result;
    }
}
