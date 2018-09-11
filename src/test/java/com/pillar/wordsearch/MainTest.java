package com.pillar.wordsearch;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.pillar.wordsearch.Word;
import com.pillar.wordsearch.Main;

public class MainTest {

    private Main main;
    private String testContents;
    private String filename;
    @Before
    public void setup() {
        filename = "puzzle1.txt";
        main = new Main();
        String testPath = System.getProperty("user.dir") + "/puzzles/" + filename;
        try {
            testContents = new String(Files.readAllBytes(Paths.get(testPath)));
        } catch (IOException e) {
            testContents = "";
        };
    }

    @Test
    public void whenFileIsProvidedFileIsReadIntoMemory() {
        assertEquals(testContents, main.getFileContents(filename));        
    }

    @Test
    public void whenFileReadLinesAreSplitIntoAList() {
        String[] testList = {
            "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA",
            "U,M,K,H,U,L,K,I,N,V,J,O,C,W,E",
            "L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G",
            "H,S,U,P,J,P,R,J,D,H,S,B,X,T,G",
            "B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E",
            "A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D",
            "S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F",
            "B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z",
            "O,K,R,I,K,A,M,M,R,M,F,B,A,P,P",
            "N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S",
            "E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K",
            "S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D",
            "T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K",
            "O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H",
            "W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S",
            "K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B"
        };

        assertEquals(testList, main.splitIntoLines(testContents));
    }

    @Test
    public void whenGivenWordListStringCanConvertToListOfWords() {
        String testString = "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA";
        List<Word> testList = new ArrayList<Word>();
        testList.add(new Word("BONES"));
        testList.add(new Word("KHAN"));
        testList.add(new Word("KIRK"));
        testList.add(new Word("SCOTTY"));
        testList.add(new Word("SPOCK"));
        testList.add(new Word("SULU"));
        testList.add(new Word("UHURA"));

        List<Word> actual = main.splitIntoWords(testString);
        int pos = 0;
        for (Word testWord : testList) {
            assertEquals(testWord.toString(), actual.get(pos).toString());
            pos = pos + 1;
        }
    }

    @Test
    public void whenRawPuzzleGivenPuzzleObjectReturned() {
        String expectedCompressed = "UMKHULKINVJOCWELLSHKZZWZCGJUYGHSUPJPRJDHSBXTGBRJSOEQETIKKGLEAYOAGCIRDQHRTCDSCOTTYKZREPPXPFBLQSLNEEEVULFMZOKRIKAMMRMFBAPPNUIIYHQMEMQRYFSEYZYGKQJPCQWYAKSJFZMQIBDBEMKWDTGLBHCBECHTOYIKOJYEULNCCLYBZUHWZMISUKURBIDUXSKYLBQQPMDFCKEAB";
        String[] testList = {
            "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA",
            "U,M,K,H,U,L,K,I,N,V,J,O,C,W,E",
            "L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G",
            "H,S,U,P,J,P,R,J,D,H,S,B,X,T,G",
            "B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E",
            "A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D",
            "S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F",
            "B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z",
            "O,K,R,I,K,A,M,M,R,M,F,B,A,P,P",
            "N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S",
            "E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K",
            "S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D",
            "T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K",
            "O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H",
            "W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S",
            "K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B"
        };

        Puzzle puzzle = main.buildPuzzle(testList);
        assertEquals(expectedCompressed, puzzle.compressPuzzle().toString());
    }

    @Test
    public void whenRawPuzzleGivenPuzzleCanBeSolved() {
        List<String> testSolved = new ArrayList<String>();
        testSolved.add("SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)");
        testSolved.add("KIRK: (4,7),(3,7),(2,7),(1,7)");
        testSolved.add("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)");
        testSolved.add("KHAN: (5,9),(5,8),(5,7),(5,6)");
        testSolved.add("SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)");
        testSolved.add("SULU: (3,3),(2,2),(1,1),(0,0)");
        testSolved.add("UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)");

        List<String> solved = main.solvePuzzle(testContents);
        int pos = 0;
        for (String testWord : testSolved) {
            assertEquals(testWord, solved.get(pos));
            pos = pos + 1;
        }
    }
}