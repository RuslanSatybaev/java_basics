package com.satybaev.homework.task3.additonal_task3;

import java.io.IOException;

import static com.satybaev.homework.task3.additonal_task3.TicTACxmlWriter.xmlWrite;

public class MainTicTacToe {
    public static void main(String[] args) throws IOException {
        PlayTicTac playTicTacToe = new PlayTicTac();
        playTicTacToe.game();
        xmlWrite();
    }
}

