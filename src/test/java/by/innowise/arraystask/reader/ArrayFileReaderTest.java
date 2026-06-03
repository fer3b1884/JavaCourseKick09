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
        // given
        String validPath = "src/main/resources/data/numbers.txt";
        // when
        List<String> actual =
                reader.readFileData(validPath);
        // then
        assertEquals(2, actual.size());
    }

    @Test
    void readFileDataNotExists() throws ArrayTaskException {
        // given
        String validPath = "src/main/resources/data/numbers_not_exists.txt";
        // when + then
        assertThrows(ArrayTaskException.class, () -> reader.readFileData(validPath));
    }

    @AfterEach
    void tearDown() {
    }
}