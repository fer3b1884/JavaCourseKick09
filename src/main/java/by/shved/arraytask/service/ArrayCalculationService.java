package by.shved.arraytask.service;

import by.shved.arraytask.entity.CustomIntegerArray;

import java.util.Optional;

public interface ArrayCalculationService {
    Optional<Integer> findMin(CustomIntegerArray customIntegerArray);
    Optional<Integer> findMax(CustomIntegerArray customIntegerArray);
    Optional<Integer> calculateSum(CustomIntegerArray customIntegerArray);
    Optional<Double> calculateAverage(CustomIntegerArray customIntegerArray);
}
