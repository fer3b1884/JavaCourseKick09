package by.innowise.arraystask.comparator;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.repository.ArrayRepository;
import by.innowise.arraystask.repository.impl.ArrayRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayComparatorTest {
    private static final int[] array1 = new int[]{5, 6, 7};
    private static final int[] array2 = new int[]{1};
    private static final int[] array3 = new int[]{3, 4};
    private static final ArrayRepository repository = ArrayRepositoryImpl.getInstance();
    private CustomIntegerArray customArray1;
    private CustomIntegerArray customArray2;
    private CustomIntegerArray customArray3;

    @BeforeEach
    void setUp() throws ArrayTaskException {
        for (CustomIntegerArray array : repository.getAll()) {
            repository.removeCustomIntegerArray(array);
        }
        customArray1 = new CustomIntegerArray(array1);
        customArray2 = new CustomIntegerArray(array2);
        customArray3 = new CustomIntegerArray(array3);
    }

    @Test
    void sortShouldOrderArraysById() throws ArrayTaskException {
        // given
        long firstExpectedId = customArray1.getId();
        long secondExpectedId = customArray2.getId();
        long thirdExpectedId = customArray3.getId();
        repository.addCustomIntegerArray(customArray1);
        repository.addCustomIntegerArray(customArray2);
        repository.addCustomIntegerArray(customArray3);
        // when
        repository.sort(new ArrayIdComparator());
        // then
        List<CustomIntegerArray> actual = repository.getAll();
        assertAll(
                () -> assertEquals(firstExpectedId, actual.get(0).getId()),
                () -> assertEquals(secondExpectedId, actual.get(1).getId()),
                () -> assertEquals(thirdExpectedId, actual.get(2).getId())
        );
    }

    @Test
    void sortShouldOrderArraysByLength() throws ArrayTaskException {
        // given
        int firstArrayLength = array1.length;
        int secondArrayLength = array2.length;
        int thirdArrayLength = array3.length;
        repository.addCustomIntegerArray(customArray1);
        repository.addCustomIntegerArray(customArray2);
        repository.addCustomIntegerArray(customArray3);
        // when
        repository.sort(new ArrayLengthComparator());
        // then
        List<CustomIntegerArray> actual = repository.getAll();
        assertAll(
                () -> assertEquals(secondArrayLength, actual.get(0).length()),
                () -> assertEquals(thirdArrayLength, actual.get(1).length()),
                () -> assertEquals(firstArrayLength, actual.get(2).length())
        );
    }

    @Test
    void sortShouldOrderArraysByFirstElement() throws ArrayTaskException {
        // given
        int firstArrayElement = array1[0];
        int secondArrayElement = array2[0];
        int thirdArrayElement = array3[0];
        repository.addCustomIntegerArray(customArray1);
        repository.addCustomIntegerArray(customArray2);
        repository.addCustomIntegerArray(customArray3);
        // when
        repository.sort(new ArrayFirstElementComparator());
        // then
        List<CustomIntegerArray> actual = repository.getAll();
        assertAll(
                () -> assertEquals(secondArrayElement, actual.get(0).getArray()[0]),
                () -> assertEquals(thirdArrayElement, actual.get(1).getArray()[0]),
                () -> assertEquals(firstArrayElement, actual.get(2).getArray()[0])
        );
    }

    @AfterEach
    void tearDown() {
    }
}