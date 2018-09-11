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
import com.pillar.wordsearch.Word;

public class SearchTest {

    @Test
    public void whenPuzzleRequestedPuzzleIsReturned() {
        Puzzle testPuzzle = new Puzzle("a b c d e f g h i j k l m n o p");
        Search actualSearch = new Search(testPuzzle);
        assertEquals(testPuzzle.compressPuzzle(), actualSearch.getPuzzle().compressPuzzle());
    }

    @Test
    public void whenPuzzleRequestedOriginalyGivenPuzzleIsReturned() {
        Puzzle testPuzzle = new Puzzle("a a a a b b b b c c c c d d d d");
        Search actualSearch = new Search(testPuzzle);
        assertEquals(testPuzzle.compressPuzzle(), actualSearch.getPuzzle().compressPuzzle());
    }

    private void assureWordsMatch(List<Word> test, List<Word> actual) {
        int pos = 0;
        for (Word word : test) {
            assertEquals(word.toString(), actual.get(pos).toString());
            pos = pos + 1;
        }
    }

    @Test
    public void whenWordsRequestedFromSearchWordsAreReturned() {
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("abcd"));
        words.add(new Word("aeil"));
        words.add(new Word("afkp"));
        words.add(new Word("mjhd"));
        Search actualSearch = new Search(words);
        assureWordsMatch(words, actualSearch.getWords());
    }

    @Test
    public void whenGivenWordsAreRequestedTheWordsAreReturned() {
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("abcd"));
        words.add(new Word("aeil"));
        words.add(new Word("afkp"));
        words.add(new Word("mjhd"));
        words.add(new Word("fgh"));
        Search actualSearch = new Search(words);
        assureWordsMatch(words, actualSearch.getWords());
    }
}