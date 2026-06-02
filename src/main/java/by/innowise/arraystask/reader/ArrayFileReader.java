package by.innowise.arraystask.reader;

import by.innowise.arraystask.exception.ArrayTaskException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayFileReader {
    public List<String> readFileData(String filePath) throws ArrayTaskException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new ArrayTaskException("Target file does not exist: " + filePath);
        }
        try {
            List<String> lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            throw new ArrayTaskException("Error during reading file process", e);
        }
    }
}