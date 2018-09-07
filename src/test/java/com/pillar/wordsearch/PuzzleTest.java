import com.pillar.wordsearch.Puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

public class PuzzleTest {    
    
    String puzzleString;
    List<String> words;

    @Before
    public void setUp() {
        puzzleString = "Q Z V L E X W M R D A Z Y I J Z T E N H D T A C D W R G S I E O H Y P M J C W O D N R K F H N T O O R L R P G K X E R U G E N E R A T O R M N S V G C W G U I T A W O I A P L J Q R E C W T S T N C V Y H D K V R E G X B A G C D L A Y G K M P K E U Y T S E O O W J Z P X Z U R N Z A L C T O M G G W I M X U Z H C O R R L I M H X C W G E L X P O D G J C H L V O R H P R A B S B T F T E G B O F N Y E P B Q L H U F P C O T O D E P V D U B V G S A C L D K";
        words = Arrays.asList("APOCOLYPSE", "CAT", "CATASTROPHE", "DOG", "DOGMA", "GENERATOR", "RANDOM", "THE", "WORDS");
    }

    @Test
    public void whenPuzzleGivenInConstructionGetPuzzleReturnsSamePuzzle() {
        Puzzle puzzle = new Puzzle(puzzleString, words);
        assertEquals(puzzleString, puzzle.getPuzzle());
    }

    @Test
    public void whenWordsGivenInConstructionGetWordsReturnsSameWords() {
        Puzzle puzzle = new Puzzle(puzzleString, words);
        assertEquals(words, puzzle.getWords());
    }

    @Test
    public void whenNumberOfRowsAreRequestedReturns15() {
        Puzzle puzzle = new Puzzle(puzzleString, words);
        assertEquals(15, puzzle.getRowCount());
    }

    @Test
    public void whenPuzzleProvidedPuzzleGetsCompressedForSolving() {
        String compressedPuzzle = "QZVLEXWMRDAZYIJZTENHDTACDWRGSIEOHYPMJCWODNRKFHNTOORLRPGKXERUGENERATORMNSVGCWGUITAWOIAPLJQRECWTSTNCVYHDKVREGXBAGCDLAYGKMPKEUYTSEOOWJZPXZURNZALCTOMGGWIMXUZHCORRLIMHXCWGELXPODGJCHLVORHPRABSBTFTEGBOFNYEPBQLHUFPCOTODEPVDUBVGSACLDK";
        Puzzle puzzle = new Puzzle(puzzleString, words);
        assertEquals(compressedPuzzle, puzzle.compressPuzzle());
    }

    @Test
    public void whenPuzzleProvidedPuzzleGetsCompressedForSolvingForAnyPuzzle() {
        String compressedPuzzle = "atmo";
        Puzzle puzzle = new Puzzle("a t m o", Arrays.asList("at", "am", "to"));
        assertEquals(compressedPuzzle, puzzle.compressPuzzle());
    }

    @Test
    public void whenNumberOfRowsAreRequestedReturnsTheRowsForTheGivenPuzzle() {
        Puzzle puzzle = new Puzzle("a t m o", Arrays.asList("at", "am", "to"));
        assertEquals(2, puzzle.getRowCount());
    }

    @Test
    public void whenFirstRowIsNeededReturnsFirstRow() {
        Puzzle puzzle = new Puzzle(puzzleString, words);
        assertEquals("QZVLEXWMRDAZYIJ", puzzle.getRow());
    }

    @Test
    public void whenSecondRowIsNeededReturnsSecondRow() {
        Puzzle puzzle = new Puzzle(puzzleString, words);
        assertEquals("ZTENHDTACDWRGSI", puzzle.getRow(1));
    }

    @Test
    public void whenThirdRowIsNeededReturnsThirdRow() {
        Puzzle puzzle = new Puzzle(puzzleString, words);
        assertEquals("EOHYPMJCWODNRKF", puzzle.getRow(2));
    }
}