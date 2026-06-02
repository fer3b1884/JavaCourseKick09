package by.innowise.arraystask.reader;

import by.innowise.arraystask.exception.ArrayTaskException;
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
    void readFileData() throws ArrayTaskException {
        String validPath = "src/main/resources/data/numbers.txt";
        List<String> lines = reader.readFileData(validPath);

        boolean actual = lines.isEmpty();
        assertFalse(actual);
    }

    @AfterEach
    void tearDown() {
    }
}