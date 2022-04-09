package com.satybaev.homework.task3.additonal_task3;

import com.satybaev.homework.task3.model.Player;
import com.satybaev.homework.task3.model.Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.satybaev.homework.task3.print.InitPrintCheckTable.*;

public class PlayTicTac {

    private final BufferedReader reader;
    private String firstName, secondName, name, SIGN, wordYesOrNo;
    private final List<Player> playerList = new ArrayList<>();
    private final Player firstPlayer = new Player();
    private final Player secondPlayer = new Player();
    private static Player winPlayer = new Player();
    private static final List<Step> stepList = new ArrayList<>();
    private static Step step;

    int numStep = 1;
    int x;

    private boolean win = false;

    public PlayTicTac() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void game() throws IOException {
        initArray();
        writeName();
        againPlay();
    }

    private void writeName() throws IOException {
        System.out.println("Please enter your names:");
        firstName = reader.readLine();
        secondName = reader.readLine();
    }

    private void againPlay() throws IOException {
        while (true) {
            playWhile();
            System.out.println("Want to play again? Write Yes to continue or No to exit");
            wordYesOrNo = reader.readLine();
            if (wordYesOrNo.equals("No")) {
                System.out.println("Game over");
                playerList.add(firstPlayer);
                playerList.add(secondPlayer);

                gamePlay.setPlayerList(playerList);
                game.setListStep(stepList);
                break;
            }
            if (wordYesOrNo.equals("Yes")) {
                initArray();
                win = false;
            }
        }
    }

    private void playWhile() {
        while (true) {
            name = firstName;
            firstPlayer.setName(name);
            firstPlayer.setId(1);
            firstPlayer.setSymbol(SIGN_X);

            play();
            setStepList(firstPlayer);

            if (win) {
                break;
            }
            name = secondName;
            secondPlayer.setName(name);
            secondPlayer.setId(2);
            secondPlayer.setSymbol(SIGN_0);

            play();
            setStepList(secondPlayer);

            if (win) {
                break;
            }
        }
    }

    private void setStepList(Player player) {

        step = new Step();
        step.setNum(numStep);
        step.setPlayerId(player.getId());
        step.setValue(x);
        numStep++;
        stepList.add(step);
    }

    private void play() {
        turnHuman();
        addSign();
        if (checkWin(SIGN)) {
            System.out.println(name + " you win");
            if (name.equals(firstName)) {
                winPlayer = firstPlayer;
            }
            if (name.equals(secondName)) {
                winPlayer = secondPlayer;
            }
            gameResult.setWinPlayer(winPlayer);
            win = true;
        }
        printArray();
    }

    private void addSign() {
        if (name.equals(firstName)) {
            SIGN = SIGN_X;
        } else if (name.equals(secondName)) {
            SIGN = SIGN_0;
        }
    }

    private void turnHuman() {
        addSign();
        boolean checkInputX = false;
        try {
            System.out.println(name + " Enter 1-9:");
            String inputX = reader.readLine();


            do {
                for (String[] word : table) {
                    for (int i = 0; i < word.length; i++) {
                        if (word[i].equals(inputX)) {
                            word[i] = SIGN;
                            checkInputX = true;
                            break;
                        }
                    }
                    if (checkInputX) {
                        break;
                    }
                }
                x = Integer.parseInt(String.valueOf(inputX));
            } while (isCellValid(x));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean isCellValid(int x) {
        return x < 1 || x > 10;
    }

    private boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col].equals("X"))
                    return false;
        return true;
    }
}
