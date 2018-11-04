package com.jalch.kata.algorithm.lang;

import java.util.List;

import static java.util.Arrays.asList;
import static com.jalch.kata.algorithm.lang.RomanAndArabicNumber.RomanAndArabic.*;

//https://www.hackerrank.com/contests/computing-society-uwi-mona-welcome-competition/challenges/roman-numeral-converter
public class RomanAndArabicNumber {

    private static final List<RomanAndArabic> prioritizedNumerals = asList(M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I);

    public static String convert(String input) {
        if (input == null || input.isEmpty()) return "";

        int arabic = parseArabic(input);
        if (arabic != -1)
            return convertToRoman(arabic);

        if (parseRoman(input) != null)
            return convertToArabic(input);

        return "";
    }

    private static int parseArabic(String input) {
        try {
            int n = Integer.parseInt(input);
            return n > 0 ? n : -1;
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    private static String parseRoman(String input) {
        return input.toUpperCase().matches("(^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$)")
                ? input
                : null;
    }

    private static String convertToRoman(int arabic) {
        StringBuilder resultBuilder = new StringBuilder();
        int i = 0;
        while (arabic > 0 && i < prioritizedNumerals.size()) {
            RomanAndArabic currentNumeral = prioritizedNumerals.get(i);
            if (currentNumeral.getArabic() <= arabic) {
                arabic -= currentNumeral.getArabic();
                resultBuilder.append(currentNumeral.getRoman());
            } else {
                i++;
            }
        }
        return resultBuilder.toString();
    }

    private static String convertToArabic(String roman) {
        int result = 0;
        int i = 0;
        while (!roman.isEmpty() && i < prioritizedNumerals.size()) {
            RomanAndArabic currentNumeral = prioritizedNumerals.get(i);
            String currentNumeralRoman = currentNumeral.getRoman();
            if (roman.startsWith(currentNumeralRoman)) {
                roman = roman.substring(currentNumeralRoman.length());
                result += currentNumeral.getArabic();
            } else {
                i++;
            }
        }
        return result > 0 ? String.valueOf(result) : "";
    }

    enum RomanAndArabic {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private final int arabicValue;

        RomanAndArabic(int arabicValue) {
            this.arabicValue = arabicValue;
        }

        public int getArabic() {
            return arabicValue;
        }

        public String getRoman() {
            return this.toString();
        }
    }
}
