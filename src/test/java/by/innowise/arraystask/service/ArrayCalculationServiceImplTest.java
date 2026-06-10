package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.service.impl.ArrayCalculationServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceImplTest {
    private static final int[] ARRAY_VALUES = new int[] { 1, 2, 5, 2 };
    private static final ArrayCalculationService SERVICE = new ArrayCalculationServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @Test
    void findMinShouldReturnMinimumElement() throws ArrayTaskException {
        // given
        CustomIntegerArray customIntegerArray = new CustomIntegerArray(ARRAY_VALUES);
        int expected = 1;
        // when
        Optional<Integer> result = SERVICE.findMin(customIntegerArray);
        // then
        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(expected, result.get())
        );
    }

    @Test
    void findMaxShouldReturnMaximumElement() throws ArrayTaskException {
        // given
        CustomIntegerArray customIntegerArray = new CustomIntegerArray(ARRAY_VALUES);
        int expected = 5;
        // when
        Optional<Integer> result = SERVICE.findMax(customIntegerArray);
        // then
        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(expected, result.get())
        );
    }

    @Test
    void calculateSumShouldReturnSumOfElements() throws ArrayTaskException {
        // given
        CustomIntegerArray customIntegerArray = new CustomIntegerArray(ARRAY_VALUES);
        int expected = 10;
        // when
        Optional<Integer> result = SERVICE.calculateSum(customIntegerArray);
        // then
        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(expected, result.get())
        );
    }

    @Test
    void calculateAverageShouldReturnAverageValue() throws ArrayTaskException {
        // given
        CustomIntegerArray customIntegerArray = new CustomIntegerArray(ARRAY_VALUES);
        double expected = 2.5;
        // when
        Optional<Double> result = SERVICE.calculateAverage(customIntegerArray);
        // then
        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(expected, result.get())
        );
    }

    @AfterEach
    void tearDown() {
    }
}