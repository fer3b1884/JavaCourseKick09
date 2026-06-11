package by.innowise.arraystask.repository.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.observer.impl.CustomArrayObserver;
import by.innowise.arraystask.repository.ArrayRepository;
import by.innowise.arraystask.specification.Specification;
import by.innowise.arraystask.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static final Logger logger = LogManager.getLogger(ArrayRepositoryImpl.class);
    private static ArrayRepositoryImpl instance;
    private final List<CustomIntegerArray> arrays;

    private ArrayRepositoryImpl() {  // constructor is private (singleton pattern)
        arrays = new ArrayList<>();
    }

    public static ArrayRepositoryImpl getInstance() {  // singleton alternative constructor
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
            logger.info("Repository instance created");
        }
        return instance;
    }

    @Override
    public void addCustomIntegerArray(CustomIntegerArray customIntegerArray) throws ArrayTaskException {
        if (customIntegerArray == null) {
            logger.error("Attempt to add null array");
            throw new ArrayTaskException("CustomIntegerArray cannot be null");
        }
        customIntegerArray.attachObserver(new CustomArrayObserver());
        customIntegerArray.notifyObserver();
        arrays.add(customIntegerArray);
        logger.info("Array with id {} added to repository", customIntegerArray.getId());
    }

    @Override
    public void removeCustomIntegerArray(CustomIntegerArray customIntegerArray) throws ArrayTaskException {
        if (customIntegerArray == null) {
            logger.error("Attempt to remove null array");
            throw new ArrayTaskException("CustomIntegerArray cannot be null");
        }
        customIntegerArray.detachObserver();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.remove(customIntegerArray.getId());
        arrays.remove(customIntegerArray);
        logger.info("Array with id {} removed from repository", customIntegerArray.getId());
    }

    @Override
    public List<CustomIntegerArray> getAll() {
        return new ArrayList<>(arrays);
    }

    @Override
    public List<CustomIntegerArray> query(Specification specification) throws ArrayTaskException {
        if (specification == null) {
            logger.error("Specification is null");
            throw new ArrayTaskException("Specification cannot be null");
        }
        logger.info("Executing specification: {}", specification);
        List<CustomIntegerArray> result = new ArrayList<>();
        for (CustomIntegerArray array : arrays) {
            if (specification.specify(array)) {
                result.add(array);
            }
        }
        logger.info("Query completed. Found {} arrays", result.size());
        return result;
    }

    @Override
    public void sort(Comparator<CustomIntegerArray> comparator) throws ArrayTaskException {
        if (comparator == null) {
            logger.error("Comparator is null");
            throw new ArrayTaskException("Comparator cannot be null");
        }
        arrays.sort(comparator);
        Class<?> comparatorClass = comparator.getClass();  // is used for logger output
        logger.info("Repository sorted using comparator: {}", comparatorClass.getSimpleName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArrayRepositoryImpl.class.getSimpleName() + "[", "]")
                .add("arrays=" + arrays)
                .toString();
    }
}
