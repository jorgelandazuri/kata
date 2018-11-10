package com.jalch.kata.algorithm.lang;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PowerOfTwoSumTest {


    @Test
    public void sum_pow_of_negative() {
        assertThat(PowerOfTwoSum.calculateWithShifting(-1), is(0L));
    }

    @Test
    public void sum_pow_of_zero() {
        assertThat(PowerOfTwoSum.calculateWithShifting(0), is(0L));
    }

    @Test
    public void sum_pow_of_positive_with_shifting() {
        assertThat(PowerOfTwoSum.calculateWithShifting(1), is(1L));
        assertThat(PowerOfTwoSum.calculateWithShifting(2), is(3L));
        assertThat(PowerOfTwoSum.calculateWithShifting(3), is(7L));
        assertThat(PowerOfTwoSum.calculateWithShifting(4), is(15L));
        assertThat(PowerOfTwoSum.calculateWithShifting(5), is(31L));
        assertThat(PowerOfTwoSum.calculateWithShifting(6), is(63L));
        assertThat(PowerOfTwoSum.calculateWithShifting(7), is(127L));
        assertThat(PowerOfTwoSum.calculateWithShifting(8), is(255L));
        assertThat(PowerOfTwoSum.calculateWithShifting(9), is(511L));
        assertThat(PowerOfTwoSum.calculateWithShifting(10),is(1023L));
    }

    @Test
    public void sum_pow_of_hundred_with_shifting() {
        assertThat(PowerOfTwoSum.calculateWithShifting(63), is(Long.MAX_VALUE));
    }

    @Test
    public void sum_pow_of_positive_with_math_pow() {
        assertThat(PowerOfTwoSum.calculateWithPow(1), is(1L));
        assertThat(PowerOfTwoSum.calculateWithPow(2), is(3L));
        assertThat(PowerOfTwoSum.calculateWithPow(3), is(7L));
        assertThat(PowerOfTwoSum.calculateWithPow(4), is(15L));
        assertThat(PowerOfTwoSum.calculateWithPow(5), is(31L));
        assertThat(PowerOfTwoSum.calculateWithPow(6), is(63L));
        assertThat(PowerOfTwoSum.calculateWithPow(7), is(127L));
        assertThat(PowerOfTwoSum.calculateWithPow(8), is(255L));
        assertThat(PowerOfTwoSum.calculateWithPow(9), is(511L));
        assertThat(PowerOfTwoSum.calculateWithPow(10),is(1023L));
    }

    @Test
    public void sum_pow_of_hundred_with_math_pow() {
        assertThat(PowerOfTwoSum.calculateWithPow(63), is(Long.MAX_VALUE));
    }
}