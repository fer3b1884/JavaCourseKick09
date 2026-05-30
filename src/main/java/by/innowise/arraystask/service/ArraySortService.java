package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;

import java.util.Optional;

public interface ArraySortService {
    void bubbleSort(CustomIntegerArray customIntegerArray);
    void insertionSort(CustomIntegerArray customIntegerArray);
}
