package br.com.hamamoto.sorting;

public class InsertionSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;

            while (j >= 0 && arr[j] > arr[j + 1])  {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }
}
