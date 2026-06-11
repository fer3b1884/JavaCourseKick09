package by.innowise.arraystask.parameters;

import java.util.Objects;
import java.util.StringJoiner;

public class ArrayParameters {
    private int min;
    private int max;
    private int sum;
    private double average;

    public ArrayParameters(int min, int max, int sum, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArrayParameters that = (ArrayParameters) o;
        return min == that.min && max == that.max && sum == that.sum && Double.compare(average, that.average) == 0;
    }

    @Override
    public int hashCode() {
        int result = min;
        result = 31 * result + max;
        result = 31 * result + sum;
        result = 31 * result + Double.hashCode(average);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArrayParameters.class.getSimpleName() + "[", "]")
                .add("min=" + min)
                .add("max=" + max)
                .add("sum=" + sum)
                .add("average=" + average)
                .toString();
    }
}
