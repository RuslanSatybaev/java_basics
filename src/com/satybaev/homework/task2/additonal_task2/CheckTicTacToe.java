package com.satybaev.homework.task2.additonal_task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class CheckTicTacToe {

    private final char SIGN_X = 'x';
    private final char SIGN_0 = '0';
    private final char empty = '_';
    private final char[][] table;
    private final Random random;
    private final BufferedReader reader;
    private String name;
    private Rating rating;

    public CheckTicTacToe() {
        random = new Random();
        reader = new BufferedReader(new InputStreamReader(System.in));
        table = new char[3][3];
        rating = new Rating();

    }

    public void game() {
        initTable();
        System.out.println("Please enter your name:");
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println(name + " you win");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry Draw");
                break;
            }
            turnAI();
            printTable();
            if (checkWin(SIGN_0)) {
                System.out.println("Computer win");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, Draw");
                break;
            }
        }
        System.out.println("Game over");
        printTable();
        rating.writeRating(name);
    }

    private void initTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                table[row][col] = empty;
            }
        }
    }

    private void printTable() {
        for (int row = 0; row < 3; row++) {
            char separator = '|';
            for (int col = 0; col < 3; col++) {
                System.out.print(separator + "" + table[row][col]);
            }
            System.out.print(separator);
            System.out.println();
        }
    }

    private void turnHuman() {
        try {
            int x, y;
            do {

                System.out.println(name + " Enter X and Y (1-3):");
                int inputX = Integer.parseInt(reader.readLine());
                int inputY = Integer.parseInt(reader.readLine());
                x = inputX - 1;
                y = inputY - 1;
            } while (!isCellValid(x, y));
            table[y][x] = SIGN_X;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return table[y][x] == empty;
    }

    private void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_0;
    }

    private boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == dot && table[i][1] == dot &&
                    table[i][2] == dot) ||
                    (table[0][i] == dot && table[1][i] == dot &&
                            table[2][i] == dot))
                return true;
        return (table[0][0] == dot && table[1][1] == dot &&
                table[2][2] == dot) ||
                (table[2][0] == dot && table[1][1] == dot &&
                        table[0][2] == dot);
    }

    private boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == empty)
                    return false;
        return true;
    }
}
