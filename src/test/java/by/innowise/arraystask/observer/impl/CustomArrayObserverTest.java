package by.innowise.arraystask.observer.impl;

import by.innowise.arraystask.entity.CustomIntegerArray;
import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.parameters.ArrayParameters;
import by.innowise.arraystask.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayObserverTest {
    private static final CustomArrayObserver observer = new CustomArrayObserver();
    private static final Warehouse warehouse = Warehouse.getInstance();

    @BeforeEach
    void setUp() {
        warehouse.clear();
    }

    @Test
    void updateShouldSaveCalculatedParametersToWarehouse() {
        // given
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        // when
        observer.update(array);
        // then
        ArrayParameters actual = warehouse.get(array.getId());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(1, actual.min()),
                () -> assertEquals(3, actual.max()),
                () -> assertEquals(6, actual.sum()),
                () -> assertEquals(2.0, actual.average())
        );
    }

    @Test
    void updateShouldReplaceOldParameters() throws ArrayTaskException {
        // given
        CustomIntegerArray array = new CustomIntegerArray(new int[]{1, 2, 3});
        observer.update(array);
        array.setArray(new int[]{10, 20});
        // when
        observer.update(array);
        // then
        ArrayParameters actual = warehouse.get(array.getId());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(10, actual.min()),
                () -> assertEquals(20, actual.max()),
                () -> assertEquals(30, actual.sum()),
                () -> assertEquals(15.0, actual.average())
        );
    }

    @AfterEach
    void tearDown() {
    }
}