package com.satybaev.homework.task2;

public class TaskWhile {
    public static void main(String[] args) {
        new TaskWhile().printIncrement(1, 10);
        System.out.println();
        new TaskWhile().printDecrement(1, 10);
    }

    private void printIncrement(int fistNumber, int lastNumber) {
        while (fistNumber <= lastNumber) {
            System.out.print(fistNumber+" ");
            fistNumber++;
        }
    }

    private void printDecrement(int fistNumber, int lastNumber) {
        while (fistNumber <= lastNumber) {
            System.out.print(lastNumber+" ");
            lastNumber--;
        }
    }
}
