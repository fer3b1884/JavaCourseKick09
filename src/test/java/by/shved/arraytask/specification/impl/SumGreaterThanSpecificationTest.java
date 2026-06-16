package by.shved.arraytask.specification.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.specification.Specification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumGreaterThanSpecificationTest {
    private static final CustomIntegerArray specifiedArray = new CustomIntegerArray(new int[]{4, 5, 6});
    private static final CustomIntegerArray unspecifiedArray = new CustomIntegerArray(new int[]{1, 2, 3});
    private static final Specification specification = new SumGreaterThanSpecification(10);

    @BeforeEach
    void setUp() {
    }

    @Test
    void specifyShouldReturnTrueWhenSumGreaterThanValue() {
        // when
        boolean actual = specification.specify(specifiedArray);
        // then
        assertTrue(actual);
    }

    @Test
    void specifyShouldReturnFalseWhenSumLessThanValue() {
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