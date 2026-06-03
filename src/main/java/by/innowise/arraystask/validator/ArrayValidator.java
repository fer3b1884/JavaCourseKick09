package by.innowise.arraystask.validator;

public class ArrayValidator {
    private static final String VALID_ROW_REGEX = "[-\\d\\s,;]+";
//    private static final String VALID_ROW_REGEX = "^\\s*-?\\d+(\\s*[-,;]\\s*-?\\d+|\\s+-?\\d+)*\\s*$";

    public boolean isValidRow(String inputRow) {
        if (inputRow == null) {
            return false;
        }
        String strippedString = inputRow.strip();
        if (strippedString.isEmpty()) {
            return true;  // empty line in terms of task is correct
        }
        boolean matches = strippedString.matches(VALID_ROW_REGEX);
        return matches;
    }
}
