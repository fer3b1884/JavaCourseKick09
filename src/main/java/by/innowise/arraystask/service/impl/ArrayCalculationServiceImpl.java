package by.innowise.arraystask.service.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.ArrayCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public Optional<Integer> findMin(CustomIntegerArray customIntegerArray) {
        LOGGER.info("Searching minimum element");
        if (customIntegerArray == null) {
            LOGGER.warn("Cannot find minimum element: array is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            LOGGER.warn("Cannot find minimum element: array is empty");
            return Optional.empty();
        }
        int minElement = array[0];
        for (int element : array) {
            if (element < minElement){
                minElement = element;
            }
        }
        LOGGER.info("Minimum element found: {}", minElement);
        return Optional.of(minElement);
    }

    @Override
    public Optional<Integer> findMax(CustomIntegerArray customIntegerArray) {
        LOGGER.info("Searching maximum element");
        if (customIntegerArray == null) {
            LOGGER.warn("Cannot find maximum element: array is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            LOGGER.warn("Cannot find maximum element: array is empty");
            return Optional.empty();
        }
        int maxElement = array[0];
        for (int element : array) {
            if (element > maxElement){
                maxElement = element;
            }
        }
        LOGGER.info("Maximum element found: {}", maxElement);
        return Optional.of(maxElement);
    }

    @Override
    public Optional<Integer> calculateSum(CustomIntegerArray customIntegerArray) {
        LOGGER.info("Calculating sum");
        if (customIntegerArray == null) {
            LOGGER.warn("Cannot calculate sum of element: array is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            LOGGER.warn("Cannot calculate sum of element: array is empty");
            return Optional.empty();
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        LOGGER.info("Sum calculated: {}", sum);
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverage(CustomIntegerArray customIntegerArray) {
        LOGGER.info("Calculating average value");
        if (customIntegerArray == null) {
            LOGGER.warn("Cannot calculate average of element: array is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            LOGGER.warn("Cannot calculate average of element: array is empty");
            return Optional.empty();
        }
        Optional<Integer> optionalSum = calculateSum(customIntegerArray);
        double average = (double) optionalSum.get() / array.length;
        LOGGER.info("Average value calculated: {}", average);
        return Optional.of(average);
    }
}
