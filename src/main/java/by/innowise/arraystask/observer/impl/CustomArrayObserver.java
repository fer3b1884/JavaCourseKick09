package by.innowise.arraystask.observer.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.observer.ArrayObserver;
import by.innowise.arraystask.parameters.ArrayParameters;
import by.innowise.arraystask.service.ArrayCalculationService;
import by.innowise.arraystask.service.impl.ArrayCalculationServiceImpl;
import by.innowise.arraystask.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CustomArrayObserver implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger(CustomArrayObserver.class);

    @Override
    public void update(CustomIntegerArray array) {
        logger.info("Array id={} changed. Recalculating parameters", array.getId());
        ArrayCalculationService service = new ArrayCalculationServiceImpl();
        Optional<Integer> minOptional = service.findMin(array);
        Optional<Integer> maxOptional = service.findMax(array);
        Optional<Integer> sumOptional = service.calculateSum(array);
        Optional<Double> avgOptional = service.calculateAverage(array);
        int min = minOptional.orElse(0);
        int max = maxOptional.orElse(0);
        int sum = sumOptional.orElse(0);
        double avg = avgOptional.orElse(0.0);
        ArrayParameters parameters = new ArrayParameters(min, max, sum, avg);
        Warehouse warehouse = Warehouse.getInstance();
        long arrayId = array.getId();
        warehouse.put(arrayId, parameters);  // replace old one
        logger.info("Warehouse updated for array id={}", array.getId());
    }
}
