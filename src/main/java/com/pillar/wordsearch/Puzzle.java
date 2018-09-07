package com.pillar.wordsearch;

import java.util.List;

public class Puzzle {
    
    String puzzle;
    String compressedPuzzle;
    List<String> words;

    public Puzzle(String puzzle, List<String> words) {
        this.puzzle = puzzle;
        this.words = words;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public List<String> getWords() {
        return words;
    }

    public int getRowCount() {
        return 15;
    }

    public String compressPuzzle() {
        if (compressedPuzzle == null) {
            compressedPuzzle = puzzle.replaceAll("\\s+", "");
        }
        return compressedPuzzle;
    }
}