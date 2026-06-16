package by.shved.arraytask.observer.impl;

import by.shved.arraytask.entity.CustomIntegerArray;
import by.shved.arraytask.observer.ArrayObserver;
import by.shved.arraytask.parameters.ArrayParameters;
import by.shved.arraytask.service.ArrayCalculationService;
import by.shved.arraytask.service.impl.ArrayCalculationServiceImpl;
import by.shved.arraytask.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CustomArrayObserver implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger(CustomArrayObserver.class);

    @Override
    public void update(CustomIntegerArray array) {
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
        logger.info("Array id={} changed. Warehouse is updated.", array.getId());
    }
}
