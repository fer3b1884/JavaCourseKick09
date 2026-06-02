package by.innowise.arraystask.validator;

public class ArrayValidator {
//    private static final String DATA_ROW_REGEX = "[-\\d\\s,;]+";
    private static final String DATA_ROW_REGEX = "^\\s*-?\\d+(\\s*[-,;]\\s*-?\\d+|\\s+-?\\d+)*\\s*$";

    public boolean isValidRow(String row) {
        if (row == null) {
            return false;
        }
        String trimmed = row.trim();
        if (trimmed.isEmpty()) {
            return true;  // empty line in terms of task is correct
        }
        boolean matches = row.matches(DATA_ROW_REGEX);
        return matches;
    }
}
