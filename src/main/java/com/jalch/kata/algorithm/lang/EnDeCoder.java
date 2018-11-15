package com.jalch.kata.algorithm.lang;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.regex.Pattern.matches;

/**
 * Implement a run-length encoding algorithm for a string of letters, the
 * input will be a string containing only letters. Your output should be a
 * matching string where any repeated characters should be replaced by a
 * number denoting the number of occurrences and a single instance of the
 * character. For example foo should become f2o, or hello would become he2lo.
 */
public class EnDeCoder {

    public static String encode(final String input) {
        if (!canBeEncoded(input)) return "";
        StringBuilder sb = new StringBuilder();
        int repeatedCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            char next = i != input.length() - 1 ? input.charAt(i + 1) : '\0';
            if (next != '\0' && current == next) {
                repeatedCount++;
            } else {
                if (repeatedCount > 0) {
                    sb.append(String.valueOf(repeatedCount + 1));
                    sb.append(current);
                } else {
                    sb.append(current);
                }
                repeatedCount = 0;
            }
        }
        return sb.toString();
    }

    public static String decode(final String input) {
        if (isNotBlank(input)) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);

                if (isEncodedNumberChar(current)) {
                    StringBuilder timesSB = new StringBuilder();
                    int numberParseIndex = i;
                    while (numberParseIndex < input.length() && isEncodedNumberChar(input.charAt(numberParseIndex))) {
                        timesSB.append(input.charAt(numberParseIndex));
                        numberParseIndex++;
                    }
                    String timesString = timesSB.toString();
                    int times = Integer.valueOf(timesString);
                    String next = numberParseIndex < input.length() ? input.charAt(numberParseIndex) + "" : "";
                    sb.append(IntStream.range(0, times)
                            .mapToObj(c -> next).collect(Collectors.joining("")));
                    i += timesString.length();
                } else {
                    sb.append(current);
                }
            }
            return sb.toString();
        }
        return "";

    }

    private static boolean isEncodedNumberChar(char current) {
        return "123456789".contains(current + "");
    }

    private static boolean canBeEncoded(String input) {
        return isNotBlank(input) && isNotANumber(input);
    }

    private static boolean isNotBlank(String input) {
        return input != null && !input.isEmpty();
    }

    private static boolean isNotANumber(String input) {
        if (matches("[^0-9]", input))
            throw new IllegalArgumentException("Can't encode/decode a string with numbers");
        return true;
    }

}
