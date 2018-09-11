package com.pillar.wordsearch;

import java.util.ArrayList;
import java.util.List;
import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;
import com.pillar.wordsearch.Word;

public class Search {

    private Puzzle puzzle;
    private List<Word> words;
    public Search(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public Search(List<Word> words) {
        this.words = words;
    }

    public Search(Puzzle puzzle, List<Word> words) {
        this.puzzle = puzzle;
        this.words = words;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public List<Word> getWords() {
        return words;
    }

    private List<Word> searchList(List<Word> accumulator, StringVector searchable) {
        wordLoop:
        for (Word word : words) {
            StringVector found = searchable.findSubstring(word.toString());
            if (found.length() == 0) {
                found = searchable.findSubstring(word.getReverseString());
            }

            if (found.length() > 0) {
                word.attach(found.getCoordinates());
                accumulator.add(word);
                break wordLoop;
            }
        }
        return accumulator;
    }

    private List<Word> searchVectorList(List<Word> accumulator, List<StringVector> vectors) {
        for (StringVector vector : vectors) {
            accumulator = searchList(accumulator, vector);
        }
        return accumulator;
    }

    public List<Word> solvePuzzle() {
        List<Word> solvedWords = new ArrayList<Word>();
        solvedWords = searchVectorList(solvedWords, puzzle.getRows());
        solvedWords = searchVectorList(solvedWords, puzzle.getColumns());
        // List<StringVector> columns = puzzle.getColumns();
        return solvedWords;
    }
}