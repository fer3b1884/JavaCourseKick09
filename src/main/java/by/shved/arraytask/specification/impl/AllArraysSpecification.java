package by.shved.arraytask.specification.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.specification.Specification;

import java.util.StringJoiner;

public class AllArraysSpecification implements Specification {

    public AllArraysSpecification() {
    }

    @Override
    public boolean specify(CustomIntegerArray customIntegerArray) {
        return true;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AllArraysSpecification.class.getSimpleName() + "[", "]")
                .toString();
    }
}
