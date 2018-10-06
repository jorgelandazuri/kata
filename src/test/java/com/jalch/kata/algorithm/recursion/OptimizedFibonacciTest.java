package com.jalch.kata.algorithm.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OptimizedFibonacciTest {

    private OptimizedFibonacci underTest;

    @Before
    public void setUp() {
        underTest = new OptimizedFibonacci();
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative() {
        underTest.calculate(-1, new long[1]);
        underTest.calculate(-9, new long[1]);
        underTest.calculate(-1000000, new long[1]);
    }

    @Test
    public void zero() throws IllegalArgumentException {
        assertThat(underTest.calculate(0, new long[1]), is(0L));
    }

    @Test
    public void one() throws IllegalArgumentException {
        assertThat(underTest.calculate(1, new long[1]), is(1L));
    }

    @Test
    public void two_or_more() {
        assertThat(underTest.calculate(2, new long[11]), is(1L));
        assertThat(underTest.calculate(3, new long[11]), is(2L));
        assertThat(underTest.calculate(4, new long[11]), is(3L));
        assertThat(underTest.calculate(5, new long[11]), is(5L));
        assertThat(underTest.calculate(6, new long[11]), is(8L));
        assertThat(underTest.calculate(7, new long[11]), is(13L));
        assertThat(underTest.calculate(8, new long[11]), is(21L));
        assertThat(underTest.calculate(9, new long[11]), is(34L));
        assertThat(underTest.calculate(10, new long[11]), is(55L));
        assertThat(underTest.calculate(46, new long[47]), is(1_836_311_903L));
        assertThat(underTest.calculate(83, new long[84]), is(99_194_853_094_755_497L));
    }

}
