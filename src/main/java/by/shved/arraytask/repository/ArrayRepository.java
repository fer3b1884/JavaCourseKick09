package by.shved.arraytask.repository;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.exception.ArrayTaskException;
import by.shved.arraytask.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void addCustomIntegerArray(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
    void removeCustomIntegerArray(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
    List<CustomIntegerArray> query(Specification specification) throws ArrayTaskException;
    List<CustomIntegerArray> functionalQuery(Specification specification) throws ArrayTaskException;
    void sort(Comparator<CustomIntegerArray> comparator) throws ArrayTaskException;
}
