import com.pillar.wordsearch.Puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

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

    @Test
    public void whenAllRowsNeededGetAllRows() {
        assertEquals(Arrays.asList("abc", "bcd", "cde"), puzzle.getRows());
    }

    @Test
    public void whenAllColumnsNeededGetAllColumns() {
        assertEquals(Arrays.asList("abc", "bcd", "cde"), puzzle.getColumns());
    }

    @Test
    public void whenFirstLeftDiagIsNeededReturnFirstLeftDiag() {
        assertEquals("bd", puzzle.getLeftDiag(0));
    }

    @Test
    public void whenSecondLeftDiagIsNeededReturnSecondtLeftDiag() {
        assertEquals("ace", puzzle.getLeftDiag(1));
    }

    @Test
    public void whenDiagGreaterThanGridRequestedReturnEmptyString() {
        assertEquals("", puzzle.getLeftDiag(3));
    }

    @Test
    public void whenFirstRightDiagIsNeededReturnFirstRightDiag() {
        assertEquals("bb", puzzle.getRightDiag(0));
    }

    @Test
    public void whenSecondRightDiagIsNeededReturnSecondRightDiag() {
        assertEquals("ccc", puzzle.getRightDiag(1));
    }
}