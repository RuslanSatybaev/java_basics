package com.satybaev.homework.task1.additional_task;

public class CycleFibonacci {
    public static void main(String[] args) {
        int number0 = 0;
        int numberFirst = 1;
        int numberSecond = 1;

        int numberFibonacci;
        System.out.print(number0 + " " + numberFirst + " " + numberSecond + " ");

        for (int i = 3; i < 20; i++) {
            numberFibonacci = numberFirst + numberSecond;
            System.out.print(numberFibonacci + " ");
            numberFirst = numberSecond;
            numberSecond = numberFibonacci;
        }
        System.out.println();
    }
}
