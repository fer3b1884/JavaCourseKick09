package by.shved.arraytask.specification.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.specification.Specification;

import java.util.StringJoiner;

public class IdSpecification implements Specification {
    private final long targetId;

    public IdSpecification(long targetId) {
        this.targetId = targetId;
    }

    public boolean specify(CustomIntegerArray customIntegerArray) {
        return customIntegerArray.getId() == targetId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IdSpecification.class.getSimpleName() + "[", "]")
                .add("targetId=" + targetId)
                .toString();
    }
}
