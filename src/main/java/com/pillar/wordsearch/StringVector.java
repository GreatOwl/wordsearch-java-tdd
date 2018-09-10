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
        if (end.getY() == start.getY()) {
            for (int pos = 0; pos <= (end.getX() - start.getX()); pos = pos + 1) {
                coordinates.add(new Coordinate(start.getX() + pos, end.getY()));
            }
        } else if (end.getX() == start.getX()) {
            for (int pos = 0; pos <= (end.getY() - start.getY()); pos = pos + 1) {
                coordinates.add(new Coordinate(end.getX(), start.getY() + pos));
            }
        } else if (Math.abs(end.getX()) == Math.abs(end.getY())) {
            // y = mx + b;
            //b = mx - y;
            int slope = (end.getX() - start.getX())/(end.getY() - start.getY());
            int offset = slope * start.getX() - start.getY();
            for (int pos = start.getX(); pos <= end.getX(); pos = pos + 1) {
                int y = slope * pos + offset;
                coordinates.add(new Coordinate(pos, y));
            }
        }
        return coordinates;
    }

    public String toString() {
        return value;
    }
}