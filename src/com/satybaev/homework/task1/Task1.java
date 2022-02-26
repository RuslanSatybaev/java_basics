package com.satybaev.homework.task1;

public class Task1 {
    private static String TEXT = "Welcome to fellowship";

    public static void main(String[] args) {
        System.out.println(TEXT);

        String anyWord = "Ha-ha-ha";
        printTextMoreTimes(anyWord, 3);
    }

    public static void printTextMoreTimes(String anyWord, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(anyWord);
        }
    }
}
