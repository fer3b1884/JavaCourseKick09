package by.innowise.arraystask.validator;

public class ArrayValidator {
    private static final String ARRAY_ROW_REGEX = "[-\\d\\s,;]+";

    public boolean isValidRow(String inputRow) {
        if (inputRow == null) {
            return false;
        }
        if (inputRow.isBlank()) {
            return true;  // empty line in terms of task is correct
        }
        return inputRow.matches(ARRAY_ROW_REGEX);
    }
}
