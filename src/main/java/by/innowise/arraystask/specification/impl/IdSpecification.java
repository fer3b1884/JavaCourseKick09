package by.innowise.arraystask.specification.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.specification.Specification;

import java.util.StringJoiner;

public class IdSpecification implements Specification {
    private final long targetId;

    public IdSpecification(long targetId) {
        this.targetId = targetId;
    }

    public boolean specify(CustomIntegerArray customIntegerArray) {
        return customIntegerArray != null && customIntegerArray.getId() == targetId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IdSpecification.class.getSimpleName() + "[", "]")
                .add("targetId=" + targetId)
                .toString();
    }
}
