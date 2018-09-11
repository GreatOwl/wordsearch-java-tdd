package com.pillar.wordsearch;
import com.pillar.wordsearch.Coordinate;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

public class CoordinateTest {

    int x;;
    int y;
    Coordinate coord;

    @Before
    public void setup() {
        x = 12;
        y = 22;
        coord = new Coordinate(x, y);
    }

    @Test
    public void whenCoordinatesConstructedXCanBeRetreived() {
        assertEquals(x, coord.getX());
    }

    @Test
    public void whenCoordinatesConstructedYCanBeRetreived() {
        assertEquals(y, coord.getY());
    }
}