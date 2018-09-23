package com.jalch.kata.algorithm.search;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SecondSmallestInArrayTest {

    @Test
    public void null_input() {
        assertThat(SecondSmallestInArray.find(null), is(MAX_VALUE));
    }

    @Test
    public void empty() {
        int[] input = {};
        assertThat(SecondSmallestInArray.find(input), is(MAX_VALUE));
    }

    @Test
    public void single_element() {
        int[] input = {0};
        assertThat(SecondSmallestInArray.find(input), is(0));
    }

    @Test
    public void two_elements_ordered() {
        int[] input = {0,1};
        assertThat(SecondSmallestInArray.find(input), is(1));
    }

    @Test
    public void many_elements_unordered() {
        int[] input = {-3,0,1,345, MIN_VALUE, 5,-334,0};
        assertThat(SecondSmallestInArray.find(input), is(-334));
    }

    @Test
    public void many_elements_all_same() {
        int[] input = {-3,-3,-3,-3,-3,-3,-3,-3};
        assertThat(SecondSmallestInArray.find(input), is(-3));
    }

    @Test
    public void many_elements_max_and_min() {
        int[] input = {MAX_VALUE, MIN_VALUE};
        assertThat(SecondSmallestInArray.find(input), is(MAX_VALUE));
    }
}