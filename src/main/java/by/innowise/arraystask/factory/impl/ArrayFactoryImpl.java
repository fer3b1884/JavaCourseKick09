package by.innowise.arraystask.factory.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.factory.ArrayFactory;

public class ArrayFactoryImpl implements ArrayFactory {
    @Override
    public CustomIntegerArray createArray(int[] elements) throws ArrayTaskException {
        if(elements == null) {
            throw new ArrayTaskException("Target elements array cannot be null");
        }
        CustomIntegerArray arrayInstance = new CustomIntegerArray(elements);
        return arrayInstance;
    }
}
