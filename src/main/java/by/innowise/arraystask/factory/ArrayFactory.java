package by.innowise.arraystask.factory;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;

public interface ArrayFactory {
    CustomIntegerArray createArray(int[] elements) throws ArrayTaskException;
}
