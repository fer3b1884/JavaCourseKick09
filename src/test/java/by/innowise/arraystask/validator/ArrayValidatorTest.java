package by.innowise.arraystask.validator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorTest {
    private ArrayValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ArrayValidator();
    }

    @Test
    void isValidRow1() {
        boolean actual = validator.isValidRow("1 5 2 6 7");
        assertTrue(actual);
    }

    @Test
    void isValidRow2() {
        boolean actual = validator.isValidRow("1 - 2 - 3");
        assertTrue(actual);
    }

    @Test
    void isValidRow3() {
        boolean actual = validator.isValidRow("10; 2; 8; 7; 3");
        assertTrue(actual);
    }

    @Test
    void isValidRow4() {
        boolean actual = validator.isValidRow("-8 678 -3 2");
        assertTrue(actual);
    }

    @Test
    void isValidRow5() {
        boolean actual = validator.isValidRow("");
        assertTrue(actual);
    }

    @Test
    void isValidRow6() {
        boolean actual = validator.isValidRow("6 2d 34..dsw 34 3");
        assertFalse(actual);
    }

    @Test
    void isValidRow7() {
        boolean actual = validator.isValidRow("11- 2 - 42-");
        assertFalse(actual);
    }

    @Test
    void isValidRow8() {
        boolean actual = validator.isValidRow("89345 678_");
        assertFalse(actual);
    }

    @AfterEach
    void tearDown() {
    }
}