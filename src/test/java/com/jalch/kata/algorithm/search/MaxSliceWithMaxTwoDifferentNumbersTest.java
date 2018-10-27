package com.jalch.kata.algorithm.search;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxSliceWithMaxTwoDifferentNumbersTest {

    private MaxSliceWithMaxTwoDifferentNumbers underTest;

    @Test
    public void null_input() {
        assertThat(underTest.calculate(null), is(0L));
    }

    @Test
    public void empty_input() {
        assertThat(underTest.calculate(emptyList()), is(0L));
    }

    @Test
    public void single_element() {
        assertThat(underTest.calculate(singletonList(1)), is(1L));
    }

    @Test
    public void multiple_elements_all_same() {
        assertThat(underTest.calculate(asList(1,1)), is(2L));
        assertThat(underTest.calculate(asList(1,1,1,1,1,1)), is(6L));
        assertThat(underTest.calculate(asList(-2,-2,-2)), is(3L));
        assertThat(underTest.calculate(asList(2,2,2,2,2,2,2,2,2)), is(9L));
    }

    @Test
    public void multiple_elements_if_same_are_consecutive() {
        assertThat(underTest.calculate(asList(1,1,2,1,2,3,3,3,3)), is(5L));
        assertThat(underTest.calculate(asList(1,2)), is(2L));
        assertThat(underTest.calculate(asList(1,1,1,2,2,3)), is(5L));
        assertThat(underTest.calculate(asList(3,1,2,2)), is(3L));
        assertThat(underTest.calculate(asList(1,2,2,2,4,4,1,2,2)), is(5L));
        assertThat(underTest.calculate(asList(1,1,3)), is(3L));
        assertThat(underTest.calculate(asList(1,1,3,3)), is(4L));
        assertThat(underTest.calculate(asList(2,1,1,1,2)), is(5L));
        assertThat(underTest.calculate(asList(1,2,1,1,1,2)), is(6L));
        assertThat(underTest.calculate(asList(1,2,4,4,1,2,2)), is(3L));
        assertThat(underTest.calculate(asList(1,2,3,4,5,1,4,1,2,4)), is(3L));
        assertThat(underTest.calculate(asList(2,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6)), is(9L));
        assertThat(underTest.calculate(asList(2,2,2,3,2,3,2)), is(7L));
        assertThat(underTest.calculate(asList(1,2,1,2,3,1,1,2,3,2,2,2,2,3,0,1,1,1,1,0,0,0)), is(8L));
    }
}