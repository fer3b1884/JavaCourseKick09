package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.impl.ArraySortingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortingServiceTest {
    private static final CustomIntegerArray ARRAY = new CustomIntegerArray(new int[] { 1, 9, 5, 8, 4, 6, 2, 7, 3 });
    ArraySortingService service;

    @BeforeEach
    void setUp() {
        service = new ArraySortingServiceImpl();
    }

    @Test
    void bubbleSort() {
        service.bubbleSort(ARRAY);

        int[] actual = ARRAY.getArray();
        int[] excepted = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        assertArrayEquals(actual, excepted);
    }

    @Test
    void insertionSort() {
        service.bubbleSort(ARRAY);

        int[] actual = ARRAY.getArray();
        int[] excepted = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        assertArrayEquals(actual, excepted);
    }

    @AfterEach
    void tearDown() {
    }
}