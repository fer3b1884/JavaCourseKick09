package by.innowise.arraystask.factory.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactoryImpl implements ArrayFactory {
    private static final Logger LOGGER = LogManager.getLogger(ArrayFactoryImpl.class);

    @Override
    public CustomIntegerArray createArray(int[] elements) throws ArrayTaskException {
        if(elements == null) {
            LOGGER.error("Array creation failed: input array is null");
            throw new ArrayTaskException("Target elements array cannot be null");
        }
        CustomIntegerArray arrayInstance = new CustomIntegerArray(elements);
        LOGGER.info("Creating CustomIntegerArray with {} elements", elements.length);
        return arrayInstance;
    }
}
