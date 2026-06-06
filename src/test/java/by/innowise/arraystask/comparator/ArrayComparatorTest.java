package by.innowise.arraystask.comparator;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.repository.ArrayRepository;
import by.innowise.arraystask.repository.impl.ArrayRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayComparatorTest {
    private static final CustomIntegerArray ARRAY_1 = new CustomIntegerArray(3L, new int[]{5, 6, 7});
    private static final CustomIntegerArray ARRAY_2 = new CustomIntegerArray(1L, new int[]{1});
    private static final CustomIntegerArray ARRAY_3 = new CustomIntegerArray(2L, new int[]{3, 4});
    private ArrayRepository repository;

    @BeforeEach
    void setUp() throws ArrayTaskException {
        repository = ArrayRepositoryImpl.getInstance();
        // cleaning the repository before each test
        for (CustomIntegerArray array : repository.getAll()) {
            repository.removeCustomIntegerArray(array);
        }
    }

    @Test
    void sortShouldOrderArraysById() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1);
        repository.addCustomIntegerArray(ARRAY_2);
        repository.addCustomIntegerArray(ARRAY_3);
        // when
        repository.sort(new ArrayIdComparator());
        List<CustomIntegerArray> actual = repository.getAll();
        CustomIntegerArray firstArray = actual.get(0);
        CustomIntegerArray secondArray = actual.get(1);
        CustomIntegerArray thirdArray = actual.get(2);
        // then
        assertEquals(1L, firstArray.getId());
        assertEquals(2L, secondArray.getId());
        assertEquals(3L, thirdArray.getId());
    }

    @Test
    void sortShouldOrderArraysByLength() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1);
        repository.addCustomIntegerArray(ARRAY_2);
        repository.addCustomIntegerArray(ARRAY_3);
        // when
        repository.sort(new ArrayLengthComparator());
        List<CustomIntegerArray> actual = repository.getAll();
        CustomIntegerArray firstArray = actual.get(0);
        CustomIntegerArray secondArray = actual.get(1);
        CustomIntegerArray thirdArray = actual.get(2);
        // then
        assertEquals(1, firstArray.lengthOfArray());
        assertEquals(2, secondArray.lengthOfArray());
        assertEquals(3, thirdArray.lengthOfArray());
    }

    @Test
    void sortShouldOrderArraysByFirstElement() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1); // 5
        repository.addCustomIntegerArray(ARRAY_2); // 1
        repository.addCustomIntegerArray(ARRAY_3); // 3
        // when
        repository.sort(new ArrayFirstElementComparator());
        List<CustomIntegerArray> actual = repository.getAll();
        CustomIntegerArray firstArray = actual.get(0);
        CustomIntegerArray secondArray = actual.get(1);
        CustomIntegerArray thirdArray = actual.get(2);
        // then
        assertEquals(1, firstArray.getArray()[0]);
        assertEquals(3, secondArray.getArray()[0]);
        assertEquals(5, thirdArray.getArray()[0]);
    }

    @AfterEach
    void tearDown() {
    }
}