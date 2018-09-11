package com.pillar.wordsearch;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.pillar.wordsearch.Word;

public class Main {
    public static void main(String[] args) {
        List<String> solved = solvePuzzle(getFileContents(args[0]));
        for (String result : solved) {
            System.out.println(result);
        }
    }

    public static String getFileContents(String filename) {
        String filePath = System.getProperty("user.dir") + "/puzzles/" + filename;
        String data;
        try {
            data = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            data = e.getMessage();
        };
        return data;
    }

    public static String[] splitIntoLines(String data) {
        return data.split("\\s+");
    }

    public static List<Word> splitIntoWords(String parsableWords) {
        String[] wordSplit = parsableWords.split("\\,");
        List<Word> words = new ArrayList<Word>();
        for (String wordString : wordSplit) {
            Word word = new Word(wordString);
            words.add(word);
        }
        return words;
    }

    public static Puzzle buildPuzzle(String[] rawPuzzle) {
        String puzzleString = "";
        for (int line = 1; line < rawPuzzle.length; line = line + 1) {
            puzzleString = puzzleString + rawPuzzle[line];
        }
        return new Puzzle(puzzleString);
    }

    public static List<String> solvePuzzle(String rawPuzzle) {
        String[] lines = splitIntoLines(rawPuzzle);
        List<Word> words = splitIntoWords(lines[0]);
        Puzzle puzzle = buildPuzzle(lines);
        Search search = new Search(puzzle, words);
        List<Word> solved = search.solvePuzzle();
        List<String> solvedFormatted = new ArrayList<String>();
        for (Word currenWord : solved) {
            solvedFormatted.add(currenWord.format());
        }
        return solvedFormatted;
    }
}
    