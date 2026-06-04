package by.innowise.arraystask.reader;

import by.innowise.arraystask.exception.ArrayTaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFileReaderTest {
    private ArrayFileReader reader;

    @BeforeEach
    void setUp() {
        reader = new ArrayFileReader();
    }

    @Test
    void readFileDataShouldReturnAllLinesFromExistingFile() throws ArrayTaskException {
        // given
        String validPath = "data/numbers.txt";
        // when
        List<String> actual = reader.readFileData(validPath);
        // then
        assertEquals(6, actual.size());
    }

    @Test
    void readFileDataShouldThrowExceptionForNonExistingFile() {
        // given
        String validPath = "data/numbers_not_exists.txt";
        // when + then
        assertThrows(ArrayTaskException.class, () -> reader.readFileData(validPath));
    }

    @AfterEach
    void tearDown() {
    }
}