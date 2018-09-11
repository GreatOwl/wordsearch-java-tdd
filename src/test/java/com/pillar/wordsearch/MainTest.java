package com.pillar.wordsearch;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Main main;
    private String testContents;
    private String filename;
    @Before
    public void setup() {
        filename = "puzzle1.txt";
        main = new Main();
        String testPath = System.getProperty("user.dir") + "/puzzles/" + filename;
        try {
            testContents = new String(Files.readAllBytes(Paths.get(testPath)));
        } catch (IOException e) {
            testContents = "";
        };
    }

    @Test
    public void whenFileIsProvidedFileIsReadIntoMemory() {
        assertEquals(testContents, main.getFileContents(filename));        
    }
}