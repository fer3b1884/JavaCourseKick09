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
    void createArrayShouldCreateEntityWithProvidedElements() throws ArrayTaskException {
        // given
        int[] expected = {5, 4, 3, 2, 1};
        // when
        CustomIntegerArray actual = factory.createArray(expected);
        // then
        assertArrayEquals(expected, actual.getArray());
    }

    @Test
    void createArrayShouldThrowExceptionForNullArray() {
        // then
        assertThrows(ArrayTaskException.class, () -> factory.createArray(null));
    }

    @AfterEach
    void tearDown() {
    }
}