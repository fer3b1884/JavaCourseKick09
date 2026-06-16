package by.shved.arraytask.factory;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.exception.ArrayTaskException;

public interface ArrayFactory {
    CustomIntegerArray createArray(int[] elements) throws ArrayTaskException;
}
