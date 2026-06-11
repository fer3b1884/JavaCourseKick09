package by.innowise.arraystask.repository;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void addCustomIntegerArray(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
    void removeCustomIntegerArray(CustomIntegerArray customIntegerArray) throws ArrayTaskException;
    List<CustomIntegerArray> getAll();
    List<CustomIntegerArray> query(Specification specification) throws ArrayTaskException;
    void sort(Comparator<CustomIntegerArray> comparator) throws ArrayTaskException;
}
