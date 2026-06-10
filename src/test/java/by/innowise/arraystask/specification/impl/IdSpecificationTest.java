package by.innowise.arraystask.specification.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.specification.Specification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationTest {
    private static final CustomIntegerArray SPECIFIED_ARRAY = new CustomIntegerArray(new int[]{1, 2, 3});
    private static final CustomIntegerArray UNSPECIFIED_ARRAY = new CustomIntegerArray(new int[]{4, 5, 6});
    private static final Specification SPECIFICATION = new IdSpecification(SPECIFIED_ARRAY.getId());

    @BeforeEach
    void setUp() {
    }

    @Test
    void specifyShouldReturnTrueWhenIdMatches() {
        // when
        boolean actual = SPECIFICATION.specify(SPECIFIED_ARRAY);
        // then
        assertTrue(actual);
    }

    @Test
    void specifyShouldReturnFalseWhenIdDoesNotMatch() {
        // when
        boolean actual = SPECIFICATION.specify(UNSPECIFIED_ARRAY);
        // then
        assertFalse(actual);
    }

    @Test
    void specifyShouldReturnFalseWhenArrayIsNull() {
        // when
        boolean actual = SPECIFICATION.specify(null);
        // then
        assertFalse(actual);
    }

    @AfterEach
    void tearDown() {
    }
}