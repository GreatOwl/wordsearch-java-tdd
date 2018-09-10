package com.pillar.wordsearch;

import java.util.ArrayList;
import java.util.List;

import com.pillar.wordsearch.Coordinate;

public class StringVector {

    public String value;
    public Coordinate start;
    public Coordinate end;

    public StringVector() {
        value = "";
        start = new Coordinate(0, 0);
        end = start;
    }

    public void append(String value, Coordinate start, Coordinate end) {
        this.value = this.value + value;
    }

    public String toString() {
        return value;
    }
}