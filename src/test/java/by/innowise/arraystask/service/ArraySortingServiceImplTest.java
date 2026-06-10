package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.service.impl.ArraySortingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortingServiceImplTest {
    private static final int[] UNSORTED_ARRAY = {1, 9, 5, 8, 4, 6, 2, 7, 3};
    private static final int[] SORTED_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int[] EMPTY_ARRAY = {};
    private static final ArraySortingService SERVICE = new ArraySortingServiceImpl();;

    @BeforeEach
    void setUp() {
    }

    @Test
    void bubbleSortShouldSortArrayInAscendingOrder() throws ArrayTaskException {
        // given
        CustomIntegerArray array = new CustomIntegerArray(UNSORTED_ARRAY);
        // when
        SERVICE.bubbleSort(array);
        // then
        assertArrayEquals(SORTED_ARRAY, array.getArray());
    }

    @Test
    void insertionSortShouldSortArrayInAscendingOrder() throws ArrayTaskException {
        // given
        CustomIntegerArray array = new CustomIntegerArray(UNSORTED_ARRAY);
        // when
        SERVICE.insertionSort(array);
        // then
        assertArrayEquals(SORTED_ARRAY, array.getArray());
    }

    @Test
    void bubbleSortShouldThrowExceptionForNullArray()  {
        // when + then
        assertThrows(ArrayTaskException.class, () -> SERVICE.bubbleSort(null));
    }

    @Test
    void insertionSortShouldThrowExceptionForNullArray()  {
        // when + then
        assertThrows(ArrayTaskException.class, () -> SERVICE.insertionSort(null));
    }

    @Test
    void bubbleSortShouldNotFailForEmptyArray() throws Exception {
        // given
        CustomIntegerArray array = new CustomIntegerArray(EMPTY_ARRAY);
        // when
        SERVICE.bubbleSort(array);
        // then
        assertArrayEquals(EMPTY_ARRAY, array.getArray());
    }

    @Test
    void insertionSortShouldNotFailForEmptyArray() throws Exception {
        // given
        CustomIntegerArray array = new CustomIntegerArray(EMPTY_ARRAY);
        // when
        SERVICE.insertionSort(array);
        // then
        assertArrayEquals(EMPTY_ARRAY, array.getArray());
    }

    @AfterEach
    void tearDown() {
    }
}