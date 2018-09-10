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
}