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
    private static final CustomIntegerArray ARRAY_1 = new CustomIntegerArray(1L, new int[]{1, 2, 3});
    private static final CustomIntegerArray ARRAY_2 = new CustomIntegerArray(2L, new int[]{10, 20, 30});
    private static final CustomIntegerArray ARRAY_3 = new CustomIntegerArray(2L, new int[]{4, 5, 6});
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
    void getInstanceShouldReturnSameInstance() {
        // when
        ArrayRepository anotherRepository = ArrayRepositoryImpl.getInstance();
        // then
        assertSame(repository, anotherRepository);
    }

    @Test
    void addCustomIntegerArrayShouldAddArray() throws ArrayTaskException {
        // when
        repository.addCustomIntegerArray(ARRAY_1);
        List<CustomIntegerArray> actual = repository.getAll();
        // then
        assertEquals(1, actual.size());
    }

    @Test
    void addCustomIntegerArrayShouldThrowExceptionWhenArrayIsNull() {
        // when + then
        assertThrows(ArrayTaskException.class, () -> repository.addCustomIntegerArray(null));
    }

    @Test
    void removeCustomIntegerArrayShouldRemoveArray() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1);
        // when
        repository.removeCustomIntegerArray(ARRAY_1);
        List<CustomIntegerArray> actual = repository.getAll();
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    void removeCustomIntegerArrayShouldThrowExceptionWhenArrayIsNull(){
        // when + then
        assertThrows(ArrayTaskException.class, () -> repository.removeCustomIntegerArray(null));
    }

    @Test
    void queryShouldReturnArrayWithMatchingId() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1);
        repository.addCustomIntegerArray(ARRAY_2);
        Specification specification = new IdSpecification(1L);
        // when
        List<CustomIntegerArray> actual = repository.query(specification);
        CustomIntegerArray foundArray = actual.getFirst();
        // then
        assertEquals(1, actual.size());
        assertEquals(1L, foundArray.getId());
    }

    @Test
    void queryShouldReturnArraysWithMatchingId() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1);
        repository.addCustomIntegerArray(ARRAY_2);
        repository.addCustomIntegerArray(ARRAY_3);
        Specification specification = new IdSpecification(2L);
        // when
        List<CustomIntegerArray> actual = repository.query(specification);
        CustomIntegerArray firstArray = actual.getFirst();
        CustomIntegerArray secondArray = actual.getFirst();
        // then
        assertEquals(2, actual.size());
        assertEquals(2L, firstArray.getId());
        assertEquals(2L, secondArray.getId());
    }

    @Test
    void queryShouldReturnEmptyList() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1);
        repository.addCustomIntegerArray(ARRAY_2);
        repository.addCustomIntegerArray(ARRAY_3);
        Specification specification = new IdSpecification(4L);
        // when
        List<CustomIntegerArray> actual = repository.query(specification);
        // then
        assertEquals(0, actual.size());
    }

    @Test
    void queryShouldThrowExceptionWhenSpecificationIsNull() {
        // when + then
        assertThrows(ArrayTaskException.class, () -> repository.query(null));
    }

    @Test
    void getAll() throws ArrayTaskException {
        // given
        repository.addCustomIntegerArray(ARRAY_1);
        repository.addCustomIntegerArray(ARRAY_2);
        // when
        List<CustomIntegerArray> actual = repository.getAll();
        CustomIntegerArray firstArray = actual.getFirst();
        CustomIntegerArray secondArray = actual.getLast();
        // then
        assertEquals(2, actual.size());
        assertEquals(1L, firstArray.getId());
        assertEquals(2L, secondArray.getId());
    }

    @AfterEach
    void tearDown() {
    }
}