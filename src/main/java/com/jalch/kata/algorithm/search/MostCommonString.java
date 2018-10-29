package com.jalch.kata.algorithm.search;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MostCommonString {

    public static String find(List<String> input) {
        return notValid(input)
                ? ""
                : input.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Entry::getValue))
                .get().getKey();

    }

    private static boolean notValid(List<String> input) {
        return input == null || input.isEmpty();
    }

}
