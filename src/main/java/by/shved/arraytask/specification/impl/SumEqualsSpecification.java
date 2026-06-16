package by.shved.arraytask.specification.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.service.ArrayCalculationService;
import by.shved.arraytask.service.impl.ArrayCalculationServiceImpl;
import by.shved.arraytask.specification.Specification;

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
