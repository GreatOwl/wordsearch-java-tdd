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
    }

    public StringVector(Coordinate start) {
        value = "";
        this.start = start;
        this.end = start;
    }

    public StringVector(String value, Coordinate start, Coordinate end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }

    public void append(StringVector vector) {
        if (start == null) {
            start = vector.getStartCoordinate();
        }
        this.value = this.value + vector.toString();
        this.end = vector.getEndCoordinate();
    }

    public void append(String value, Coordinate point) {
        if (start == null) {
            this.start = point;
        }
        this.value = this.value + value;
        this.end = point;
    }

    public Coordinate getEndCoordinate() {
        return end;
    }

    public Coordinate getStartCoordinate() {
        return start;
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
        } else if (end.getX() == end.getY() || start.getX() + start.getY() == end.getX() + end.getY()) {
            // y = mx + b;
            //b = mx - y;
            int slope = (end.getX() - start.getX())/(end.getY() - start.getY());
            int offset = slope * start.getX() - start.getY();
            for (int pos = start.getX(); pos <= end.getX(); pos = pos + 1) {
                int y = slope * pos - offset;
                coordinates.add(new Coordinate(pos, y));
            }
        }
        return coordinates;
    }

    public StringVector findSubstring(String search) {
        List<Coordinate> currentCoordinates = getCoordinates();
        int startPos = value.indexOf(search);
        int endPos = startPos + search.length() - 1;
        if (startPos >= 0) {
            StringVector subString = new StringVector(currentCoordinates.get(startPos));
            subString.append(search, currentCoordinates.get(endPos));
            return subString;
        }
        return new StringVector();
    }

    public StringVector substring(int start, int end) {
        List<Coordinate> currentCoordinates = getCoordinates();
        StringVector substring = new StringVector(
            value.substring(start, end), 
            currentCoordinates.get(start), 
            currentCoordinates.get(end - 1)
        );
        return substring;
    }

    public String toString() {
        return value;
    }

    public int length() {
        return value.length();
    }

    public StringVector clone() {
        StringVector cloneVector = new StringVector(getStartCoordinate());
        cloneVector.append(value, getEndCoordinate());
        return cloneVector;
    }
}