package by.innowise.arraystask.parser;

import by.innowise.arraystask.exception.ArrayTaskException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserTest {
    private ArrayParser parser;

    @BeforeEach
    void setUp() {
        parser = new ArrayParser();
    }

    @Test
    void parseString1() throws ArrayTaskException {
        int[] expected = new int[] {10, 2, 8, 7, 3};
        int[] actual = parser.parseString("10; 2; 8; 7; 3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseString2() throws ArrayTaskException {
        int[] expected = new int[]{};
        int[] actual = parser.parseString("");
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseString3() throws ArrayTaskException {
        int[] expected = new int[] {1, 2, 3};
        int[] actual = parser.parseString("1 - 2 - 3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseString4() throws ArrayTaskException {
        int[] expected = new int[] {-1, 2, -3};
        int[] actual = parser.parseString("-1 2 -3");
        assertArrayEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
    }
}