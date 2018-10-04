package com.jalch.kata.algorithm.sorting;

import java.util.*;

public class ReachValueWithMinimumNumberOfCoinsWithGivenDenominations {

    static List<Integer> getCoins(List<Integer> coinDenominations, int monetaryValue) {
        if (coinDenominations != null && !coinDenominations.isEmpty() && monetaryValue > 0) {
            Collections.sort(coinDenominations);
            int remaining = monetaryValue;
            List<Integer> result = new ArrayList<>();

            for (int i = coinDenominations.size() - 1; i >= 0 && remaining > 0; i--) {
                Integer currentEvaluatedDenomination = coinDenominations.get(i);
                while (remaining - currentEvaluatedDenomination >= 0) {
                    result.add(currentEvaluatedDenomination);
                    remaining -= currentEvaluatedDenomination;
                }
            }
            return result;
        }
        return Collections.singletonList(0);
    }
}
