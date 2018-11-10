package com.jalch.kata.algorithm.lang;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/sock-merchant/problem
public class PairsOfNumbersInArray {

    //n-> number of elements.
    //d-> distinct numbers (d <= n)
    //O(n) + O(distinct numbers) = O(n)
    public static int get(int[] numbers) {
        Map<Integer, Integer> numberRepetitions = new HashMap<>();
        for(Integer i: numbers){
            numberRepetitions.put(i, numberRepetitions.getOrDefault(i, 0) + 1);
        }
        return numberRepetitions.values().stream()
                .map(r -> Math.floorDiv(r, 2))
                .reduce(Integer::sum).orElse(0);
    }
}
