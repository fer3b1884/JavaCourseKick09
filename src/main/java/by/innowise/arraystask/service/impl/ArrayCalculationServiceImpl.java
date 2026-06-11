package by.innowise.arraystask.service.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.ArrayCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    private static final Logger logger = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public Optional<Integer> findMin(CustomIntegerArray customIntegerArray) {
        logger.info("Searching minimum element");
        if (customIntegerArray == null) {
            logger.warn("Cannot find minimum element: customIntegerArray is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            logger.warn("Cannot find minimum element: array is empty");
            return Optional.empty();
        }
        int minElement = array[0];
        for (int element : array) {
            if (element < minElement){
                minElement = element;
            }
        }
        logger.info("Minimum element found: {}", minElement);
        return Optional.of(minElement);
    }

    @Override
    public Optional<Integer> findMax(CustomIntegerArray customIntegerArray) {
        logger.info("Searching maximum element");
        if (customIntegerArray == null) {
            logger.warn("Cannot find maximum element: customIntegerArray is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            logger.warn("Cannot find maximum element: array is empty");
            return Optional.empty();
        }
        int maxElement = array[0];
        for (int element : array) {
            if (element > maxElement){
                maxElement = element;
            }
        }
        logger.info("Maximum element found: {}", maxElement);
        return Optional.of(maxElement);
    }

    @Override
    public Optional<Integer> calculateSum(CustomIntegerArray customIntegerArray) {
        logger.info("Calculating sum");
        if (customIntegerArray == null) {
            logger.warn("Cannot calculate sum of element: customIntegerArray is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            logger.warn("Cannot calculate sum of element: array is empty");
            return Optional.empty();
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        logger.info("Sum calculated: {}", sum);
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverage(CustomIntegerArray customIntegerArray) {
        logger.info("Calculating average value");
        if (customIntegerArray == null) {
            logger.warn("Cannot calculate average of element: customIntegerArray is null");
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            logger.warn("Cannot calculate average of element: array is empty");
            return Optional.empty();
        }
        Optional<Integer> optionalSum = calculateSum(customIntegerArray);
        double average = (double) optionalSum.get() / array.length;
        logger.info("Average value calculated: {}", average);
        return Optional.of(average);
    }
}
