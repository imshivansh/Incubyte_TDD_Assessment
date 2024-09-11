package org.shivansh.StringCalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        //handle empty string case
        if (numbers.isEmpty()) {
            return 0;
        }

        // Handle custom delimiter
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, numbers.indexOf('\n'));
            numbers = numbers.substring(numbers.indexOf('\n') + 1);
            numbers = numbers.replace(delimiter, ",");
        }

      //separating String by comma and new line
        String[] numberStrings = numbers.split(",|\n");

        // Collect negative numbers
        String negativeNumbers = Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        // If there are negative numbers, throw an exception with all negative numbers
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        // Return the sum of all numbers
        return Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
