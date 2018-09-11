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

    public List<Word> solvePuzzle() {
        List<Word> words = new ArrayList<Word>();
        Word word = new Word("abcd");
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0,0));
        coordinates.add(new Coordinate(1,0));
        coordinates.add(new Coordinate(2,0));
        coordinates.add(new Coordinate(3,0));
        word.attach(coordinates);
        words.add(word);
        return words;
    }
}