package by.innowise.arraystask.parser;

import by.innowise.arraystask.exception.ArrayTaskException;
import by.innowise.arraystask.validator.ArrayValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayParser {
    private static final String NUMBER_REGEX = "-?\\d+";

    public int[] parseString(String row) throws ArrayTaskException{
        ArrayValidator validator = new ArrayValidator();
        if(!validator.isValidRow(row)) {
            throw new ArrayTaskException("Provided row fails validation rules: " + row);
        }
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(row);
        List<Integer> list = new ArrayList<>();
        while (matcher.find()) {
            String token = matcher.group();
            int number = Integer.parseInt(token);
            list.add(number);
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int value = list.get(i);
            result[i] = value;
        }
        return result;
    }
}
