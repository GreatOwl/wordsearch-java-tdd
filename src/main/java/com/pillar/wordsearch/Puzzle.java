package com.pillar.wordsearch;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {
    
    String puzzle;
    String compressedPuzzle;

    Integer rows;
    List<String> rowContents;
    List<String> columnContents;
    List<String> leftDiagContents;
    List<String> rightDiagContents;

    public Puzzle(String puzzle) {
        this.puzzle = puzzle;
        rowContents = new ArrayList<String>();
        columnContents = new ArrayList<String>();
        leftDiagContents = new ArrayList<String>();
        rightDiagContents = new ArrayList<String>();
        breakdownPuzzle();
    }

    public String getPuzzle() {
        return puzzle;
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
        return getRows().get(row);
    }

    private void breakdownPuzzle() {
        int rowCount = getRowCount();
        for(int row = 0; row < rowCount; row = row + 1) {
            loadRow(row);
            String rowCharacters = getRow(row);
            loadCharacters(row, rowCount, rowCharacters);
        }
    }

    private void loadCharacters(int rowPosition, int rowCount, String row) {
        for(int character = 0; character < row.length(); character = character + 1) {
            String currentCharacter = row.substring(character, character + 1);
            loadColumn(rowPosition, character, currentCharacter);
            loadLeftDiag(rowPosition, character, rowCount, currentCharacter);
            loadRightDiag(rowPosition, character, rowCount, currentCharacter);
        }
    }

    private void loadRow(int row) {
        int start = row * getRowCount();
        int end = start + getRowCount();
        String rowCharacters = compressedPuzzle.substring(start, end);
        rowContents.add(row, rowCharacters);
    }

    private void loadColumn(int row, int column, String character) {
        safeUpdateList(column, columnContents, character);
    }

    private void loadRightDiag(int row, int column, int rowCount, String character) {
        int diag = row + column - 1;
        if (isSingleCharDiag(diag)) {
            return;
        }
        safeUpdateList(diag, rightDiagContents, character);
    }

    private void safeUpdateList(int index, List<String> container, String value) {
        String current = value;
        if (index >= 0) {
            try {
                current = container.get(index) + current;
            } catch ( IndexOutOfBoundsException e ) {
                if (container.size() < index) {
                    for (int missingEntry = 0; missingEntry < index; missingEntry = missingEntry + 1) {
                        container.add( missingEntry, "" );
                    }
                }
                container.add( index, current );
            }
            container.set(index, current);
        }
    }

    private void loadLeftDiag(int row, int column, int rowCount, String character) {
        // int diag = rowCount - row + column + 1;
        int diag = row - column + 1;
        if (isSingleCharDiag(diag)) {
            return;
        }
        safeUpdateList(diag, leftDiagContents, character);
    }

    public List<String> getRows() {
        return rowContents;
    }

    public String getColumn(int column) {
        return getColumns().get(column);
    }

    public List<String> getColumns() {
        return columnContents;
    }

    public String getLeftDiag(int diag) { // m
        if (isSingleCharDiag(diag)) {
            return "";
        }

        return leftDiagContents.get(diag);
    }

    private boolean isSingleCharDiag(int diag) {
        return (diag + 1) >= (2 * getRowCount() - 2);
    }

    public String getRightDiag(int diag) { //m
        if (isSingleCharDiag(diag)) {
            return "";
        }

        return rightDiagContents.get(diag);
    }
}