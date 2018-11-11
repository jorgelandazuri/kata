package com.jalch.kata.algorithm.lang;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class SumUsingListedDigitsTest {

    private static final LinkedList<Integer> ANY_LIST = new LinkedList<>(asList(1, 2, 3));
    private static final LinkedList<Integer> EMPTY_LIST = new LinkedList<>();


    private SumUsingListedDigits underTest;

    @Before
    public void setUp() {
        underTest = new SumUsingListedDigits();
    }

    @Test
    public void invalid_input() {
        assertThat(underTest.sumOf(null, null), is(EMPTY_LIST));
        assertThat(underTest.sumOf(null, ANY_LIST), is(ANY_LIST));
        assertThat(underTest.sumOf(ANY_LIST, null), is(ANY_LIST));
        assertThat(underTest.sumOf(null, EMPTY_LIST), is(EMPTY_LIST));
        assertThat(underTest.sumOf(EMPTY_LIST, null), is(EMPTY_LIST));
        assertThat(underTest.sumOf(EMPTY_LIST, EMPTY_LIST), is(EMPTY_LIST));
    }

    @Test
    public void sum_of_both_zero() {
        assertThat(underTest.sumOf(aListOf(0), aListOf(0)), is(aListOf(0)));
    }

    @Test
    public void sum_of_one_zero() {
        assertThat(underTest.sumOf(aListOf(0), ANY_LIST), is(ANY_LIST));
    }

    @Test
    public void single_digits_lists() {
        assertThat(underTest.sumOf(aListOf(2), aListOf(2)), is(aListOf(4)));
    }

    @Test
    public void same_sized_list() {
        assertThat(underTest.sumOf(aListOf(1,2,3), aListOf(1,2,3)), is(aListOf(2,4,6)));
        assertThat(underTest.sumOf(aListOf(1,8), aListOf(1,8)), is(aListOf(3,6)));
        assertThat(underTest.sumOf(aListOf(9,9), aListOf(9,9)), is(aListOf(1,9,8)));
        assertThat(underTest.sumOf(aListOf(2,0,0,9), aListOf(1,0,0,9)), is(aListOf(3,0,1,8)));
    }

    @Test
    public void different_sized_list() {
        assertThat(underTest.sumOf(aListOf(7,2,4,3), aListOf(5,6,4)), is(aListOf(7,8,0,7)));
        assertThat(underTest.sumOf(aListOf(1,8), aListOf(8)), is(aListOf(2,6)));
        assertThat(underTest.sumOf(aListOf(9,9), aListOf(9)), is(aListOf(1,0,8)));
        assertThat(underTest.sumOf(aListOf(1,2,0,0,9), aListOf(9,0,0,9)), is(aListOf(2,1,0,1,8)));
    }

    private LinkedList<Integer> aListOf(Integer ... integers) {
        return new LinkedList<>(Arrays.asList(integers));
    }
}