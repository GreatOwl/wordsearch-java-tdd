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

}