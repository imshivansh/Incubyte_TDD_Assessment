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

        String delimiters = ",|\n"; // Default delimiters: comma or newline

        // Handle custom delimiters
        if (numbers.startsWith("//")) {
            // Extract delimiter part and remove it from the numbers string
            int delimiterEnd = numbers.indexOf('\n');
            String delimiterSection = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);

            // Extract multiple delimiters enclosed in square brackets
            delimiters = extractDelimiters(delimiterSection);
        }

        // Replace all occurrences of custom delimiters with commas
        numbers = replaceDelimitersWithComma(numbers, delimiters);

        // Split numbers by commas or newlines
        String[] numberStrings = numbers.split(",|\n");

        // Collect negative numbers
        String negativeNumbers = Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        // Throw exception if negative numbers are found
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        // Return the sum of all numbers, ignoring numbers >= 1000
        return Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .filter(i -> i < 1000) // Ignore numbers >= 1000
                .sum();
    }

    // Extract delimiters from the delimiter section
    private String extractDelimiters(String delimiterSection) {
        // Remove enclosing square brackets
        if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
            // Remove outer square brackets and split by "]["
            return Arrays.stream(delimiterSection.substring(1, delimiterSection.length() - 1).split("\\]\\["))
                    .map(Pattern::quote) // Escape special regex characters
                    .collect(Collectors.joining("|"));
        } else {
            // Single-character delimiter
            return Pattern.quote(delimiterSection);
        }
    }

    // Replace all delimiters in the numbers string with commas
    private String replaceDelimitersWithComma(String numbers, String delimiters) {
        return numbers.replaceAll(delimiters, ",");
    }
}
