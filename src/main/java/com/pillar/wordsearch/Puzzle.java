package com.pillar.wordsearch;

import java.util.List;

public class Puzzle {
    
    String puzzle;
    String compressedPuzzle;
    List<String> words;

    Integer rows;

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
        String puzzle = compressPuzzle();
        double length = (double) puzzle.length();
        float rowLength = (float) Math.sqrt(length);
        rows = Integer.valueOf(Math.round(rowLength));
        return rows.intValue();
    }

    public String compressPuzzle() {
        if (compressedPuzzle == null) {
            compressedPuzzle = puzzle.replaceAll("\\s+", "");
        }
        return compressedPuzzle;
    }

    public String getRow(int row) {
        int start = row * getRowCount();
        int end = start + getRowCount();
        return compressedPuzzle.substring(start, end);
    }

    public String getColumn(int column) {
        return "am";
    }
}