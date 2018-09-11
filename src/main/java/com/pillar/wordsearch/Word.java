package com.pillar.wordsearch;

import java.util.List;

import com.pillar.wordsearch.Coordinate;

public class Word {

    private String wordString;
    private List<Coordinate> coordinates;
    public Word(String wordString) {
        this.wordString = wordString;
    }

    public String toString() {
        return wordString;
    }

    public String format() {
        String formatted = wordString + ":";
        String glue = " ";
        for (Coordinate coordinate : getCoordinates()) {
            formatted = formatted + glue + coordinate.toString();
            glue = ",";
        }
        return formatted;
    }

    public String getReverseString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(wordString).reverse().toString();
    }

    public void attach(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}