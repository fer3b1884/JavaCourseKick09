package by.shved.arraytask.service;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.exception.ArrayTaskException;
import by.shved.arraytask.service.impl.ArraySortingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortingServiceImplTest {
    private static final int[] unsortedArray = {1, 9, 5, 8, 4, 6, 2, 7, 3};
    private static final int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int[] emptyArray = {};
    private static final ArraySortingService service = new ArraySortingServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @Test
    void bubbleSortShouldSortArrayInAscendingOrder() throws ArrayTaskException {
        // given
        CustomIntegerArray array = new CustomIntegerArray(unsortedArray);
        // when
        service.bubbleSort(array);
        // then
        assertArrayEquals(sortedArray, array.getArray());
    }

    @Test
    void insertionSortShouldSortArrayInAscendingOrder() throws ArrayTaskException {
        // given
        CustomIntegerArray array = new CustomIntegerArray(unsortedArray);
        // when
        service.insertionSort(array);
        // then
        assertArrayEquals(sortedArray, array.getArray());
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

    @Test
    void bubbleSortShouldNotFailForEmptyArray() throws Exception {
        // given
        CustomIntegerArray array = new CustomIntegerArray(emptyArray);
        // when
        service.bubbleSort(array);
        // then
        assertArrayEquals(emptyArray, array.getArray());
    }

    @Test
    void insertionSortShouldNotFailForEmptyArray() throws Exception {
        // given
        CustomIntegerArray array = new CustomIntegerArray(emptyArray);
        // when
        service.insertionSort(array);
        // then
        assertArrayEquals(emptyArray, array.getArray());
    }

    @AfterEach
    void tearDown() {
    }
}