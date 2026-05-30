package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.impl.ArrayCalculationServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceTest {
    private static final CustomIntegerArray ARRAY = new CustomIntegerArray(new int[] { 1, 2, 5, 2 });
    private ArrayCalculationService service;

    @BeforeEach
    void setUp() {
        service = new ArrayCalculationServiceImpl();
    }

    @Test
    void findMin() {
        Optional<Integer> result = service.findMin(ARRAY);

        int actual = result.get();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void findMax() {
        Optional<Integer> result = service.findMax(ARRAY);

        int actual = result.get();
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void calculateSum() {
        Optional<Integer> result = service.calculateSum(ARRAY);

        int actual = result.get();
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    void calculateAverage() {
        Optional<Double> result = service.calculateAverage(ARRAY);

        double actual = result.get();
        double expected = 2.5;

        assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
    }
}