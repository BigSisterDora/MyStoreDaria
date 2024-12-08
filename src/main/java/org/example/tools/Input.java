package org.example.tools;

public interface Input {
    String readString(String prompt);
    int readInt(String prompt);
    double readDouble(String prompt);
}