package com.satybaev.homework.task3.print;

import com.satybaev.homework.task3.model.*;
import com.satybaev.homework.task3.parser.GameResultName;

public class InitPrintCheckTable {
    public static Player player = new GameResultName().returnPlayer();
    public static Game game = new Game();

    public static GamePlay gamePlay = new GamePlay();
    public static GameResult gameResult = new GameResult();
    public static Step step = new Step();
    public static String SIGN_X = "X";
    public static String SIGN_0 = "0";
    public static String[][] table;

    public static void initArray() {
        table = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    }

    public static void printArray() {
        for (int row = 0; row < 3; row++) {
            char separator = '|';
            for (int col = 0; col < 3; col++) {
                if (step.getPlayerId() == 1 && table[row][col].equals(String.valueOf(step.getValue()))) {
                    table[row][col] = SIGN_X;
                } else if (step.getPlayerId() == 2 && table[row][col].equals(String.valueOf(step.getValue()))) {
                    table[row][col] = SIGN_0;
                }
                System.out.print(separator + "" + table[row][col]);
            }
            System.out.print(separator);
            System.out.println();
        }
    }

    public static boolean checkWin(String dot) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0].equals(dot) && table[i][1].equals(dot) &&
                    table[i][2].equals(dot)) ||
                    (table[0][i].equals(dot) && table[1][i].equals(dot) &&
                            table[2][i].equals(dot)))
                return true;
        return (table[0][0].equals(dot) && table[1][1].equals(dot) &&
                table[2][2].equals(dot)) ||
                (table[2][0].equals(dot) && table[1][1].equals(dot) &&
                        table[0][2].equals(dot));
    }
}
