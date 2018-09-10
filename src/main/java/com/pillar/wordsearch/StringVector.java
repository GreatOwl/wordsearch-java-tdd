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

    public List<Coordinate> getCoordinates() {

        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(1, 0));
        coordinates.add(new Coordinate(2, 0));
        coordinates.add(new Coordinate(3, 0));
        coordinates.add(new Coordinate(4, 0));
        coordinates.add(new Coordinate(5, 0));
        coordinates.add(new Coordinate(6, 0));
        coordinates.add(new Coordinate(7, 0));
        coordinates.add(new Coordinate(8, 0));
        coordinates.add(new Coordinate(9, 0));
        return coordinates;
    }

    public String toString() {
        return value;
    }
}