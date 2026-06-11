package by.innowise.arraystask.parser;

import by.innowise.arraystask.exception.ArrayTaskException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserTest {
    private static final ArrayParser parser = new ArrayParser();

    @BeforeEach
    void setUp() {
    }

    @Test
    void parseStringShouldParseSpaceSeparatedNumbers() throws ArrayTaskException {
        // given
        int[] expected = new int[] {1, 5, -2, 6, 7};
        // when
        int[] actual = parser.parseString("1 5 -2 6 7");
        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseStringShouldReturnEmptyArrayForEmptyString() throws ArrayTaskException {
        // given
        int[] expected = new int[]{};
        // when
        int[] actual = parser.parseString("");
        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseStringShouldParseSemicolonSeparatedNumbers() throws ArrayTaskException {
        // given
        int[] expected = new int[] {10, 2, 8, -7, 3};
        // when
        int[] actual = parser.parseString("10; 2; 8; -7; 3");
        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseStringShouldParseCommaSeparatedNumbers() throws ArrayTaskException {
        // given
        int[] expected = new int[] {5, 4, 3, 2, 1};
        // when
        int[] actual = parser.parseString("5, 4, 3, 2, 1");
        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseStringShouldParseNumbersWithAppendedSemicolon() throws ArrayTaskException {
        // given
        int[] expected = new int[] {-8, 678, -3, 2};
        // when
        int[] actual = parser.parseString("-8; 678; -3; 2;");
        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseStringShouldThrowExceptionForInvalidData() {
        // given

        // when + then
        assertThrows(ArrayTaskException.class, () -> parser.parseString("6@ 2d 34..dsw 34 3."));
    }

    @AfterEach
    void tearDown() {
    }
}