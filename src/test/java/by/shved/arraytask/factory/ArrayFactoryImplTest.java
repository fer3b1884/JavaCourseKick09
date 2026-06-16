package by.shved.arraytask.factory;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.exception.ArrayTaskException;
import by.shved.arraytask.factory.impl.ArrayFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryImplTest {
    private static final ArrayFactory factory = new ArrayFactoryImpl();

    @BeforeEach
    void setUp() {
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