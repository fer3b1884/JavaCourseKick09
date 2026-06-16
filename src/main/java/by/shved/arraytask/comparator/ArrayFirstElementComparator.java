package by.shved.arraytask.comparator;

import by.shved.arraytask.entity.CustomIntegerArray;

import java.util.Comparator;

public class ArrayFirstElementComparator implements Comparator<CustomIntegerArray> {
    @Override
    public int compare(CustomIntegerArray first, CustomIntegerArray second) {
        int[] firstArray = first.getArray();
        int[] secondArray = second.getArray();
        int firstValue = firstArray.length == 0 ? Integer.MIN_VALUE : firstArray[0];
        int secondValue = secondArray.length == 0 ? Integer.MIN_VALUE : secondArray[0];
        return Integer.compare(firstValue, secondValue);
    }
}
