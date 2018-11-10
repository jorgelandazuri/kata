package com.jalch.kata.algorithm.lang;

//Write function to calculate sum of first N powers of 2 starting from 1.
//You shouldn't use any built-in function for calculating power.
//Implement the most efficient solution.
public class PowerOfTwoSum {

    public static long calculateWithShifting(int n) {
        return n < 0 ? 0 : (1L << n) - 1;
    }


    public static long calculateWithPow(int n) {
        if (n <= 0) return 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(2, i);
        }
        return sum;
    }
}
