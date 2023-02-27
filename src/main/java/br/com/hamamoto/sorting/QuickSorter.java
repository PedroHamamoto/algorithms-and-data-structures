package br.com.hamamoto.sorting;

public class QuickSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int start, int end) {
        if (end - start + 1 <= 1)
            return arr;

        int pivot = arr[end];
        int left = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;

                left++;
            }
        }

        arr[end] = arr[left];
        arr[left] = pivot;

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);

        return arr;
    }
}
