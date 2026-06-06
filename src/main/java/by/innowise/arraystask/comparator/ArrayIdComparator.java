package by.innowise.arraystask.comparator;

import by.innowise.arraystask.entity.CustomIntegerArray;

import java.util.Comparator;

public class ArrayIdComparator implements Comparator<CustomIntegerArray> {
    @Override
    public int compare(CustomIntegerArray first, CustomIntegerArray second) {
        long firstId = first.getId();
        long secondId = second.getId();
        return Long.compare(firstId, secondId);
    }
}
