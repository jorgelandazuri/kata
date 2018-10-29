package com.jalch.kata.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CommonManagerTest {

    @Test
    public void first_test_case_example() {

        assertThat(CommonManager.find("6\n" +
                "Hilary\n" +
                "James\n" +
                "Sarah Fred\n" +
                "Sarah Paul\n" +
                "Fred Hilary\n" +
                "Fred Jenny\n" +
                "Jenny James"), is("Fred"));
    }

    @Test
    public void second_test_case_example() {

        assertThat(CommonManager.find("5\n" +
                "Gareth\n" +
                "Alex\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"), is("June"));
    }

    @Test
    public void same_person() {

        assertThat(CommonManager.find("5\n" +
                "Alex\n" +
                "Alex\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"), is("June"));

        assertThat(CommonManager.find("5\n" +
                "June\n" +
                "June\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"), is("June"));
    }

    @Test
    public void one_manages_the_other_() {

        assertThat(CommonManager.find("5\n" +
                "June\n" +
                "Gareth\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"), is("June"));

        assertThat(CommonManager.find("5\n" +
                "Gareth\n" +
                "June\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"), is("June"));

        assertThat(CommonManager.find("5\n" +
                "June\n" +
                "Qing\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"), is("June"));

        assertThat(CommonManager.find("5\n" +
                "Qing\n" +
                "June\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"), is("June"));
    }

    @Test
    public void not_direct_manager_in_same_line() {

        assertThat(CommonManager.find("5\n" +
                "Sarah\n" +
                "Claudiu\n" +
                "June Sarah\n" +
                "Sarah Tom\n" +
                "Tom Simon\n" +
                "Tom Claudiu"), is("Sarah"));

    }
}