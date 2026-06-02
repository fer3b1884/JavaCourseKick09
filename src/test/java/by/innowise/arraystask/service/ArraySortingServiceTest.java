package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.service.impl.ArraySortingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortingServiceTest {
    private static final CustomIntegerArray CUSTOM_INTEGER_ARRAY = new CustomIntegerArray(new int[] { 1, 9, 5, 8, 4, 6, 2, 7, 3 });
    private static final int[] EXCEPTED = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    ArraySortingService service;

    @BeforeEach
    void setUp() {
        service = new ArraySortingServiceImpl();
    }

    @Test
    void bubbleSort() throws ArrayTaskException {
        service.bubbleSort(CUSTOM_INTEGER_ARRAY);
        int[] actual = CUSTOM_INTEGER_ARRAY.getArray();
        assertArrayEquals(EXCEPTED, actual);
    }

    @Test
    void insertionSort() throws ArrayTaskException {
        service.insertionSort(CUSTOM_INTEGER_ARRAY);
        int[] actual = CUSTOM_INTEGER_ARRAY.getArray();
        assertArrayEquals(EXCEPTED, actual);
    }

    @AfterEach
    void tearDown() {
    }
}