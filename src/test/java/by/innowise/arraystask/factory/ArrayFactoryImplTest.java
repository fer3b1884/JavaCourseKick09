package by.innowise.arraystask.factory;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.factory.impl.ArrayFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryImplTest {
    private static final ArrayFactory FACTORY = new ArrayFactoryImpl();

    @BeforeEach
    void setUp() {
    }

    @Test
    void createArrayShouldCreateEntityWithProvidedElements() throws ArrayTaskException {
        // given
        int[] expected = {5, 4, 3, 2, 1};
        // when
        CustomIntegerArray actual = FACTORY.createArray(expected);
        // then
        assertArrayEquals(expected, actual.getArray());
    }

    @Test
    void createArrayShouldThrowExceptionForNullArray() {
        // then
        assertThrows(ArrayTaskException.class, () -> FACTORY.createArray(null));
    }

    @AfterEach
    void tearDown() {
    }
}