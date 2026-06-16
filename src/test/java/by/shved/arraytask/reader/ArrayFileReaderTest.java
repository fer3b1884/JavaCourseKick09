package by.shved.arraytask.reader;

import by.shved.arraytask.exception.ArrayTaskException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

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
        assertAll(
                () -> assertEquals(expectedSize, actual.size()),
                () -> assertFalse(actual.isEmpty())
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            INVALID_PATH
    })
    void readFileDataShouldThrowExceptionForInvalidPath(String path) {
        // when + then
        assertThrows(ArrayTaskException.class, () -> reader.readFileData(path));
    }

    @AfterEach
    void tearDown() {
    }
}