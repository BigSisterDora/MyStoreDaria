package org.example.tools;

public interface Input {
    int readInt(String prompt);      // Чтение целого числа
    String readString(String prompt); // Чтение строки
    double readDouble(String prompt); // Чтение числа с плавающей точкой
}
