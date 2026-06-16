package by.shved.arraytask.factory.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.exception.ArrayTaskException;
import by.shved.arraytask.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactoryImpl implements ArrayFactory {
    private static final Logger logger = LogManager.getLogger(ArrayFactoryImpl.class);

    @Override
    public CustomIntegerArray createArray(int[] elements) throws ArrayTaskException {
        if(elements == null) {
            logger.error("Array creation failed: input array is null");
            throw new ArrayTaskException("Target elements array cannot be null");
        }
        CustomIntegerArray arrayInstance = new CustomIntegerArray(elements);
        logger.info("Creating CustomIntegerArray with {} elements", elements.length);
        return arrayInstance;
    }
}
