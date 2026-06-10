package by.innowise.arraystask.service.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.service.ArraySortingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArraySortingServiceImpl implements ArraySortingService {
    private static final Logger LOGGER = LogManager.getLogger(ArraySortingServiceImpl.class);

    @Override
    public void bubbleSort(CustomIntegerArray customIntegerArray) throws ArrayTaskException {
        LOGGER.info("Bubble sort started");
        if (customIntegerArray == null) {
            LOGGER.error("Bubble sort failed: array reference is null");
            throw new ArrayTaskException("The passed CustomIntegerArray object reference is null");
        }
        int[] elements = customIntegerArray.getArray();
        int length = elements.length;
        if (length == 0) {
            LOGGER.warn("Bubble sort failed: array is empty, nothing to sort");
            return;
        }
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
        customIntegerArray.setArray(elements);
        LOGGER.info("Bubble sort finished");
    }

    @Override
    public void insertionSort(CustomIntegerArray customIntegerArray) throws ArrayTaskException {
        LOGGER.info("Insertion sort started");
        if (customIntegerArray == null) {
            LOGGER.error("Insertion sort failed: array reference is null");
            throw new ArrayTaskException("The passed CustomIntegerArray object reference is null");
        }
        int[] elements = customIntegerArray.getArray();
        int length = elements.length;
        if (length == 0) {
            LOGGER.warn("Insertion sort failed: array is empty, nothing to sort");
            return;
        }
        for (int i = 1; i < length; ++i) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
        customIntegerArray.setArray(elements);
        LOGGER.info("Insertion sort finished");
    }
}
