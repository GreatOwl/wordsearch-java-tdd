import com.pillar.wordsearch.StringVector;
import com.pillar.wordsearch.Coordinate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;
import com.pillar.wordsearch.Word;

public class WordTest {

    @Test
    public void whenWordStringCanBeRetrieved() {
        String wordString = "word";
        Word word = new Word(wordString);
        assertEquals(wordString, word.toString());
    }

    @Test
    public void whenAnyWordStringIsGivenItCanBeRetrieved() {
        String wordString = "balloon";
        Word word = new Word(wordString);
        assertEquals(wordString, word.toString());
    }

    public void whenWordNeedsToBeReversedItIs() {
        String wordString = "balloon";
        String reversed = "noollab";
        Word word = new Word(wordString);
        assertEquals(reversed, word.getReverseString());
    }

    public void whenWordIsFoundCoordinatesCanBeAttachedAndRetreived() {
        String wordString = "balloon";
        Word word = new Word(wordString);
        List<Coordinate> wordCoordinates = new ArrayList<Coordinate>();
        wordCoordinates.add(new Coordinate(1,2));
        wordCoordinates.add(new Coordinate(1,3));
        wordCoordinates.add(new Coordinate(1,4));
        wordCoordinates.add(new Coordinate(1,5));
        wordCoordinates.add(new Coordinate(1,6));
        wordCoordinates.add(new Coordinate(1,7));
        wordCoordinates.add(new Coordinate(1,8));
        
        word.attach(wordCoordinates);
        assertEquals(wordCoordinates, word.getCoordinates());
    }

}