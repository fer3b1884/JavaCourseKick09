package by.innowise.arraystask.service.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.ArrayCalculationService;

import java.util.Optional;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    @Override
    public Optional<Integer> findMin(CustomIntegerArray customIntegerArray) {
        if (customIntegerArray == null) {
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            return Optional.empty();
        }
        int minElement = array[0];
        for (int element : array) {
            if (element < minElement){
                minElement = element;
            }
        }
        return Optional.of(minElement);
    }

    @Override
    public Optional<Integer> findMax(CustomIntegerArray customIntegerArray) {
        if (customIntegerArray == null) {
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            return Optional.empty();
        }
        int maxElement = array[0];
        for (int element : array) {
            if (element > maxElement){
                maxElement = element;
            }
        }
        return Optional.of(maxElement);
    }

    @Override
    public Optional<Integer> calculateSum(CustomIntegerArray customIntegerArray) {
        if (customIntegerArray == null) {
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverage(CustomIntegerArray customIntegerArray) {
        if (customIntegerArray == null) {
            return Optional.empty();
        }
        int[] array = customIntegerArray.getArray();
        if (array.length == 0) {
            return Optional.empty();
        }
        Optional<Integer> optionalSum = calculateSum(customIntegerArray);
        double average = (double) optionalSum.get() / array.length;
        return Optional.of(average);
    }
}
