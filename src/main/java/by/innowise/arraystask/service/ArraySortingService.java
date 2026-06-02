package by.innowise.arraystask.service;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;

public interface ArraySortingService {
    void bubbleSort(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
    void insertionSort(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
}
