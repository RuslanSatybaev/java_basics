package com.satybaev.homework.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskFor {

    private static final int X = 8;

    public static void main(String[] args) throws IOException {
        new TaskFor().printEvenNumbers(1, 100);
        System.out.println("****************");
        new TaskFor().printTriangle();
        new TaskFor().printEight();

    }

    private void printEvenNumbers(int firstNumber, int lastNumber) {
        for (int i = firstNumber; i <= lastNumber; i++) {
            if (i % 2 == 0)
                System.out.print(i + " ");
        }
    }

    private void printEight() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please write value for m and n");
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(X);
            }
            System.out.println();
        }
    }

    private void printTriangle() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i <= j; i++) {
                System.out.print(X);
            }
            System.out.println();
        }
    }
}
