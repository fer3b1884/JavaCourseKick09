package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.impl.ArrayCalculationServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceImplTest {
    private static final CustomIntegerArray CUSTOM_INTEGER_ARRAY = new CustomIntegerArray(new int[] { 1, 2, 5, 2 });
    private ArrayCalculationService service;

    @BeforeEach
    void setUp() {
        service = new ArrayCalculationServiceImpl();
    }

    @Test
    void findMinShouldReturnMinimumElement() {
        // given
        int expected = 1;
        // when
        Optional<Integer> result = service.findMin(CUSTOM_INTEGER_ARRAY);
        // then
        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
    }

    @Test
    void findMaxShouldReturnMaximumElement() {
        // given
        int expected = 5;
        // when
        Optional<Integer> result = service.findMax(CUSTOM_INTEGER_ARRAY);
        // then
        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
    }

    @Test
    void calculateSumShouldReturnSumOfElements() {
        // given
        int expected = 10;
        // when
        Optional<Integer> result = service.calculateSum(CUSTOM_INTEGER_ARRAY);
        // then
        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
    }

    @Test
    void calculateAverageShouldReturnAverageValue() {
        // given
        double expected = 2.5;
        // when
        Optional<Double> result = service.calculateAverage(CUSTOM_INTEGER_ARRAY);
        // then
        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
    }

    @AfterEach
    void tearDown() {
    }
}