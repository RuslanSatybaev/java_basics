package com.satybaev.homework.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameAndAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please write your name and age");
        String name = reader.readLine();
        String age = reader.readLine();
        int nAge = Integer.parseInt(age);

        System.out.println("Your name is: " + name + "\n" + "Your age: " + nAge);
    }
}
