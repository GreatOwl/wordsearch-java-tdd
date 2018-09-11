import com.pillar.wordsearch.Search;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;
import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;
import com.pillar.wordsearch.Puzzle;

public class SearchTest {

    @Test
    public void whenPuzzleRequestedPuzzleIsReturned() {
        Puzzle testPuzzle = new Puzzle("a b c d e f g h i j k l m n o p");
        Search actualSearch = new Search(testPuzzle);
        assertEquals(testPuzzle.compressPuzzle(), actualSearch.getPuzzle().compressPuzzle());
    }
}