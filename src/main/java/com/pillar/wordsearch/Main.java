package com.pillar.wordsearch;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    public String getFileContents(String filename) {
        String filePath = System.getProperty("user.dir") + "/puzzles/" + filename;
        String data;
        try {
            data = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            data = e.getMessage();
        };
        return data;
    }

    public String[] splitIntoLines(String data) {
        return data.split("\\s+");
    }
}
    