package com.pillar.wordsearch;

import java.util.ArrayList;
import java.util.List;
import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;
import com.pillar.wordsearch.Word;

public class Search {

    private Puzzle puzzle;
    public Search(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public Search(List<Word> words) {
        
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("abcd"));
        words.add(new Word("aeil"));
        words.add(new Word("afkp"));
        words.add(new Word("mjhd"));
        return words;
    }
}