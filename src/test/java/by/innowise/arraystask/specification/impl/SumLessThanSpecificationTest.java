package by.innowise.arraystask.specification.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.specification.Specification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumLessThanSpecificationTest {
    private static final CustomIntegerArray specifiedArray = new CustomIntegerArray(new int[]{1, 2, 3});
    private static final CustomIntegerArray unspecifiedArray = new CustomIntegerArray(new int[]{4, 5, 6});
    private static final Specification specification = new SumLessThanSpecification(10);

    @BeforeEach
    void setUp() {
    }

    @Test
    void specifyShouldReturnTrueWhenSumLessThanValue() {
        // when
        boolean actual = specification.specify(specifiedArray);
        // then
        assertTrue(actual);
    }

    @Test
    void specifyShouldReturnFalseWhenSumGreaterThanValue() {
        // when
        boolean actual = specification.specify(unspecifiedArray);
        // then
        assertFalse(actual);
    }

    @Test
    void specifyShouldReturnFalseWhenArrayIsNull() {
        // when
        boolean actual = specification.specify(null);
        // then
        assertFalse(actual);
    }

    @AfterEach
    void tearDown() {
    }
}