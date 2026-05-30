package by.innowise.arraystask.service.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.ArrayCalculationService;

import java.util.Optional;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    @Override
    public Optional<Integer> findMin(CustomIntegerArray customIntegerArray) {
        int[] integerArray = customIntegerArray.getArray();

        int minElement = integerArray[0];

        for (int element : integerArray) {
            if (element < minElement){
                minElement = element;
            }
        }
        return Optional.of(minElement);
    }

    @Override
    public Optional<Integer> findMax(CustomIntegerArray customIntegerArray) {
        int[] integerArray = customIntegerArray.getArray();

        int maxElement = integerArray[0];

        for (int element : integerArray) {
            if (element > maxElement){
                maxElement = element;
            }
        }
        return Optional.of(maxElement);
    }

    @Override
    public Optional<Integer> calculateSum(CustomIntegerArray customIntegerArray) {
        int[] integerArray = customIntegerArray.getArray();

        int sum = 0;

        for (int element : integerArray) {
            sum += element;
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverage(CustomIntegerArray customIntegerArray) {
        int[] integerArray = customIntegerArray.getArray();

        Optional<Integer> optionalSum = calculateSum(customIntegerArray);

        double average = (double) optionalSum.get() / integerArray.length;
        return Optional.of(average);
    }
}
