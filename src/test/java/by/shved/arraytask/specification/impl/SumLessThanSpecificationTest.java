package by.shved.arraytask.specification.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.specification.Specification;
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

    @AfterEach
    void tearDown() {
    }
}