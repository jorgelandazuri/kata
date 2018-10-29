package com.jalch.kata.algorithm.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
public class CompanyHierarchyPerLevelsTest {

    @Test
    public void first_test_case_example() {

        assertThat(CompanyHierarchyPerLevels.findUsingBTree(
                "6\n" +
                "Sarah Fred\n" +
                "Sarah Paul\n" +
                "Fred Hilary\n" +
                "Fred Jenny\n" +
                "Jenny James"),
                is("Sarah\n" +
                        "Fred Paul\n" +
                        "Hilary Jenny\n" +
                        "James\n"));
    }

    @Test
    public void second_test_case_example() {

        assertThat(CompanyHierarchyPerLevels.findUsingBTree(
                "5\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth"),
                is("June\n" +
                "Alex Qing\n" +
                "Paul Gareth\n"));
    }

    @Test
    public void third_test_case_example() {

        assertThat(CompanyHierarchyPerLevels.findUsingBTree(
                "6\n" +
                     "Jon Mark\n" +
                     "Jon David\n" +
                     "Mark Paul\n" +
                     "Paul Lee\n" +
                     "Paul Steve"),
                is("Jon\n" +
                        "Mark David\n" +
                        "Paul\n" +
                        "Lee Steve\n"));
    }

    @Test
    public void fourth_test_case_example() {

        assertThat(CompanyHierarchyPerLevels.findUsingBTree(
                "7\n" +
                      "Jon Lee\n" +
                      "Lee Paul\n" +
                      "Paul Mark\n" +
                      "Paul David\n" +
                      "Lee Steve\n" +
                      "Steve Mat"),
                is("Jon\n" +
                        "Lee\n" +
                        "Paul Steve\n" +
                        "Mark David Mat\n"));
    }

    @Test
    public void fifth_test_case_example() {
        assertThat(CompanyHierarchyPerLevels.findUsingBTree(
                "2\n" +
                        "June Alex\n"),
                is("June\n" +
                        "Alex\n"));
    }

}