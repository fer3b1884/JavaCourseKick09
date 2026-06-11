package by.innowise.arraystask.reader;

import by.innowise.arraystask.exception.ArrayTaskException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayFileReader {
    private static final Logger logger = LogManager.getLogger(ArrayFileReader.class);

    public List<String> readFileData(String filePathString) throws ArrayTaskException {
        logger.info("Reading file {}", filePathString);
        Path path = Paths.get(filePathString);
        if (!Files.exists(path)) {
            logger.error("File does not exist: {}", filePathString);
            throw new ArrayTaskException("Target file does not exist: " + filePathString);
        }
        try {
            List<String> lines = Files.readAllLines(path);
            logger.info("Successfully read {} lines from file {}", lines.size(), filePathString);
            return lines;
        } catch (IOException e) {
            logger.error("Error during reading file {}", filePathString, e);
            throw new ArrayTaskException("Error during reading file process", e);
        }
    }
}