import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
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
}