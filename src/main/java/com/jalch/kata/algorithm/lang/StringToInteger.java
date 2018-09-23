package com.jalch.kata.algorithm.lang;

public class StringToInteger {

    public static int convert(String input) throws IllegalArgumentException {

        if(input != null && !input.isEmpty()) {
            boolean isNegative = '-' == input.charAt(0);
            String unsignedInput = isNegative && input.length() > 1 ? input.substring(1, input.length()) : input;
            int result = 0;
            for(int i = unsignedInput.length()-1; i >= 0 ; i--){
                char currentChar = unsignedInput.charAt(i);
                boolean isNumber = "0123456789".contains("" + currentChar);
                if (isNumber) {
                    int decimalBaseIndex = unsignedInput.length() - 1 - i;
                    result = result + numberOf(unsignedInput.charAt(i) - '0', decimalBaseIndex);
                } else {
                    throw new IllegalArgumentException("Not accepted input");
                }
            }
            return isNegative ? result * -1 :result;
        }
        throw new IllegalArgumentException("Not accepted input");
    }

    private static int numberOf(int digit, int decimalBaseIndex) {
        return (int) Math.pow(10d, (double) decimalBaseIndex) * digit;
    }
}
