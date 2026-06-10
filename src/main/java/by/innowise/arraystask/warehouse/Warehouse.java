package by.innowise.arraystask.warehouse;

import by.innowise.arraystask.parameters.ArrayParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger LOGGER = LogManager.getLogger(Warehouse.class);
    private static Warehouse instance;
    private final Map<Long, ArrayParameters> storage = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayParameters put(long id, ArrayParameters parameters) {
        LOGGER.info("Saving parameters for array id={}", id);
        return storage.put(id, parameters);
    }

    public ArrayParameters get(long id) {
        LOGGER.debug("Getting parameters for array id={}", id);
        return storage.get(id);
    }

    public ArrayParameters remove(long id) {
        LOGGER.info("Removing parameters for array id={}", id);
        return storage.remove(id);
    }

    public void clear() {
        storage.clear();
    }
}
