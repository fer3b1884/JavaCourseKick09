package by.shved.arraytask.util;

public final class ArrayIdGenerator {
    private static long counter = 1;

    private ArrayIdGenerator() {
    }

    public static long nextId() {
        return counter++;
    }
}
