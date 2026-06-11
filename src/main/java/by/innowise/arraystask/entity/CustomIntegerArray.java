package by.innowise.arraystask.entity;

import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.observer.ArrayObserver;
import by.innowise.arraystask.observer.Observable;
import by.innowise.arraystask.util.ArrayIdGenerator;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomIntegerArray implements Observable {
    private final long id;
    private int[] integerArray;
    private ArrayObserver observer;

    public CustomIntegerArray(int[] inputArray) /*throws ArrayTaskException*/ {
        if (inputArray == null) {
//            throw new ArrayTaskException("Input array cannot be null");
            integerArray = new int[0];
        }
        this.id = ArrayIdGenerator.nextId();
        this.integerArray = Arrays.copyOf(inputArray, inputArray.length);
    }

    public long getId() {
        return id;
    }

    public int[] getArray() {
        int length = integerArray.length;
        return Arrays.copyOf(integerArray, length);
    }

    public void setArray(int[] integerArray) throws ArrayTaskException {
        if (integerArray == null) {
            throw new ArrayTaskException("Input array cannot be null");
        }
        this.integerArray = Arrays.copyOf(integerArray, integerArray.length);
        notifyObserver();
    }

    public int length() {
        return integerArray.length;
    }

    public void setElement(int index, int value) throws ArrayTaskException {
        if (index < 0 || index >= integerArray.length) {
            throw new ArrayTaskException("Index " + index + " is out of bounds.");
        }
        integerArray[index] = value;
        notifyObserver();
    }

    @Override
    public void attachObserver(ArrayObserver arrayObserver) throws ArrayTaskException {
        if (arrayObserver == null) {
            throw new ArrayTaskException("Observer cannot be null");
        }
        observer = arrayObserver;
    }

    @Override
    public void detachObserver() {
        observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomIntegerArray that = (CustomIntegerArray) o;
        return id == that.id && Arrays.equals(integerArray, that.integerArray);
    }

    @Override
    public int hashCode() {
        return 31 * Arrays.hashCode(integerArray) + Long.hashCode(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomIntegerArray.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("integerArray=" + Arrays.toString(integerArray))
                .toString();
    }
}
