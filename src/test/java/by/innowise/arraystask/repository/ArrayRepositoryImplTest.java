package by.innowise.arraystask.repository;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.repository.impl.ArrayRepositoryImpl;
import by.innowise.arraystask.specification.Specification;
import by.innowise.arraystask.specification.impl.IdSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRepositoryImplTest {
    private static final int[] ARRAY_1 = new int[]{1, 2, 3};
    private static final int[] ARRAY_2 = new int[]{10, 20, 30};
    private static final ArrayRepository REPOSITORY = ArrayRepositoryImpl.getInstance();;
    private CustomIntegerArray customArray1;
    private CustomIntegerArray customArray2;

    @BeforeEach
    void setUp() throws ArrayTaskException {
        // cleaning the repository before each test
        for (CustomIntegerArray array : REPOSITORY.getAll()) {
            REPOSITORY.removeCustomIntegerArray(array);
        }
        customArray1 = new CustomIntegerArray(ARRAY_1);
        customArray2 = new CustomIntegerArray(ARRAY_2);
    }

    @Test
    void getInstanceShouldReturnSameInstance() {
        // when
        ArrayRepository anotherRepository = ArrayRepositoryImpl.getInstance();
        // then
        assertSame(REPOSITORY, anotherRepository);
    }

    @Test
    void addCustomIntegerArrayShouldAddArray() throws ArrayTaskException {
        // given
        int expectedSize = 1;
        // when
        REPOSITORY.addCustomIntegerArray(customArray1);
        List<CustomIntegerArray> actual = REPOSITORY.getAll();
        // then
        assertEquals(expectedSize, actual.size());
    }

    @Test
    void addCustomIntegerArrayShouldThrowExceptionWhenArrayIsNull() {
        // when + then
        assertThrows(ArrayTaskException.class, () -> REPOSITORY.addCustomIntegerArray(null));
    }

    @Test
    void removeCustomIntegerArrayShouldRemoveArray() throws ArrayTaskException {
        // given
        REPOSITORY.addCustomIntegerArray(customArray1);
        // when
        REPOSITORY.removeCustomIntegerArray(customArray1);
        // then
        List<CustomIntegerArray> actual = REPOSITORY.getAll();
        assertTrue(actual.isEmpty());
    }

    @Test
    void removeCustomIntegerArrayShouldThrowExceptionWhenArrayIsNull(){
        // when + then
        assertThrows(ArrayTaskException.class, () -> REPOSITORY.removeCustomIntegerArray(null));
    }

    @Test
    void queryShouldReturnArrayWithMatchingId() throws ArrayTaskException {
        // given
        int expectedSize = 1;
        REPOSITORY.addCustomIntegerArray(customArray1);
        REPOSITORY.addCustomIntegerArray(customArray2);
        long targetId = customArray1.getId();
        Specification specification = new IdSpecification(targetId);
        // when
        List<CustomIntegerArray> actual = REPOSITORY.query(specification);
        // then
        assertAll(
                () -> assertEquals(expectedSize, actual.size()),
                () -> assertEquals(targetId, actual.getFirst().getId())
        );
    }

    @Test
    void queryShouldReturnArraysWithMatchingId() throws ArrayTaskException {
        // given
        int expectedSize = 1;
        REPOSITORY.addCustomIntegerArray(customArray1);
        REPOSITORY.addCustomIntegerArray(customArray2);
        long targetId = customArray1.getId();
        Specification specification = new IdSpecification(targetId);
        // when
        List<CustomIntegerArray> actual = REPOSITORY.query(specification);
        // then
        assertAll(
                () -> assertEquals(expectedSize, actual.size()),
                () -> assertEquals(targetId, actual.getFirst().getId())
        );
    }

    @Test
    void queryShouldReturnEmptyListWhenIdDoesNotMatch() throws ArrayTaskException {
        // given
        REPOSITORY.addCustomIntegerArray(customArray1);
        REPOSITORY.addCustomIntegerArray(customArray2);
        long nonexistentId = 100;
        Specification specification = new IdSpecification(nonexistentId);
        // when
        List<CustomIntegerArray> actual = REPOSITORY.query(specification);
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void queryShouldThrowExceptionWhenSpecificationIsNull() {
        // when + then
        assertThrows(ArrayTaskException.class, () -> REPOSITORY.query(null));
    }

    @Test
    void getAllShouldReturnAllStoredArrays() throws ArrayTaskException {
        // given
        int expectedSize = 2;
        REPOSITORY.addCustomIntegerArray(customArray1);
        REPOSITORY.addCustomIntegerArray(customArray2);
        // when
        List<CustomIntegerArray> actual = REPOSITORY.getAll();
        // then
        assertAll(
                () -> assertEquals(expectedSize, actual.size()),
                () -> assertEquals(customArray1, actual.getFirst()),
                () -> assertEquals(customArray2, actual.getLast())
        );
    }

    @AfterEach
    void tearDown() {
    }
}