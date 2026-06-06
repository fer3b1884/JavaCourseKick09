package by.innowise.arraystask.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomIntegerArray {
    private long id;
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

    public CustomIntegerArray(long id, int[] inputArray) {
        this(inputArray);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int[] getArray() {
        int length = integerArray.length;
        return Arrays.copyOf(integerArray, length);
    }

    public void setArray(int[] inputArray) {
        if (inputArray == null) {
            this.integerArray = new int[0];
        } else {
            this.integerArray = Arrays.copyOf(inputArray, inputArray.length);
        }
    }

    public int lengthOfArray() {
        return integerArray.length;
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
