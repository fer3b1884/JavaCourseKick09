package by.innowise.arraystask.warehouse;

import by.innowise.arraystask.parameters.ArrayParameters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private static final Warehouse warehouse = Warehouse.getInstance();

    @BeforeEach
    void setUp() {
        warehouse.clear();
    }

    @Test
    void putShouldSaveParameters() {
        // given
        long id = 1L;
        ArrayParameters expected = new ArrayParameters(1, 10, 20, 5.0);
        // when
        warehouse.put(id, expected);
        // then
        assertEquals(expected, warehouse.get(id));
    }

    @Test
    void getShouldReturnNullWhenIdDoesNotExist() {
        // given
        long id = 999L;
        // when
        ArrayParameters actual = warehouse.get(id);
        // then
        assertNull(actual);
    }

    @Test
    void removeShouldDeleteParameters() {
        // given
        long id = 1L;
        ArrayParameters parameters = new ArrayParameters(1, 10, 20, 5.0);
        warehouse.put(id, parameters);
        // when
        warehouse.remove(id);
        // then
        assertNull(warehouse.get(id));
    }

    @Test
    void putShouldReplaceExistingParameters() {
        // given
        long id = 1L;
        ArrayParameters oldParameters = new ArrayParameters(1, 10, 20, 5.0);
        ArrayParameters newParameters = new ArrayParameters(2, 20, 40, 10.0);
        warehouse.put(id, oldParameters);
        // when
        warehouse.put(id, newParameters);
        // then
        assertEquals(newParameters, warehouse.get(id));
    }

    @AfterEach
    void tearDown() {
    }
}