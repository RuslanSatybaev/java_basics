package com.satybaev.homework.task2;

public class TaskSquare {

    private static final String S = "S";

    public static void main(String[] args) {
        new TaskSquare().printS();
        System.out.println("**********************");
        new TaskSquare().printMultiplicationTable();
    }

    private void printS() {
        int i = 0, j = 0;
        while (j < 10) {
            while (i < 10) {
                System.out.print(S);
                i++;
            }
            i = 0;
            j++;
            System.out.println();
        }
    }

    private void printMultiplicationTable() {
        int k = 1, n = 1;
        while (k <= 10) {
            System.out.print(k + " ");
            while (n <= 9) {
                n++;
                System.out.print(k * n + " ");
            }
            k++;
            n = 1;
            System.out.println("");
        }
    }
}
