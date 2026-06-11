package by.innowise.arraystask.reader;

import by.innowise.arraystask.exception.ArrayTaskException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFileReaderTest {
    private static final String VALID_PATH = "data/numbers.txt";
    private static final String INVALID_PATH = "data/numbers_not_exists.txt";
    private static final ArrayFileReader reader = new ArrayFileReader();

    @BeforeEach
    void setUp() {
    }

    @Test
    void readFileDataShouldReturnAllLinesFromExistingFile() throws ArrayTaskException {
        // given
        int expectedSize = 6;
        // when
        List<String> actual = reader.readFileData(VALID_PATH);
        // then
        assertEquals(expectedSize, actual.size());
    }

    @Test
    void readFileDataShouldThrowExceptionForNonExistingFile() {
        // when + then
        assertThrows(ArrayTaskException.class, () -> reader.readFileData(INVALID_PATH));
    }

    @AfterEach
    void tearDown() {
    }
}