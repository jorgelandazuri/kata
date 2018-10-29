package com.jalch.kata.algorithm.search;

import org.junit.Test;

import java.util.List;

import static com.jalch.kata.algorithm.search.MostCommonString.find;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MostCommonStringTest {

    @Test
    public void null_input() {
        assertThat(find(null), is(""));
    }

    @Test
    public void empty_input() {
        assertThat(find(emptyList()), is(""));
    }

    @Test
    public void single_element() {
        assertThat(find(singletonList("NY")), is("NY"));
    }

    @Test
    public void multiple_unique_elements() {
        assertThat(find(asList("New York", "London", "Barcelona", "Paris")), is("New York"));
    }

    @Test
    public void multiple_not_unique_elements() {
        List<String> input = asList("New York", "London", "Barcelona", "London", "Paris");
        assertThat(find(input), is("London"));


        input = asList( "Barcelona", "Edinburgh", "Barcelona", "Miami", "Miami", "Barcelona");
        assertThat(find(input), is("Barcelona"));

        input = asList( "Singapore", "Bangkok", "Singapore", "Bangkok", "Singapore");
        assertThat(find(input), is("Singapore"));
    }

}