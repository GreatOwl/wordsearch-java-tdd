package com.pillar.wordsearch;

import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class StringVectorTest {

    @Test
    public void whenStringAddedItCanBeRetrieved() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        Coordinate end = new Coordinate(10, 0);
        String testString = "testString";
        stringVector.append(testString, end);
        assertEquals(testString, stringVector.toString());
    }

    @Test
    public void whenStartCoordinateGivenItAddedToEnd() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        Coordinate end = new Coordinate(10, 0);
        String testString = "testString";
        stringVector.append(testString, end);
        assertEquals(end.getY(), stringVector.getEndCoordinate().getY());
        assertEquals(end.getX(), stringVector.getEndCoordinate().getX());
    }

    @Test
    public void whenCloneIsNeededCloneIsReturned() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        Coordinate end = new Coordinate(10, 0);
        String testString = "testString";
        stringVector.append(testString, end);

        StringVector clonedVector = stringVector.clone();
        assertEquals(stringVector.toString(), clonedVector.toString());
    }

    @Test
    public void whenYouNeedToKnowTheLengthOfTheCurrentStringItIsReturned() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        Coordinate end = new Coordinate(10, 0);
        String testString = "testString";
        stringVector.append(testString, end);
        assertEquals(testString.length(), stringVector.length());
    }

    @Test
    public void whenVectorGivenAndEmptyStartStringWhenStringVectorAppendedUseNewVectorsStartPoint() {
        StringVector stringVector = new StringVector();
        String testString = "testString";
        Coordinate start = new Coordinate(0, 0);
        StringVector addVector = new StringVector(start);
        Coordinate end = new Coordinate(10, 0);
        addVector.append(testString, end);
        stringVector.append(addVector);
        assertEquals(start.getY(), stringVector.getStartCoordinate().getY());
        assertEquals(start.getX(), stringVector.getStartCoordinate().getX());
    }

    @Test
    public void whenCoordinatesOfStringAreRequestedAllCoordinatesAreReturnedAsListForXAxis() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(9, 0);
        stringVector.append(testString, end);
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
        List<Coordinate> realCoordinates = stringVector.getCoordinates();
        assertEquals(10, realCoordinates.size());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }

    @Test
    public void whenCoordinatesOfStringAreRequestedAllCoordinatesAreReturnedAsListForYAxis() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(0, 9);
        stringVector.append(testString, end);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(0, 1));
        coordinates.add(new Coordinate(0, 2));
        coordinates.add(new Coordinate(0, 3));
        coordinates.add(new Coordinate(0, 4));
        coordinates.add(new Coordinate(0, 5));
        coordinates.add(new Coordinate(0, 6));
        coordinates.add(new Coordinate(0, 7));
        coordinates.add(new Coordinate(0, 8));
        coordinates.add(new Coordinate(0, 9));
        List<Coordinate> realCoordinates = stringVector.getCoordinates();
        assertEquals(10, coordinates.size());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }

    @Test
    public void whenCoordinatesOfStringAreRequestedAllCoordinatesAreReturnedAsListForLeftDiag() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(9, 9);
        stringVector.append(testString, end);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(1, 1));
        coordinates.add(new Coordinate(2, 2));
        coordinates.add(new Coordinate(3, 3));
        coordinates.add(new Coordinate(4, 4));
        coordinates.add(new Coordinate(5, 5));
        coordinates.add(new Coordinate(6, 6));
        coordinates.add(new Coordinate(7, 7));
        coordinates.add(new Coordinate(8, 8));
        coordinates.add(new Coordinate(9, 9));
        List<Coordinate> realCoordinates = stringVector.getCoordinates();
        assertEquals(10, coordinates.size());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }

    @Test
    public void whenCoordinatesOfStringAreRequestedAllCoordinatesAreReturnedAsListForRightDiag() {
        Coordinate start = new Coordinate(0, 9);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(9, 0);
        stringVector.append(testString, end);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0, 9));
        coordinates.add(new Coordinate(1, 8));
        coordinates.add(new Coordinate(2, 7));
        coordinates.add(new Coordinate(3, 6));
        coordinates.add(new Coordinate(4, 5));
        coordinates.add(new Coordinate(5, 4));
        coordinates.add(new Coordinate(6, 3));
        coordinates.add(new Coordinate(7, 2));
        coordinates.add(new Coordinate(8, 1));
        coordinates.add(new Coordinate(9, 0));
        List<Coordinate> realCoordinates = stringVector.getCoordinates();
        assertEquals(10, coordinates.size());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }

    @Test
    public void whenWhenSubstringRequestedReturnsStringVectorSubstringString() {
        Coordinate start = new Coordinate(0, 9);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(9, 0);
        stringVector.append(testString, end);
        StringVector subString = stringVector.findSubstring("String");
        assertEquals("String", subString.toString());
        List<Coordinate> realCoordinates = subString.getCoordinates();
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(4, 5));
        coordinates.add(new Coordinate(5, 4));
        coordinates.add(new Coordinate(6, 3));
        coordinates.add(new Coordinate(7, 2));
        coordinates.add(new Coordinate(8, 1));
        coordinates.add(new Coordinate(9, 0));
        assertEquals(6, coordinates.size());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }

    @Test
    public void whenWhenSubstringRequestedReturnsStringVectorSubstringTest() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(0, 9);
        stringVector.append(testString, end);
        StringVector subString = stringVector.findSubstring("test");
        assertEquals("test", subString.toString());
        List<Coordinate> realCoordinates = subString.getCoordinates();
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(0, 1));
        coordinates.add(new Coordinate(0, 2));
        coordinates.add(new Coordinate(0, 3));
        assertEquals(4, coordinates.size());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }

    public void whenWhenAppendingSubstringItCanBeDoneByJoiningAnotherStringVector() {

        String testTestString = "test";
        StringVector testVector = new StringVector(new Coordinate(0, 0));
        testVector.append(testTestString, new Coordinate(0, 3));
        
        String stringTestString = "String";
        StringVector stringVector = new StringVector(new Coordinate(0,4));
        stringVector.append(stringTestString, new Coordinate(0, 9));
        
        testVector.append(stringVector);

        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(0, 1));
        coordinates.add(new Coordinate(0, 2));
        coordinates.add(new Coordinate(0, 3));
        coordinates.add(new Coordinate(0, 4));
        coordinates.add(new Coordinate(0, 5));
        coordinates.add(new Coordinate(0, 6));
        coordinates.add(new Coordinate(0, 7));
        coordinates.add(new Coordinate(0, 8));
        coordinates.add(new Coordinate(0, 9));
        List<Coordinate> realCoordinates = testVector.getCoordinates();
        assertEquals(10, coordinates.size());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }

    @Test
    public void whenSubstringRangeRequestedReturnAppropriateStringVector() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(0, 9);
        stringVector.append(testString, end);
        StringVector substring = stringVector.substring(3, 8);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(0, 3));
        coordinates.add(new Coordinate(0, 4));
        coordinates.add(new Coordinate(0, 5));
        coordinates.add(new Coordinate(0, 6));
        coordinates.add(new Coordinate(0, 7));
        List<Coordinate> realCoordinates = substring.getCoordinates();
        assertEquals(5, realCoordinates.size());
        assertEquals("tStri", substring.toString());
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }
}