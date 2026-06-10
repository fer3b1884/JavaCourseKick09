package by.innowise.arraystask.warehouse;

import by.innowise.arraystask.parameters.ArrayParameters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private static final Warehouse WAREHOUSE = Warehouse.getInstance();

    @BeforeEach
    void setUp() {
        WAREHOUSE.clear();
    }

    @Test
    void putShouldSaveParameters() {
        // given
        long id = 1L;
        ArrayParameters expected = new ArrayParameters(1, 10, 20, 5.0);
        // when
        WAREHOUSE.put(id, expected);
        // then
        assertEquals(expected, WAREHOUSE.get(id));
    }

    @Test
    void getShouldReturnNullWhenIdDoesNotExist() {
        // given
        long id = 999L;
        // when
        ArrayParameters actual = WAREHOUSE.get(id);
        // then
        assertNull(actual);
    }

    @Test
    void removeShouldDeleteParameters() {
        // given
        long id = 1L;
        ArrayParameters parameters = new ArrayParameters(1, 10, 20, 5.0);
        WAREHOUSE.put(id, parameters);
        // when
        WAREHOUSE.remove(id);
        // then
        assertNull(WAREHOUSE.get(id));
    }

    @Test
    void putShouldReplaceExistingParameters() {
        // given
        long id = 1L;
        ArrayParameters oldParameters = new ArrayParameters(1, 10, 20, 5.0);
        ArrayParameters newParameters = new ArrayParameters(2, 20, 40, 10.0);
        WAREHOUSE.put(id, oldParameters);
        // when
        WAREHOUSE.put(id, newParameters);
        // then
        assertEquals(newParameters, WAREHOUSE.get(id));
    }

    @AfterEach
    void tearDown() {
    }
}