package com.jalch.kata.algorithm.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.jalch.kata.algorithm.sorting.ClosestKPointsFromAPointToAnotherWithCoordinates.getByFullSorting;
import static com.jalch.kata.algorithm.sorting.ClosestKPointsFromAPointToAnotherWithCoordinates.getByUsingMaxHeap;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@SuppressWarnings("Duplicates")
public class ClosestKPointsFromAPointToAnotherWithCoordinatesTest {

    private static final int ANY_NUMBER = 13;
    private static final List<Integer> ANY_POINT = asList(0, 0);
    private static final List<List<Integer>> ANY_POINTS = asList(asList(3,6), asList(2,6), asList(0,6));

    @Test
    public void null_or_empty_coordinates_input() {
        assertThat(getByFullSorting(ANY_NUMBER, null, EMPTY_LIST).size(), is(0));
        assertThat(getByFullSorting(ANY_NUMBER, EMPTY_LIST, null).size(), is(0));

        assertThat(getByUsingMaxHeap(ANY_NUMBER, null, EMPTY_LIST).size(), is(0));
        assertThat(getByUsingMaxHeap(ANY_NUMBER, EMPTY_LIST, null).size(), is(0));
    }

    @Test
    public void zero_or_negative_k_required() {
        assertThat(getByFullSorting(0, ANY_POINT, ANY_POINTS).size(), is(0));
        assertThat(getByFullSorting(-1, ANY_POINT, ANY_POINTS).size(), is(0));

        assertThat(getByUsingMaxHeap(0, ANY_POINT, ANY_POINTS).size(), is(0));
        assertThat(getByUsingMaxHeap(-1, ANY_POINT, ANY_POINTS).size(), is(0));
    }

    @Test
    public void coordinates_incorrect_size() {
        assertThat(getByFullSorting(ANY_NUMBER, asList(3), ANY_POINTS).size(), is(0));
        assertThat(getByFullSorting(ANY_NUMBER, asList(3, 4, 5), ANY_POINTS).size(), is(0));
        assertThat(getByFullSorting(ANY_NUMBER, ANY_POINT, asList(asList(3))).size(), is(0));
        assertThat(getByFullSorting(ANY_NUMBER, ANY_POINT, asList(asList(3, 4, 5))).size(), is(0));

        assertThat(getByUsingMaxHeap(ANY_NUMBER, asList(3), ANY_POINTS).size(), is(0));
        assertThat(getByUsingMaxHeap(ANY_NUMBER, asList(3, 4, 5), ANY_POINTS).size(), is(0));
        assertThat(getByUsingMaxHeap(ANY_NUMBER, ANY_POINT, asList(asList(3))).size(), is(0));
        assertThat(getByUsingMaxHeap(ANY_NUMBER, ANY_POINT, asList(asList(3, 4, 5))).size(), is(0));
    }

    @Test
    public void more_k_request_than_available() {
        List<List<Integer>> result = getByFullSorting(4, ANY_POINT, ANY_POINTS);
        assertThat(result.size(), is(3));
        assertThat(result.get(0), is(asList(0,6)));
        assertThat(result.get(1), is(asList(2,6)));
        assertThat(result.get(2), is(asList(3,6)));

        result = getByUsingMaxHeap(4, ANY_POINT, ANY_POINTS);
        assertThat(result.size(), is(3));
        assertThat(result.get(0), is(asList(0,6)));
        assertThat(result.get(1), is(asList(2,6)));
        assertThat(result.get(2), is(asList(3,6)));
    }

    @Test //Executed in ~1,6 seconds in average (2.5 GHz Intel Core i7)
    public void k_items_sorted_by_distance_by_full_coordinates_sorting() {
        List<Integer> randomPosition = getRandomPosition();
        List<List<Integer>> result = getByFullSorting(5, randomPosition, getRandomCoordinates(10));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByFullSorting(500, randomPosition, getRandomCoordinates(100_000));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByFullSorting(5000, randomPosition, getRandomCoordinates(1_000_000));
        assertSortedByDistanceFor(result, randomPosition);
    }

    @Test //Executed in ~2.4 seconds in average (2.5 GHz Intel Core i7)
    public void all_items_sorted_by_distance_by_full_coordinates_sorting() {
        List<Integer> randomPosition = getRandomPosition();
        List<List<Integer>> result = getByFullSorting(10, randomPosition, getRandomCoordinates(10));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByFullSorting(100_000, randomPosition, getRandomCoordinates(100_000));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByFullSorting(1_000_000, randomPosition, getRandomCoordinates(1_000_000));
        assertSortedByDistanceFor(result, randomPosition);
    }

    @Test //Executed in ~0.4 seconds in average (2.5 GHz Intel Core i7)
    public void k_items_sorted_by_distance_by_using_max_heap() {
        List<Integer> randomPosition = getRandomPosition();
        List<List<Integer>> result = getByUsingMaxHeap(5, randomPosition, getRandomCoordinates(10));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByUsingMaxHeap(500, randomPosition, getRandomCoordinates(100_000));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByUsingMaxHeap(5000, randomPosition, getRandomCoordinates(1_000_000));
        assertSortedByDistanceFor(result, randomPosition);
    }

    @Test //Executed in ~0,9 seconds in average (2.5 GHz Intel Core i7)
    public void all_items_sorted_by_distance_by_using_max_heap() {
        List<Integer> randomPosition = getRandomPosition();
        List<List<Integer>> result = getByUsingMaxHeap(10, randomPosition, getRandomCoordinates(10));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByUsingMaxHeap(100_000, randomPosition, getRandomCoordinates(100_000));
        assertSortedByDistanceFor(result, randomPosition);

        randomPosition = getRandomPosition();
        result = getByUsingMaxHeap(1_000_000, randomPosition, getRandomCoordinates(1_000_000));
        assertSortedByDistanceFor(result, randomPosition);
    }

    private List<Integer> getRandomPosition() {
        return asList(new Random().nextInt(), new Random().nextInt());
    }

    private void assertSortedByDistanceFor(List<List<Integer>> result, List<Integer> randomPosition) {
        for (int i = 0; i < result.size() - 1; i++) {
            boolean success = distance(randomPosition, result.get(i)) <= distance(randomPosition, result.get(i + 1));
            assertTrue(success);
        }
    }

    private double distance(List<Integer> from, List<Integer> to) {
        return sqrt(pow(from.get(0) - to.get(0), 2) + pow(from.get(1) - to.get(1), 2));
    }

    private List<List<Integer>> getRandomCoordinates(int numberOfCoordinates) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numberOfCoordinates; i++) {
            result.add(Arrays.asList(new Random().nextInt(), new Random().nextInt()));
        }
        return result;
    }
}