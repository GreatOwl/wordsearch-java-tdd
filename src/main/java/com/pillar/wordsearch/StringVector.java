package com.pillar.wordsearch;

import java.util.ArrayList;
import java.util.List;

import com.pillar.wordsearch.Coordinate;

public class StringVector {

    public String value;
    public Coordinate start;
    public Coordinate end;

    public StringVector(Coordinate start) {
        value = "";
        this.start = start;
        this.end = start;
    }

    public void append(String value, Coordinate end) {
        this.value = this.value + value;
        this.end = end;
    }

    public Coordinate getEndCoordinate() {
        return end;
    }

    public String toString() {
        return value;
    }
}