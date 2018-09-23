package com.jalch.kata.algorithm.search;

public class SecondSmallestInArray {

    public static int find(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return Integer.MAX_VALUE;
        if (numbers.length == 1)
            return numbers[0];

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int current : numbers) {
            if (current < secondSmallest) {
                secondSmallest = current;
                if (secondSmallest < smallest){
                    int temp = secondSmallest;
                    secondSmallest = smallest;
                    smallest = temp;
                }
            }
        }
        return secondSmallest;
    }
}
