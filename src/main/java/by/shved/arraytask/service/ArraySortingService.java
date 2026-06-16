package by.shved.arraytask.service;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.exception.ArrayTaskException;

public interface ArraySortingService {
    void bubbleSort(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
    void insertionSort(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
}
