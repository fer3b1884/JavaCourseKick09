package by.shved.arraytask.comparator;

import by.shved.arraytask.entity.CustomIntegerArray;

import java.util.Comparator;

public class ArrayLengthComparator implements Comparator<CustomIntegerArray> {
    @Override
    public int compare(CustomIntegerArray first, CustomIntegerArray second) {
        return Integer.compare(first.length(), second.length());
    }
}
