package by.innowise.arraystask.factory;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.factory.impl.ArrayFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryTest {
    private ArrayFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ArrayFactoryImpl();
    }

    @Test
    void createArray() throws ArrayTaskException {
        int[] inputElements = new int[] {5, 4, 3, 2, 1};
        CustomIntegerArray actualEntity = factory.createArray(inputElements);
        int[] expected = new int[] {5, 4, 3, 2, 1};
        int[] actual = actualEntity.getArray();
        assertArrayEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
    }
}