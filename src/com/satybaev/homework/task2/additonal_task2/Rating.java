package com.satybaev.homework.task2.additonal_task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Rating {
    public void writeRating(String text) {
        String filePath = "src/com/satybaev/documents/rating.txt";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text + "          ");
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
