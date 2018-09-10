import com.pillar.wordsearch.Coordinate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

public class CoordinateTest {

    @Test
    public void whenCoordinatesConstructedXCanBeRetreived() {
        int x = 12;
        int y = 22;
        Coordinate coord = new Coordinate(x, y);
        assertEquals(x, coord.getX());
    }

    @Test
    public void whenCoordinatesConstructedYCanBeRetreived() {
        int x = 12;
        int y = 22;
        Coordinate coord = new Coordinate(x, y);
        assertEquals(y, coord.getY());
    }
}