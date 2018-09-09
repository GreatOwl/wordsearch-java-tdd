package com.pillar.wordsearch;

import java.util.ArrayList;
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

    public List<String> getRows() {
        List<String> rows = new ArrayList<String>();
        for(int row = 0; row < getRowCount(); row = row + 1) {
            rows.add(getRow(row));
        }
        return rows;
    }

    public String getColumn(int column) {
        String columnContents = "";
        for (int row = 0; row < getRowCount(); row = row + 1) {
            columnContents = columnContents + getRow(row).substring(column, column + 1);
        }
        return columnContents;
    }

    public List<String> getColumns() {
        List<String> columns = new ArrayList<String>();
        for(int column = 0; column < getRowCount(); column = column + 1) {
            columns.add(getColumn(column));
        }
        return columns;
    }

    public String getLeftDiag(int diag) { // m
        //Left Diag formula 1 based index on paper:
        // m = n - y + x - 1
        diag = diag + 1; //correct to remove single character results
        String diagContents = "";
        int rowcount = getRowCount();// n
        for(int row = 0; row < getRowCount(); row = row + 1) { // y
            String rowContents = getRow(row);
            int column = rowcount - diag + row - 1; // x

            if (column + 1 <= rowContents.length() && column >= 0) {
                diagContents = diagContents + rowContents.substring(column, column + 1);
            }
        }
        return diagContents;
    }
}