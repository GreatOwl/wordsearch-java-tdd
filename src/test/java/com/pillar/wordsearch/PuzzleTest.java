import com.pillar.wordsearch.Puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;
import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;

public class PuzzleTest {
    
    String puzzleString;
    Puzzle puzzle;

    @Before
    public void setUp() {
        puzzleString = "a b c b c d c d e";
        puzzle = new Puzzle(puzzleString);
    }

    @Test
    public void whenPuzzleGivenInConstructionGetPuzzleReturnsSamePuzzle() {
        assertEquals(puzzleString, puzzle.getPuzzle());
    }

    @Test
    public void whenNumberOfRowsAreRequestedReturns3() {
        assertEquals(3, puzzle.getRowCount());
    }

    @Test
    public void whenPuzzleProvidedPuzzleGetsCompressedForSolving() {
        String compressedPuzzle = "abcbcdcde";
        assertEquals(compressedPuzzle, puzzle.compressPuzzle());
    }

    @Test
    public void whenPuzzleProvidedPuzzleGetsCompressedForSolvingForAnyPuzzle() {
        String compressedPuzzle = "abcbcdcde";
        assertEquals(compressedPuzzle, puzzle.compressPuzzle());
    }

    @Test
    public void whenNumberOfRowsAreRequestedReturnsTheRowsForTheGivenPuzzle() {
        assertEquals(3, puzzle.getRowCount());
    }

    @Test
    public void whenFirstRowIsNeededReturnsFirstRow() {
        assertEquals("abc", puzzle.getRow(0).toString());
    }

    @Test
    public void whenSecondRowIsNeededReturnsSecondRow() {
        assertEquals("bcd", puzzle.getRow(1).toString());
    }

    @Test
    public void whenThirdRowIsNeededReturnsThirdRow() {
        assertEquals("cde", puzzle.getRow(2).toString());
    }

    @Test
    public void whenFirstColumnIsNeededReturnsFirstColumn() {
        assertEquals("abc", puzzle.getColumn(0).toString());
    }

    @Test
    public void whenSecondColumnIsNeededReturnsSecondColumn() {
        assertEquals("bcd", puzzle.getColumn(1).toString());
    }

    private void assureStringVectorList(List<StringVector> test, List<StringVector> real) {
        int pos = 0;
        for (StringVector testVector : test) {
            StringVector realVector  = real.get(pos);
            assertEquals(testVector.toString(), realVector.toString());
            pos = pos + 1;
        }
    }

    @Test
    public void whenAllRowsNeededGetAllRows() {
        List<StringVector> testList = new ArrayList<StringVector>();
        testList.add(new StringVector("abc", new Coordinate(0,0), new Coordinate(2, 0)));
        testList.add(new StringVector("bcd", new Coordinate(0,1), new Coordinate(2, 1)));
        testList.add(new StringVector("cde", new Coordinate(0,2), new Coordinate(2, 2)));
        assureStringVectorList(testList, puzzle.getRows());
    }

    @Test
    public void whenAllColumnsNeededGetAllColumns() {
        List<StringVector> testList = new ArrayList<StringVector>();
        testList.add(new StringVector("abc", new Coordinate(0,0), new Coordinate(0, 2)));
        testList.add(new StringVector("bcd", new Coordinate(1,0), new Coordinate(1, 2)));
        testList.add(new StringVector("cde", new Coordinate(2,0), new Coordinate(2, 2)));
        assureStringVectorList(testList, puzzle.getColumns());
    }

    @Test
    public void whenFirstLeftDiagIsNeededReturnFirstLeftDiag() {
        assertEquals("bd", puzzle.getLeftDiag(0).toString());
    }

    @Test
    public void whenSecondLeftDiagIsNeededReturnSecondtLeftDiag() {
        assertEquals("ace", puzzle.getLeftDiag(1).toString());
    }

    @Test
    public void whenDiagGreaterThanGridRequestedReturnEmptyString() {
        assertEquals("", puzzle.getLeftDiag(3).toString());
    }

    @Test
    public void whenFirstRightDiagIsNeededReturnFirstRightDiag() {
        assertEquals("bb", puzzle.getRightDiag(0).toString());
    }

    @Test
    public void whenSecondRightDiagIsNeededReturnSecondRightDiag() {
        assertEquals("ccc", puzzle.getRightDiag(1).toString());
    }
}