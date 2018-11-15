package com.jalch.kata.algorithm.lang;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EnDeCoderTest {

    @Test
    public void encode_null() {
        assertThat(EnDeCoder.encode(null), is(""));
    }

    @Test
    public void encode_empty() {
        assertThat(EnDeCoder.encode(""), is(""));
    }

    @Test
    public void encode_not_empty() {
        assertThat(EnDeCoder.encode("foo"), is("f2o"));
        assertThat(EnDeCoder.encode("foofoo"), is("f2of2o"));
        assertThat(EnDeCoder.encode("foooooooooooo"), is("f12o"));
        assertThat(EnDeCoder.encode("bar"), is("bar"));
        assertThat(EnDeCoder.encode("hello"), is("he2lo"));
    }

    @Test
    public void decode_null() {
        assertThat(EnDeCoder.decode(null), is(""));
    }

    @Test
    public void decode_empty() {
        assertThat(EnDeCoder.decode(""), is(""));
    }

    @Test
    public void decode_not_empty() {
        assertThat(EnDeCoder.decode("f2o"), is("foo"));
        assertThat(EnDeCoder.decode("f2of2o"), is("foofoo"));
        assertThat(EnDeCoder.decode("f12o"), is("foooooooooooo"));
        assertThat(EnDeCoder.decode("bar"), is("bar"));
        assertThat(EnDeCoder.decode("he2lo"), is("hello"));
    }
}