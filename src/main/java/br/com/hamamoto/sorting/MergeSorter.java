package br.com.hamamoto.sorting;

import java.util.Arrays;

public class MergeSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private int[] mergeSort(int[] arr, int start, int end) {
        if (end - start + 1 <= 1) {
            return arr;
        }

        var middle = (start + end) / 2;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);

        merge(arr, start, middle, end);


        return arr;
    }

    private void merge(int[] arr, int start, int middle, int end) {
        var left = Arrays.copyOfRange(arr, start, middle + 1);
        var right = Arrays.copyOfRange(arr, middle + 1, end + 1);

        int l = 0;
        int r = 0;
        int i = start;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                arr[i] = left[l];
                l++;
            } else {
                arr[i] = right[r];
                r++;
            }

            i++;
        }

        while (l < left.length) {
            arr[i] = left[l];
            l++;
            i++;
        }

        while (r < right.length) {
            arr[i] = right[r];
            r++;
            i++;
        }
    }
}
