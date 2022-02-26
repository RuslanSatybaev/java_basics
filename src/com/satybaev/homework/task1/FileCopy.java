package com.satybaev.homework.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String fileCopyPath = "src/com/satybaev/documents/data.txt";
        String filePastePath = "src/com/satybaev/documents/result.txt";

        FileInputStream fileInputStream = new FileInputStream(fileCopyPath);
        FileOutputStream fileOutputStream = new FileOutputStream(filePastePath);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
