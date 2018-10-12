package com.jalch.kata.algorithm.sorting;

import org.junit.Test;

import java.util.List;

import static com.jalch.kata.algorithm.sorting.ClosestKPointsFromAPointToAnotherWithCoordinates.get;
import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ClosestKPointsFromAPointToAnotherWithCoordinatesTest {

    private static final int ANY_NUMBER = 13;
    private static final List<Integer> ANY_POINT = asList(3,5);
    private static final List<List<Integer>> ANY_POINTS = asList(ANY_POINT, ANY_POINT, ANY_POINT);

    @Test
    public void null_or_empty_coordinates_input() {
        assertThat(get(ANY_NUMBER, null, EMPTY_LIST).size(), is(0));
        assertThat(get(ANY_NUMBER, EMPTY_LIST, null).size(), is(0));
    }

    @Test
    public void zero_or_negative_k_required() {
        assertThat(get(0, ANY_POINT, ANY_POINTS).size(), is(0));
        assertThat(get(0, ANY_POINT, ANY_POINTS).size(), is(0));
        assertThat(get(0, ANY_POINT, ANY_POINTS).size(), is(0));
    }

    @Test
    public void more_k_request_than_available() {
        assertThat(get(4, ANY_POINT, ANY_POINTS).size(), is(3));
    }
}