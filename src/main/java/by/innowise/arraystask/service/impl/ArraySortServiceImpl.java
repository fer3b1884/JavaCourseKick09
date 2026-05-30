package by.innowise.arraystask.service.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {
    public void bubbleSort(CustomIntegerArray customIntegerArray){
        int[] elements = customIntegerArray.getArray();
        int length = elements.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int current = elements[j];
                int next = elements[j + 1];
                if (current > next) {
                    elements[j] = next;
                    elements[j + 1] = current;
                }
            }
        }
    }

    public void insertionSort(CustomIntegerArray customIntegerArray){
        int[] elements = customIntegerArray.getArray();
        int length = elements.length;
        for (int i = 1; i < length; ++i) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }
}
