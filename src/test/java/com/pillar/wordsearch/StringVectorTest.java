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
    public void whenCoordinatesOfStringAreRequestedAllCoordinatesAreReturnedAsList() {
        Coordinate start = new Coordinate(0, 0);
        StringVector stringVector = new StringVector(start);
        String testString = "testString";
        Coordinate end = new Coordinate(9, 0);
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
        List <Coordinate> realCoordinates = stringVector.getCoordinates();
        int testPos = 0;
        for (Coordinate testCoordinate : coordinates) {
            Coordinate realCoordinate = realCoordinates.get(testPos);
            assertEquals(testCoordinate.getX(), realCoordinate.getX());
            assertEquals(testCoordinate.getY(), realCoordinate.getY());
            testPos = testPos + 1;
        }
    }
}