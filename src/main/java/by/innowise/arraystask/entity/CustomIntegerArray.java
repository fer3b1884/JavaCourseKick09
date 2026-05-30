package by.innowise.arraystask.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomIntegerArray {
    private int[] integerArray;

    public CustomIntegerArray(){
    }

    public CustomIntegerArray(int[] array){
        integerArray = array;
    }

    public int[] getArray() {
        return integerArray;
    }

    public void setArray(int[] array) {
        integerArray = array;
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
