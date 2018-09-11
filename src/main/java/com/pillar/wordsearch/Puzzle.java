package com.pillar.wordsearch;

import java.util.ArrayList;
import java.util.List;
import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;

public class Puzzle {
    
    String puzzle;
    String compressedPuzzle;

    Integer rows;
    List<StringVector> rowContents;
    List<StringVector> columnContents;
    List<StringVector> leftDiagContents;
    List<StringVector> rightDiagContents;

    public Puzzle(String puzzle) {
        this.puzzle = puzzle;
        rowContents = new ArrayList<StringVector>();
        columnContents = new ArrayList<StringVector>();
        leftDiagContents = new ArrayList<StringVector>();
        rightDiagContents = new ArrayList<StringVector>();
        breakdownPuzzle();
    }

    public String getPuzzle() {
        return puzzle;
    }

    public int getRowCount() {
        if (rows == null) {
            String puzzle = compressPuzzle();
            double length = (double) puzzle.length();
            float rowLength = (float) Math.sqrt(length);
            rows = Integer.valueOf(Math.round(rowLength));
        }
        return rows.intValue();
    }

    public String compressPuzzle() {
        if (compressedPuzzle == null) {
            compressedPuzzle = puzzle.replaceAll("\\s+", "");
        }
        return compressedPuzzle;
    }

    private void breakdownPuzzle() {
        int rowCount = getRowCount();
        for(int row = 0; row < rowCount; row = row + 1) {
            loadRow(row);
            StringVector rowCharacters = getRow(row);
            loadCharacters(row, rowCount, rowCharacters);
        }
    }

    private void loadCharacters(int rowPosition, int rowCount, StringVector row) {
        for(int character = 0; character < row.length(); character = character + 1) {
            StringVector currentCharacter = row.substring(character, character + 1);
            loadColumn(rowPosition, character, currentCharacter.clone());
            loadLeftDiag(rowPosition, character, rowCount, currentCharacter.clone());
            loadRightDiag(rowPosition, character, rowCount, currentCharacter.clone());
        }
    }

    private void safeUpdateList(int index, List<StringVector> container, StringVector value) {
        StringVector current = value;
        if (index >= 0) {
            try {
                current = container.get(index);
                current.append(value);
            } catch ( IndexOutOfBoundsException e ) {
                if (container.size() < index) {
                    for (int missingEntry = 0; missingEntry < index; missingEntry = missingEntry + 1) {
                        container.add( missingEntry, new StringVector());
                    }
                }
                container.add( index, current );
            }
            container.set(index, current);
        }
    }

    private void loadRow(int row) {
        int rowCount = getRowCount();
        int start = row * rowCount;
        int end = start + rowCount;
        String rowCharacters = compressedPuzzle.substring(start, end);
        rowContents.add(row, new StringVector(rowCharacters, new Coordinate(0,row), new Coordinate(rowCount - 1, row)));
    }

    private void loadColumn(int row, int column, StringVector character) {
        safeUpdateList(column, columnContents, character);
    }

    private void loadRightDiag(int row, int column, int rowCount, StringVector character) {
        int diag = row + column - 1;
        if (isSingleCharDiag(diag)) {
            return;
        }
        safeUpdateList(diag, rightDiagContents, character);
    }

    private void loadLeftDiag(int row, int column, int rowCount, StringVector character) {
        // int diag = rowCount - row + column + 1;
        int diag = row - column + 1;
        if (isSingleCharDiag(diag)) {
            return;
        }
        safeUpdateList(diag, leftDiagContents, character);
    }

    public List<StringVector> getRows() {
        return rowContents;
    }

    public StringVector getRow(int row) {
        return getRows().get(row);
    }

    public StringVector getColumn(int column) {
        return getColumns().get(column);
    }

    public List<StringVector> getColumns() {
        return columnContents;
    }

    public List<StringVector> getLeftDiags() {
        return leftDiagContents;
    }

    public List<StringVector> getRightDiags() {
        return rightDiagContents;
    }

    public StringVector getLeftDiag(int diag) { // m
        if (isSingleCharDiag(diag)) {
            return new StringVector();
        }

        return getLeftDiags().get(diag);
    }

    private boolean isSingleCharDiag(int diag) {
        return (diag + 1) >= (2 * getRowCount() - 2);
    }

    public StringVector getRightDiag(int diag) { //m
        if (isSingleCharDiag(diag)) {
            return new StringVector();
        }

        return getRightDiags().get(diag);
    }
}