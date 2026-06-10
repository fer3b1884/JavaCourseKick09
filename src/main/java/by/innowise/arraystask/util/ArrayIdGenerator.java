package by.innowise.arraystask.util;

public final class ArrayIdGenerator {
    private static long counter = 1;

    private ArrayIdGenerator() {
    }

    public static long nextId() {
        return counter++;
    }
}
