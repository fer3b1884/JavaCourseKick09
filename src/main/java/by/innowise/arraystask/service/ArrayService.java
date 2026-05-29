package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomArray;

import java.util.Optional;

public class ArrayService {
    public Optional<Integer> findMin(CustomArray customArray) {
        int[] integerArray = customArray.getArray();

        int minElement = integerArray[0];

        for (int element : integerArray) {
            if (element < minElement){
                minElement = element;
            }
        }
        return Optional.of(minElement);
    }

    public Optional<Integer> findMax(CustomArray customArray) {
        int[] integerArray = customArray.getArray();

        int maxElement = integerArray[0];

        for (int element : integerArray) {
            if (element > maxElement){
                maxElement = element;
            }
        }
        return Optional.of(maxElement);
    }

    public Optional<Integer> calculateSum(CustomArray customArray) {
        int[] integerArray = customArray.getArray();

        int sum = 0;

        for (int element : integerArray) {
            sum += element;
        }
        return Optional.of(sum);
    }

    public Optional<Double> calculateAverage(CustomArray customArray) {
        int[] integerArray = customArray.getArray();

        Optional<Integer> optionalSum = calculateSum(customArray);

        double average = (double) optionalSum.get() / integerArray.length;
        return Optional.of(average);
    }
}
