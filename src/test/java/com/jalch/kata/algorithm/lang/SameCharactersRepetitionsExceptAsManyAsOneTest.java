package com.jalch.kata.algorithm.lang;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SameCharactersRepetitionsExceptAsManyAsOneTest {

    private SameCharactersRepetitionsExceptAsManyAsOne underTest = new SameCharactersRepetitionsExceptAsManyAsOne();

    @Test
    public void null_input() {
        assertThat(underTest.valid(null), is("NO"));
    }

    @Test
    public void empty_input() {
        assertThat(underTest.valid(""), is("NO"));
    }

    @Test
    public void not_between_a_to_z() {
        assertThat(underTest.valid("1"), is("NO"));
        assertThat(underTest.valid("_"), is("NO"));
        assertThat(underTest.valid("2131234"), is("NO"));
        assertThat(underTest.valid("*"), is("NO"));
        assertThat(underTest.valid("A"), is("NO"));
        assertThat(underTest.valid("P"), is("NO"));
        assertThat(underTest.valid("~"), is("NO"));
    }

    @Test
    public void single_valid_character() {
        assertThat(underTest.valid("a"), is("YES"));
        assertThat(underTest.valid("b"), is("YES"));
        assertThat(underTest.valid("d"), is("YES"));
        assertThat(underTest.valid("f"), is("YES"));
        assertThat(underTest.valid("j"), is("YES"));
        assertThat(underTest.valid("n"), is("YES"));
        assertThat(underTest.valid("t"), is("YES"));
        assertThat(underTest.valid("z"), is("YES"));
    }

    @Test
    public void same_repetitions() {
        assertThat(underTest.valid("aa"), is("YES"));
        assertThat(underTest.valid("cababc"), is("YES"));
        assertThat(underTest.valid("abc"), is("YES"));
    }

    @Test
    public void not_same_repetitions() {
        assertThat(underTest.valid("aabxgb"), is("NO"));
        assertThat(underTest.valid("ababdc"), is("NO"));
        assertThat(underTest.valid("ccabc"), is("NO"));
    }

    @Test
    public void same_repetitions_but_one() {
        assertThat(underTest.valid("aac"), is("YES"));
        assertThat(underTest.valid("cababc"), is("YES"));
        assertThat(underTest.valid("abc"), is("YES"));
        //AA BB CC DD EEE FF GG HH
        assertThat(underTest.valid("abcdefghhgfedecba"), is("YES"));
    }
}