package com.jalch.kata.algorithm.lang;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/
//Sherlock considers a string to be valid if all characters of the string appear the same number of times.
//It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the
//same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
//Complete the isValid function in the editor below. It should return either the string YES or the string NO.
//Constraint 1 <= |string| <= 10^5  && s has only characters [a-z]
public class SameCharactersRepetitionsExceptAsManyAsOne {

    public String valid(String input) {
        boolean valid;
        int deletionsNeeded = 0;
        if (betweenLetterRange(input)) {
            Map<Character, Integer> inputRepetitions = new HashMap<>();
            for (char c : input.toCharArray()) {
                inputRepetitions.put(c, inputRepetitions.getOrDefault(c, 0) + 1);
            }
            int letterRepetitionCountPivot = 0;
            for (Map.Entry<Character, Integer> current : inputRepetitions.entrySet()) {
                if (letterRepetitionCountPivot == 0) {
                    letterRepetitionCountPivot = current.getValue();
                } else {
                    int countDiffAbs = Math.abs(letterRepetitionCountPivot - current.getValue());
                    if (current.getValue() > 1 && countDiffAbs > 1)
                        deletionsNeeded += countDiffAbs;
                    if (current.getValue() == 1 && countDiffAbs > 0)
                        deletionsNeeded++;
                }
            }
            valid = deletionsNeeded <= 1;
        } else {
            valid = false;
        }
        return valid ? "YES" : "NO";
    }

    private boolean betweenLetterRange(String input) {
        Pattern pattern = Pattern.compile("^[a-z]+$");
        return input != null && pattern.matcher(input).matches();
    }
}
