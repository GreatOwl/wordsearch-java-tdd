package com.pillar.wordsearch;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class MainTest {

    @Test
    public void whenFileIsProvidedFileIsReadIntoMemory() {
        Main main = new Main();
        String filename = "puzzle1.txt";
        String testPath = System.getProperty("user.dir") + "/puzzles/" + filename;
        String testContents;
        try {
            testContents = new String(Files.readAllBytes(Paths.get(testPath)));
        } catch (IOException e) {
            testContents = "";
        };
        assertEquals(testContents, main.getFileContents(filename));        
    }
}