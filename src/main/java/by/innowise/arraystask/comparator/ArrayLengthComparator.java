package by.innowise.arraystask.comparator;

import by.innowise.arraystask.entity.CustomIntegerArray;

import java.util.Comparator;

public class ArrayLengthComparator implements Comparator<CustomIntegerArray> {
    @Override
    public int compare(CustomIntegerArray first, CustomIntegerArray second) {
        return Integer.compare(first.length(), second.length());
    }
}
