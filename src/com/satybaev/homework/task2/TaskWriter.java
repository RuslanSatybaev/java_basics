package com.satybaev.homework.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskWriter {
    public static void main(String[] args) throws IOException {
        new TaskWriter().userEnterCount();
    }

    private void userEnterCount() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please write any word and count");
        String word = reader.readLine();
        String count = reader.readLine();
        int nCount = Integer.parseInt(count);
        int i = 0;
        while (i < nCount) {
            System.out.println(word);
            i++;
        }
    }
}
