package by.innowise.arraystask.validator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorTest {
    private final static ArrayValidator validator = new ArrayValidator();;

    @BeforeEach
    void setUp() {
    }

    @Test
    void isValidRowShouldReturnTrueForSpaceSeparatedNumbers() {
        // when
        boolean actual = validator.isValidRow("1 5 -2 6 7");
        // then
        assertTrue(actual);
    }

    @Test
    void isValidRowShouldReturnTrueForSemicolonSeparatedNumbers() {
        // when
        boolean actual = validator.isValidRow("10; 2; 8; -7; 3");
        // then
        assertTrue(actual);
    }

    @Test
    void isValidRowShouldReturnTrueForCommaSeparatedNumbers() {
        // when
        boolean actual = validator.isValidRow("5, 4, 3, 2, 1");
        // then
        assertTrue(actual);
    }

    @Test
    void isValidRowShouldReturnTrueForNumbersWithAppendedSemicolon() {
        // when
        boolean actual = validator.isValidRow("-8; 678; -3; 2;");
        // then
        assertTrue(actual);
    }

    @Test
    void isValidRowShouldReturnTrueForEmptyString() {
        // when
        boolean actual = validator.isValidRow("");
        // then
        assertTrue(actual);
    }

    @Test
    void isValidRowShouldReturnFalseForInvalidCharacters() {
        // when
        boolean actual = validator.isValidRow("6@ 2d 34..dsw 34 3.");
        // then
        assertFalse(actual);
    }

    @Test
    void isValidRowShouldReturnFalseForNullInput() {
        // when
        boolean actual = validator.isValidRow(null);
        // then
        assertFalse(actual);
    }

    @AfterEach
    void tearDown() {
    }
}