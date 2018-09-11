package com.pillar.wordsearch;

import com.pillar.wordsearch.Search;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import com.pillar.wordsearch.Coordinate;
import com.pillar.wordsearch.Puzzle;
import com.pillar.wordsearch.Word;

public class SearchTest {

    @Test
    public void whenPuzzleRequestedPuzzleIsReturned() {
        Puzzle testPuzzle = new Puzzle("a b c d e f g h i j k l m n o p");
        Search actualSearch = new Search(testPuzzle);
        assertEquals(testPuzzle.compressPuzzle(), actualSearch.getPuzzle().compressPuzzle());
    }

    @Test
    public void whenPuzzleRequestedOriginalyGivenPuzzleIsReturned() {
        Puzzle testPuzzle = new Puzzle("a a a a b b b b c c c c d d d d");
        Search actualSearch = new Search(testPuzzle);
        assertEquals(testPuzzle.compressPuzzle(), actualSearch.getPuzzle().compressPuzzle());
    }

    private void assureWordsMatch(List<Word> test, List<Word> actual) {
        int pos = 0;
        for (Word word : test) {
            Word actualWord = actual.get(pos);
            assertEquals(word.toString(), actualWord.toString());
            try {
                assureCoordinatesMatch(word.getCoordinates(), actualWord.getCoordinates());
            } catch(NullPointerException e ) {

            }
            pos = pos + 1;
        }
    }

    private void assureCoordinatesMatch(List<Coordinate> test, List<Coordinate> actual) {
        int pos = 0;
        for (Coordinate coordinate : test) {
            assertEquals(coordinate.toString(), actual.get(pos).toString());
            pos = pos + 1;
        }
    }

    @Test
    public void whenWordsRequestedFromSearchWordsAreReturned() {
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("abcd"));
        words.add(new Word("aeil"));
        words.add(new Word("afkp"));
        words.add(new Word("mjhd"));
        Search actualSearch = new Search(words);
        assureWordsMatch(words, actualSearch.getWords());
    }

    @Test
    public void whenGivenWordsAreRequestedTheWordsAreReturned() {
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("abcd"));
        words.add(new Word("aeil"));
        words.add(new Word("afkp"));
        words.add(new Word("mjhd"));
        words.add(new Word("fgh"));
        Search actualSearch = new Search(words);
        assureWordsMatch(words, actualSearch.getWords());
    }

    @Test
    public void whenPuzzleNeedsSolvingSearchCanReturnMatches() {
        List<Word> words = new ArrayList<Word>();
        Word word = new Word("abcd");
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0,0));
        coordinates.add(new Coordinate(1,0));
        coordinates.add(new Coordinate(2,0));
        coordinates.add(new Coordinate(3,0));
        word.attach(coordinates);
        words.add(word);

        Puzzle testPuzzle = new Puzzle("a b c d e f g h i j k l m n o p");
        Search actualSearch = new Search(testPuzzle, words);
        assureWordsMatch(words, actualSearch.solvePuzzle());
    }

    @Test
    public void whenPuzzleNeedsSolvingSearchCanFindAndReturnMatches() {
        List<Word> words = new ArrayList<Word>();
        Word word = new Word("aeim");
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0,0));
        coordinates.add(new Coordinate(1,1));
        coordinates.add(new Coordinate(2,2));
        coordinates.add(new Coordinate(3,3));
        words.add(word);

        Puzzle testPuzzle = new Puzzle("a b c d e f g h i j k l m n o p");
        words = new ArrayList<Word>();
        words.add(new Word("aeim"));
        Search actualSearch = new Search(testPuzzle, words);
        assureWordsMatch(words, actualSearch.solvePuzzle());
    }

    @Test
    public void whenPuzzleNeedsSolvingSearchCanFindAndReturnLeftDiagonalMatches() {
        List<Word> words = new ArrayList<Word>();
        Word word = new Word("bgl");
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(1,0));
        coordinates.add(new Coordinate(2,1));
        coordinates.add(new Coordinate(3,2));
        words.add(word);

        Puzzle testPuzzle = new Puzzle("a b c d  e f g h  i j k l  m n o p");
        words = new ArrayList<Word>();
        words.add(new Word("bgl"));
        Search actualSearch = new Search(testPuzzle, words);
        assureWordsMatch(words, actualSearch.solvePuzzle());
    }

    @Test
    public void whenPuzzleNeedsSolvingSearchCanFindAndReturnRightDiagonalMatches() {
        List<Word> words = new ArrayList<Word>();
        Word word = new Word("hkn");
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(3,1));
        coordinates.add(new Coordinate(2,2));
        coordinates.add(new Coordinate(1,3));
        words.add(word);

        Puzzle testPuzzle = new Puzzle("a b c d  e f g h  i j k l  m n o p");
        words = new ArrayList<Word>();
        Word testWord = new Word("hkn");
        words.add(testWord);

        Search actualSearch = new Search(testPuzzle, words);
        List<Word> solved = actualSearch.solvePuzzle();
        assertEquals(1, solved.size());
        assureWordsMatch(words, actualSearch.solvePuzzle());
    }

    @Test
    public void whenPuzzleNeedsSolvingSearchCanFindAndReturnBackwardsMatches() {
        List<Word> words = new ArrayList<Word>();
        Word word = new Word("nkh");
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(1,3));
        coordinates.add(new Coordinate(2,2));
        coordinates.add(new Coordinate(3,1));
        words.add(word);

        Puzzle testPuzzle = new Puzzle("a b c d  e f g h  i j k l  m n o p");
        words = new ArrayList<Word>();
        Word testWord = new Word("nkh");
        words.add(testWord);

        Search actualSearch = new Search(testPuzzle, words);
        List<Word> solved = actualSearch.solvePuzzle();
        assertEquals(1, solved.size());
        assertEquals("nkh: (1,3),(2,2),(3,1)", solved.get(0).format());
    }
}