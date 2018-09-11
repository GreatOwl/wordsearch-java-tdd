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

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public List<Word> getWords() {
        return words;
    }
}