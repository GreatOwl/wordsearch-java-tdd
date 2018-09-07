package com.pillar.wordsearch;

import java.util.List;

public class Puzzle {
    
    String puzzle;
    List<String> words;

    public Puzzle(String puzzle, List<String> words) {
        this.puzzle = puzzle;
        this.words = words;
    }

    public String getPuzzle() {
        return puzzle;
    }
}