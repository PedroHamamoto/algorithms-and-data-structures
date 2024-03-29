package br.com.hamamoto.sorting;

import org.junit.jupiter.api.Test;

class SorterTest {

    @Test
    void shouldPerformInsertionSort() {
        SorterBaseTest.testSorting(new InsertionSorter());
    }

    @Test
    void shouldPerformMergeSort() {
        SorterBaseTest.testSorting(new MergeSorter());
    }

    @Test
    void shouldPerformQuickSort() {
        SorterBaseTest.testSorting(new QuickSorter());
    }

    @Test
    void shouldPerformCountingSort() {
        SorterBaseTest.testSorting(new CountingSorter());
    }

}
