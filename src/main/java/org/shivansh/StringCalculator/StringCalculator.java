package org.shivansh.StringCalculator;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        // Handle empty string case
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // Default delimiters: comma or newline

        // Handle custom delimiter
        if (numbers.startsWith("//")) {
            // Extract delimiter section
            int delimiterStart = numbers.indexOf("//") + 2;
            int delimiterEnd = numbers.indexOf('\n');
            String delimiterSection = numbers.substring(delimiterStart, delimiterEnd);

            // Check if the delimiter is enclosed in square brackets
            if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
                // Extract delimiter without square brackets
                delimiter = delimiterSection.substring(1, delimiterSection.length() - 1);
            } else {
                // Single-character delimiter
                delimiter = delimiterSection;
            }

            // Remove the delimiter line and update numbers string
            numbers = numbers.substring(delimiterEnd + 1);
        }

        // Handle cases where multiple delimiters are used
        String delimiterPattern = Pattern.quote(delimiter); // Escape special regex characters
        numbers = numbers.replaceAll(delimiterPattern, ",");

        // Split numbers by commas or newlines
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

        // Return the sum of all numbers, ignoring numbers >= 1000
        return Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .filter(i -> i < 1000) // Ignore numbers >= 1000
                .sum();
    }
}
