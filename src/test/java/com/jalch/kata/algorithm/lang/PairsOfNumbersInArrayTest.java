package com.jalch.kata.algorithm.lang;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PairsOfNumbersInArrayTest {

    @Test
    public void empty_input() {
        assertThat(PairsOfNumbersInArray.get(new int[]{}), is(0));
    }

    @Test
    public void single_element_no_pairs() {
        assertThat(PairsOfNumbersInArray.get(new int[]{2}), is(0));
    }

    @Test
    public void single_pair() {
        assertThat(PairsOfNumbersInArray.get(new int[]{2,2}), is(1));
    }

    @Test
    public void no_pairs() {
        assertThat(PairsOfNumbersInArray.get(new int[]{1,2,3,4,5}), is(0));
    }

    @Test
    public void multiple_pairs_hacker_rank_test_case() {
        assertThat(PairsOfNumbersInArray.get(new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}), is(3));
    }
}