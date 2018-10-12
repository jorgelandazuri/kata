package com.jalch.kata.algorithm.sorting;

import java.util.Collections;
import java.util.List;

class ClosestKPointsFromAPointToAnotherWithCoordinates {

    static List<List<Integer>> get(int k, List<Integer> position, List<List<Integer>> coordinates) {
        if(notValidPoints(position, coordinates)) return Collections.EMPTY_LIST;

        return k <= coordinates.size() ? coordinates.subList(0, k) : coordinates;
    }

    private static boolean notValidPoints(List<Integer> position, List<List<Integer>> coordinates) {
        return position == null || position.isEmpty() || coordinates == null || coordinates.isEmpty();
    }


}
