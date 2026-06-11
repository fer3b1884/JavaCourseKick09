package by.innowise.arraystask.specification.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.service.ArrayCalculationService;
import by.innowise.arraystask.service.impl.ArrayCalculationServiceImpl;
import by.innowise.arraystask.specification.Specification;

import java.util.Optional;
import java.util.StringJoiner;

public class SumEqualsSpecification implements Specification {
    private final int expectedSum;

    public SumEqualsSpecification(int expectedSum) {
        this.expectedSum = expectedSum;
    }

    @Override
    public boolean specify(CustomIntegerArray customIntegerArray) {
        ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();
        Optional<Integer> optionalResult = calculationService.calculateSum(customIntegerArray);
        return optionalResult.isPresent() && optionalResult.get() == expectedSum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SumEqualsSpecification.class.getSimpleName() + "[", "]")
                .add("expectedSum=" + expectedSum)
                .toString();
    }
}
