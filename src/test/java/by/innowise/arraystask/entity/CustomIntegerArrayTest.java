package by.innowise.arraystask.entity;

import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.observer.impl.CustomArrayObserver;
import by.innowise.arraystask.parameters.ArrayParameters;
import by.innowise.arraystask.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntegerArrayTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void constructorShouldGenerateUniqueIds() {
        // when
        CustomIntegerArray first = new CustomIntegerArray(new int[]{1});
        CustomIntegerArray second = new CustomIntegerArray(new int[]{2});
        // then
        assertNotEquals(first.getId(), second.getId());
    }

//    @Test
//    void constructorShouldThrowExceptionWhenInputArrayIsNull() {
//        // when + then
//        assertThrows(ArrayTaskException.class,
//                () -> new CustomIntegerArray(null));
//    }

    @Test
    void constructorShouldCreateEmptyArrayForNullInput() {
        // when
        int[] expected = new int[0];
        CustomIntegerArray array = new CustomIntegerArray(null);
        // then
        assertArrayEquals(expected, array.getArray());
    }

    @Test
    void constructorShouldCreateCopyOfInputArray() {
        // given
        int[] expected = new int[]{1, 2, 3};
        int[] source = {1, 2, 3};
        // when
        CustomIntegerArray array = new CustomIntegerArray(source);
        source[0] = 100;
        // then
        assertArrayEquals(expected, array.getArray());
    }

    @Test
    void getArrayShouldReturnCopyOfInternalArray() {
        // given
        int[] expected = new int[]{1, 2, 3};
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        // when
        int[] result = array.getArray();
        result[0] = 100;
        // then
        assertArrayEquals(expected, array.getArray());
    }

    @Test
    void setElementShouldChangeElement() throws ArrayTaskException {
        // given
        int[] expected = new int[]{1, 10, 3};
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        // when
        array.setElement(1, 10);
        // then
        assertArrayEquals(expected, array.getArray());
    }

    @Test
    void setElementShouldThrowExceptionForInvalidIndex() {
        // given
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        // when + then
        assertThrows(ArrayTaskException.class, () -> array.setElement(10, 5));
    }

    @Test
    void setElementShouldNotifyObserver() throws ArrayTaskException {
        // given
        Warehouse warehouse = Warehouse.getInstance();
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        array.attachObserver(new CustomArrayObserver());
        // when
        array.setElement(0, 100);
        // then
        ArrayParameters actual = warehouse.get(array.getId());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(2, actual.min()),
                () -> assertEquals(100, actual.max()),
                () -> assertEquals(105, actual.sum()),
                () -> assertEquals(35.0, actual.average())
        );
    }

    @AfterEach
    void tearDown() {
    }
}