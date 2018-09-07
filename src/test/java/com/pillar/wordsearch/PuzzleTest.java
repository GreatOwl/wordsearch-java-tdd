import com.pillar.wordsearch.Puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

public class PuzzleTest {
    
    Puzzle puzzle;
    String puzzleString;
    List<String> words;

    @Before
    public void setUp() {
        puzzleString = "Q Z V L E X W M R D A Z Y I J Z T E N H D T A C D W R G S I E O H Y P M J C W O D N R K F H N T O O R L R P G K X E R U G E N E R A T O R M N S V G C W G U I T A W O I A P L J Q R E C W T S T N C V Y H D K V R E G X B A G C D L A Y G K M P K E U Y T S E O O W J Z P X Z U R N Z A L C T O M G G W I M X U Z H C O R R L I M H X C W G E L X P O D G J C H L V O R H P R A B S B T F T E G B O F N Y E P B Q L H U F P C O T O D E P V D U B V G S A C L D K";
        words = Arrays.asList("APOCOLYPSE", "CAT", "CATASTROPHE", "DOG", "DOGMA", "GENERATOR", "RANDOM", "THE", "WORDS");
        puzzle = new Puzzle(puzzleString, words);
    }

    @Test
    public void whenPuzzleGivenInConstructionGetPuzzleReturnsSamePuzzle() {
        assertEquals(puzzleString, puzzle.getPuzzle());
    }
}