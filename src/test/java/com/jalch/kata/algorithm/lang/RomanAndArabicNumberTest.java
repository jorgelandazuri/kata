package com.jalch.kata.algorithm.lang;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanAndArabicNumberTest {

    @Test
    public void null_string() {
        assertThat(RomanAndArabicNumber.convert(null), is(""));
    }

    @Test
    public void empty_string() {
        assertThat(RomanAndArabicNumber.convert(""), is(""));
    }

    @Test
    public void invalid_or_negative_or_zero() {
        assertThat(RomanAndArabicNumber.convert("--345"), is(""));
        assertThat(RomanAndArabicNumber.convert("-345"), is(""));
        assertThat(RomanAndArabicNumber.convert("-1"), is(""));
        assertThat(RomanAndArabicNumber.convert("0"), is(""));
    }

    @Test
    public void invalid_roman() {
//        assertThat(RomanAndArabicNumber.convert("a"), is(""));
        assertThat(RomanAndArabicNumber.convert("_I"), is(""));
        assertThat(RomanAndArabicNumber.convert("*"), is(""));
        assertThat(RomanAndArabicNumber.convert("IIIV"), is(""));
        assertThat(RomanAndArabicNumber.convert("IIIX"), is(""));
        assertThat(RomanAndArabicNumber.convert("-I"), is(""));
    }

    @Test
    public void valid_arabic_to_roman() {
        assertThat(RomanAndArabicNumber.convert("1"), is("I"));
        assertThat(RomanAndArabicNumber.convert("2"), is("II"));
        assertThat(RomanAndArabicNumber.convert("3"), is("III"));
        assertThat(RomanAndArabicNumber.convert("4"), is("IV"));
        assertThat(RomanAndArabicNumber.convert("5"), is("V"));
        assertThat(RomanAndArabicNumber.convert("6"), is("VI"));
        assertThat(RomanAndArabicNumber.convert("7"), is("VII"));
        assertThat(RomanAndArabicNumber.convert("8"), is("VIII"));
        assertThat(RomanAndArabicNumber.convert("9"), is("IX"));
        assertThat(RomanAndArabicNumber.convert("10"), is("X"));
        assertThat(RomanAndArabicNumber.convert("11"), is("XI"));
        assertThat(RomanAndArabicNumber.convert("14"), is("XIV"));
        assertThat(RomanAndArabicNumber.convert("19"), is("XIX"));
        assertThat(RomanAndArabicNumber.convert("39"), is("XXXIX"));
        assertThat(RomanAndArabicNumber.convert("40"), is("XL"));
        assertThat(RomanAndArabicNumber.convert("50"), is("L"));
        assertThat(RomanAndArabicNumber.convert("74"), is("LXXIV"));
        assertThat(RomanAndArabicNumber.convert("90"), is("XC"));
        assertThat(RomanAndArabicNumber.convert("97"), is("XCVII"));
        assertThat(RomanAndArabicNumber.convert("99"), is("XCIX"));
        assertThat(RomanAndArabicNumber.convert("100"), is("C"));
        assertThat(RomanAndArabicNumber.convert("329"), is("CCCXXIX"));
        assertThat(RomanAndArabicNumber.convert("487"), is("CDLXXXVII"));
        assertThat(RomanAndArabicNumber.convert("490"), is("CDXC"));
        assertThat(RomanAndArabicNumber.convert("500"), is("D"));
        assertThat(RomanAndArabicNumber.convert("617"), is("DCXVII"));
        assertThat(RomanAndArabicNumber.convert("901"), is("CMI"));
        assertThat(RomanAndArabicNumber.convert("949"), is("CMXLIX"));
        assertThat(RomanAndArabicNumber.convert("999"), is("CMXCIX"));
        assertThat(RomanAndArabicNumber.convert("3999"), is("MMMCMXCIX"));
        assertThat(RomanAndArabicNumber.convert("4000"), is("MMMM"));
        assertThat(RomanAndArabicNumber.convert("4900"), is("MMMMCM"));
        assertThat(RomanAndArabicNumber.convert("4999"), is("MMMMCMXCIX"));
    }

    @Test
    public void valid_roman_to_arabic() {
        assertThat(RomanAndArabicNumber.convert("I"), is("1"));
        assertThat(RomanAndArabicNumber.convert("II"), is("2"));
        assertThat(RomanAndArabicNumber.convert("III"), is("3"));
        assertThat(RomanAndArabicNumber.convert("IV"), is("4"));
        assertThat(RomanAndArabicNumber.convert("V"), is("5"));
        assertThat(RomanAndArabicNumber.convert("VI"), is("6"));
        assertThat(RomanAndArabicNumber.convert("VII"), is("7"));
        assertThat(RomanAndArabicNumber.convert("VIII"), is("8"));
        assertThat(RomanAndArabicNumber.convert("IX"), is("9"));
        assertThat(RomanAndArabicNumber.convert("X"), is("10"));
        assertThat(RomanAndArabicNumber.convert("XI"), is("11"));
        assertThat(RomanAndArabicNumber.convert("XIV"), is("14"));
        assertThat(RomanAndArabicNumber.convert("XIX"), is("19"));
        assertThat(RomanAndArabicNumber.convert("XXXIX"), is("39"));
        assertThat(RomanAndArabicNumber.convert("XL"), is("40"));
        assertThat(RomanAndArabicNumber.convert("L"), is("50"));
        assertThat(RomanAndArabicNumber.convert("LXXIV"), is("74"));
        assertThat(RomanAndArabicNumber.convert("XC"), is("90"));
        assertThat(RomanAndArabicNumber.convert("XCVII"), is("97"));
        assertThat(RomanAndArabicNumber.convert("XCIX"), is("99"));
        assertThat(RomanAndArabicNumber.convert("C"), is("100"));
        assertThat(RomanAndArabicNumber.convert("CCCXXIX"), is("329"));
        assertThat(RomanAndArabicNumber.convert("CDLXXXVII"), is("487"));
        assertThat(RomanAndArabicNumber.convert("CDXC"), is("490"));
        assertThat(RomanAndArabicNumber.convert("D"), is("500"));
        assertThat(RomanAndArabicNumber.convert("DCXVII"), is("617"));
        assertThat(RomanAndArabicNumber.convert("CMI"), is("901"));
        assertThat(RomanAndArabicNumber.convert("CMXLIX"), is("949"));
        assertThat(RomanAndArabicNumber.convert("CMXCIX"), is("999"));
        assertThat(RomanAndArabicNumber.convert("MMMCMXCIX"), is("3999"));
        assertThat(RomanAndArabicNumber.convert("MMMM"), is("4000"));
        assertThat(RomanAndArabicNumber.convert("MMMMCM"), is("4900"));
        assertThat(RomanAndArabicNumber.convert("MMMMCMXCIX"), is("4999"));
    }
}