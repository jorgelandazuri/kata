package com.jalch.kata.algorithm.lang;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringToIntegerTest {

    @Test(expected = IllegalArgumentException.class)
    public void null_input() {
        StringToInteger.convert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_input() {
        StringToInteger.convert("");
    }

    @Test
    public void zero() {
        assertThat(StringToInteger.convert("0"), is(0));
    }

    @Test
    public void single_digit_positive_number() {
        assertThat(StringToInteger.convert("1"), is(1));
        assertThat(StringToInteger.convert("2"), is(2));
        assertThat(StringToInteger.convert("3"), is(3));
        assertThat(StringToInteger.convert("4"), is(4));
        assertThat(StringToInteger.convert("5"), is(5));
        assertThat(StringToInteger.convert("6"), is(6));
        assertThat(StringToInteger.convert("7"), is(7));
        assertThat(StringToInteger.convert("8"), is(8));
        assertThat(StringToInteger.convert("9"), is(9));
    }

    @Test
    public void single_digit_negative_number() {
        assertThat(StringToInteger.convert("-1"), is(-1));
        assertThat(StringToInteger.convert("-2"), is(-2));
        assertThat(StringToInteger.convert("-3"), is(-3));
        assertThat(StringToInteger.convert("-4"), is(-4));
        assertThat(StringToInteger.convert("-5"), is(-5));
        assertThat(StringToInteger.convert("-6"), is(-6));
        assertThat(StringToInteger.convert("-7"), is(-7));
        assertThat(StringToInteger.convert("-8"), is(-8));
        assertThat(StringToInteger.convert("-9"), is(-9));
    }

    @Test
    public void multiple_digit_positive_numbers() {
        assertThat(StringToInteger.convert("12"), is(12));
        assertThat(StringToInteger.convert("2134"), is(2134));
        assertThat(StringToInteger.convert("9992"), is(9992));
        assertThat(StringToInteger.convert(String.valueOf(Integer.MAX_VALUE)), is(Integer.MAX_VALUE));
    }

    @Test
    public void multiple_digit_negative_numbers() {
        assertThat(StringToInteger.convert("-12"), is(-12));
        assertThat(StringToInteger.convert("-2134"), is(-2134));
        assertThat(StringToInteger.convert("-9992"), is(-9992));
        assertThat(StringToInteger.convert(String.valueOf(Integer.MIN_VALUE)), is(Integer.MIN_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void single_dash() {
        StringToInteger.convert("-");
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_and_letters_input() {
        StringToInteger.convert("-12asf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void number_middle_dash_and_letters_input() {
        StringToInteger.convert("12-asf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void underscore_number_and_letters_input() {
        StringToInteger.convert("_1f");
        StringToInteger.convert("    ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spaces_input() {
        StringToInteger.convert("       ");
    }
}
