package br.com.hamamoto.sorting;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SorterBaseTest {

    static void testSorting(Sorter sorter) {
        int[] arr = createRandomIntArray();

        sorter.sort(arr);
        checkIfArrayIsOrdered(arr);
    }

    private static int[] createRandomIntArray() {
        var arr = new int[1000];
        var random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        return arr;
    }

    private static void checkIfArrayIsOrdered(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i] >= arr[i - 1]);
        }
    }

}