package by.shved.arraytask.repository.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.exception.ArrayTaskException;
import by.shved.arraytask.observer.impl.CustomArrayObserver;
import by.shved.arraytask.repository.ArrayRepository;
import by.shved.arraytask.specification.Specification;
import by.shved.arraytask.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static final Logger logger = LogManager.getLogger(ArrayRepositoryImpl.class);
    private static ArrayRepositoryImpl instance;
    private final List<CustomIntegerArray> listOfArrays;

    private ArrayRepositoryImpl() {  // constructor is private (singleton pattern)
        listOfArrays = new ArrayList<>();
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
        listOfArrays.add(customIntegerArray);
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
        listOfArrays.remove(customIntegerArray);
        logger.info("Array with id {} removed from repository", customIntegerArray.getId());
    }

    @Override
    public List<CustomIntegerArray> query(Specification specification) throws ArrayTaskException {
        if (specification == null) {
            logger.error("Specification is null");
            throw new ArrayTaskException("Specification cannot be null");
        }
        logger.info("Executing specification: {}", specification);
        List<CustomIntegerArray> result = new ArrayList<>();
        for (CustomIntegerArray array : listOfArrays) {
            if (specification.specify(array)) {
                result.add(array);
            }
        }
        logger.info("Query completed. Found {} arrays", result.size());
        return result;
    }

    @Override
    public List<CustomIntegerArray> functionalQuery(Specification specification) throws ArrayTaskException {
        if (specification == null) {
            logger.error("Specification is null");
            throw new ArrayTaskException("Specification cannot be null");
        }
        logger.info("Executing specification: {}", specification);
        List<CustomIntegerArray> result = listOfArrays.stream()
                .filter(specification::specify)  // array -> specification.specify(array)
                .toList();
        logger.info("Query completed. Found {} arrays", result.size());
        return result;
    }

    @Override
    public void sort(Comparator<CustomIntegerArray> comparator) throws ArrayTaskException {
        if (comparator == null) {
            logger.error("Comparator is null");
            throw new ArrayTaskException("Comparator cannot be null");
        }
        listOfArrays.sort(comparator);
        Class<?> comparatorClass = comparator.getClass();  // is used for logger output
        logger.info("Repository sorted using comparator: {}", comparatorClass.getSimpleName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArrayRepositoryImpl.class.getSimpleName() + "[", "]")
                .add("arrays=" + listOfArrays)
                .toString();
    }
}
