package com.jalch.kata.algorithm.sorting;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import static java.lang.Integer.MAX_VALUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class MaxNumberOfPricedItemsWithBudgetTest {

    private static final int ANY_BUDGET = 9999;
    private static final int[] ANY_TOY_PRICES = {3, 4345, 345, 23, 4234, 9};

    private MaxNumberOfPricedItemsWithBudget underTest;

    @Before
    public void setUp() {
        underTest = new MaxNumberOfPricedItemsWithBudget();
    }

    @Test
    public void no_toy_prices_and_any_budget() {
        assertThat(underTest.maximumToysWithMinHeapSort(new int[]{}, ANY_BUDGET), is(0));
        assertThat(underTest.maximumToysWithInsertionSort(new int[]{}, ANY_BUDGET), is(0));
        assertThat(underTest.maximumToysWithQuickSort(new int[]{}, ANY_BUDGET), is(0));
    }

    @Test
    public void any_toy_prices_and_negative_budget() {
        assertThat(underTest.maximumToysWithMinHeapSort(ANY_TOY_PRICES, -1), is(0));
        assertThat(underTest.maximumToysWithInsertionSort(ANY_TOY_PRICES, -1), is(0));
        assertThat(underTest.maximumToysWithQuickSort(ANY_TOY_PRICES, -1), is(0));
    }

    @Test
    public void any_toy_prices_and_no_budget() {
        assertThat(underTest.maximumToysWithMinHeapSort(ANY_TOY_PRICES, 0), is(0));
        assertThat(underTest.maximumToysWithInsertionSort(ANY_TOY_PRICES, 0), is(0));
        assertThat(underTest.maximumToysWithQuickSort(ANY_TOY_PRICES, 0), is(0));
    }

    @Test
    public void one_toy_price_and_not_enough_budget() {
        assertThat(underTest.maximumToysWithMinHeapSort(new int[]{3}, 2), is(0));
        assertThat(underTest.maximumToysWithInsertionSort(new int[]{3}, 2), is(0));
        assertThat(underTest.maximumToysWithQuickSort(new int[]{3}, 2), is(0));
    }

    @Test
    public void one_toy_price_and_enough_budget() {
        assertThat(underTest.maximumToysWithMinHeapSort(new int[]{3}, 3), is(1));
        assertThat(underTest.maximumToysWithInsertionSort(new int[]{3}, 3), is(1));
        assertThat(underTest.maximumToysWithQuickSort(new int[]{3}, 3), is(1));
    }

    @Test
    public void badly_tagged_negative_price_enough_budget() {
        assertThat(underTest.maximumToysWithMinHeapSort(new int[]{23, -1, 234}, 257), is(2));
        assertThat(underTest.maximumToysWithInsertionSort(new int[]{23, -1, 234}, 257), is(2));
        assertThat(underTest.maximumToysWithQuickSort(new int[]{23, -1, 234}, 257), is(2));
    }

    @Test
    public void many_toys_prices_and_enough_budget_for_first_one() {
        assertThat(underTest.maximumToysWithMinHeapSort(new int[]{3, 5, 6, 9}, 3), is(1));
        assertThat(underTest.maximumToysWithInsertionSort(new int[]{3, 5, 6, 9}, 3), is(1));
        assertThat(underTest.maximumToysWithQuickSort(new int[]{3, 5, 6, 9}, 3), is(1));
    }

    @Test
    public void many_toys_prices_and_enough_budget_for_one_of_them_not_first_only() {
        assertThat(underTest.maximumToysWithMinHeapSort(new int[]{5, 3, 9, 4}, 3), is(1));
        assertThat(underTest.maximumToysWithInsertionSort(new int[]{5, 3, 9, 4}, 3), is(1));
        assertThat(underTest.maximumToysWithQuickSort(new int[]{5, 3, 9, 4}, 3), is(1));
    }

    @Test
    public void many_toys_prices_and_enough_budget_for_as_many_as_possible() {
        assertThat(underTest.maximumToysWithMinHeapSort(new int[]{2, 4, 5, 3, 9, 1, 3}, 9), is(4));
        assertThat(underTest.maximumToysWithInsertionSort(new int[]{2, 4, 5, 3, 9, 1, 3}, 9), is(4));
        assertThat(underTest.maximumToysWithQuickSort(new int[]{2, 4, 5, 3, 9, 1, 3}, 9), is(4));
    }

    @Test
    public void big_number_of_toy_prices_with_random_budget_best_algorithm() {
        assertThat(underTest.lastMethodExecutionTime, is(0L));
        assertSortingOptionsTimeEfficiencyWithNumberOfPrices(49);
        assertSortingOptionsTimeEfficiencyWithNumberOfPrices(99);
        assertSortingOptionsTimeEfficiencyWithNumberOfPrices(999);
        assertSortingOptionsTimeEfficiencyWithNumberOfPrices(1999);
    }

    private void assertSortingOptionsTimeEfficiencyWithNumberOfPrices(int numberOfPrices) {
        int[] prices = getRandomPrices(numberOfPrices);

        underTest.maximumToysWithQuickSort(prices, MAX_VALUE);
        long withQuickSortTime = underTest.lastMethodExecutionTime;
        underTest.maximumToysWithMinHeapSort(prices, MAX_VALUE);
        long withHeapSortTime = underTest.lastMethodExecutionTime;
        underTest.maximumToysWithInsertionSort(prices, MAX_VALUE);
        long withInsertionSortTime = underTest.lastMethodExecutionTime;
        //Verify that in average:
        //Time complexity of quick sort and min heapsort are less that insertion sort.
        System.out.println("Number of prices: " + numberOfPrices);
        System.out.println("Double pivot Quicksort took: " + withQuickSortTime + " ms");
        System.out.println("Min Heapsort took: " + withHeapSortTime + " ms");
        System.out.println("InsertionSort took: " + withInsertionSortTime + " ms");
        System.out.println();
    }

    private static int[] getRandomPrices(int numberOfPrices) {
        return new Random().ints(numberOfPrices, 0, MAX_VALUE).toArray();
    }
}