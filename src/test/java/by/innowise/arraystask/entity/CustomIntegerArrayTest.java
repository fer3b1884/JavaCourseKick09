package by.innowise.arraystask.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntegerArrayTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void constructorShouldCreateCopyOfInputArray() {
        // given
        int[] source = {1, 2, 3};
        // when
        CustomIntegerArray array = new CustomIntegerArray(source);
        source[0] = 100;
        // then
        assertArrayEquals(new int[]{1, 2, 3}, array.getArray());
    }

    @Test
    void getArrayShouldReturnCopyOfInternalArray() {
        // given
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        // when
        int[] result = array.getArray();
        result[0] = 100;
        // then
        assertArrayEquals(new int[]{1, 2, 3}, array.getArray());
    }

    @Test
    void constructorShouldCreateEmptyArrayForNullInput() {
        // when
        CustomIntegerArray array = new CustomIntegerArray(null);
        // then
        assertArrayEquals(new int[0], array.getArray());
    }

    @Test
    void setArrayShouldCreateEmptyArrayForNullInput() {
        // given
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        // when
        array.setArray(null);
        // then
        assertArrayEquals(new int[0], array.getArray());
    }

    @AfterEach
    void tearDown() {
    }
}