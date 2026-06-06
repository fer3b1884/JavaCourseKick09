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
    ArraySortingService service;

    @BeforeEach
    void setUp() {
        service = new ArraySortingServiceImpl();
    }

    @Test
    void bubbleSortShouldSortArrayInAscendingOrder() throws ArrayTaskException {
        // given
        CustomIntegerArray array = new CustomIntegerArray(UNSORTED_ARRAY);
        // when
        service.bubbleSort(array);
        // then
        assertArrayEquals(SORTED_ARRAY, array.getArray());
    }

    @Test
    void insertionSortShouldSortArrayInAscendingOrder() throws ArrayTaskException {
        // given
        CustomIntegerArray array = new CustomIntegerArray(UNSORTED_ARRAY);
        // when
        service.insertionSort(array);
        // then
        assertArrayEquals(SORTED_ARRAY, array.getArray());
    }

    @Test
    void bubbleSortShouldThrowExceptionForNullArray()  {
        // when + then
        assertThrows(ArrayTaskException.class, () -> service.bubbleSort(null));
    }

    @Test
    void insertionSortShouldThrowExceptionForNullArray()  {
        // when + then
        assertThrows(ArrayTaskException.class, () -> service.insertionSort(null));
    }

    @AfterEach
    void tearDown() {
    }
}