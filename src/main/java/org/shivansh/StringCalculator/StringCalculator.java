package org.shivansh.StringCalculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        /*
         * Split the input string by both commas and new lines.
         * The regular expression ",|\n" matches either a comma or a new line.
         * This handles cases where numbers are separated by commas or new lines.
         */
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, numbers.indexOf('\n'));
            numbers = numbers.substring(numbers.indexOf('\n') + 1);
            numbers = numbers.replace(delimiter, ",");
        }

        String[] numberStrings = numbers.split(",|\n");

        /*
         * returning the sum of all numbered strings
         */
        return Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
