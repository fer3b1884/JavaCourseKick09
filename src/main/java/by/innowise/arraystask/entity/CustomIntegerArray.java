package by.innowise.arraystask.entity;

import by.innowise.arraystask.exception.ArrayTaskException;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomIntegerArray {
    private int[] integerArray;

    public CustomIntegerArray() {
        this.integerArray = new int[0];  // avoid null
    }

    public CustomIntegerArray(int[] inputArray) {
        if (inputArray == null) {
            this.integerArray = new int[0];  // if the constructor takes a null value?
        } else {
            this.integerArray = Arrays.copyOf(inputArray, inputArray.length);
        }
    }

    public int[] getArray() {
        int length = integerArray.length;
        int[] arrayCopy = Arrays.copyOf(integerArray, length);
        return arrayCopy;
    }

    public void setArray(int[] inputArray) {
        if (inputArray == null) {
            this.integerArray = new int[0];
        } else {
            this.integerArray = Arrays.copyOf(inputArray, inputArray.length);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || (getClass() != o.getClass())) return false;

        CustomIntegerArray that = (CustomIntegerArray) o;

        return Arrays.equals(integerArray, that.integerArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integerArray);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomIntegerArray.class.getSimpleName() + "[", "]")
                .add("integerArray=" + Arrays.toString(integerArray))
                .toString();
    }
}
