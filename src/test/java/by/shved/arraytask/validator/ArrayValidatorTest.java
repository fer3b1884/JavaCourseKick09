package by.shved.arraytask.validator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorTest {
    private static final ArrayValidator validator = new ArrayValidator();

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {
            "1 5 -2 6 7",
            "10; 2; 8; -7; 3",
            "5, 4, 3, 2, 1",
            "-8; 678; -3; 2;"
    })
    void isValidRowShouldReturnTrueForValidRows(String row) {
        // when
        boolean actual = validator.isValidRow(row);
        // then
        assertTrue(actual);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "6@ 2d 34..dsw 34 3."
    })
    void isValidRowShouldReturnFalseForInvalidRows(String row) {
        // when
        boolean actual = validator.isValidRow(row);
        // then
        assertFalse(actual);
    }

    @AfterEach
    void tearDown() {
    }
}