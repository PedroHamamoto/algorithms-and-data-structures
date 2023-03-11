package br.com.hamamoto.binary_search;

public class BinarySearcher {

    public int binarySearch(int[] arr, int target) {
        var left = 0;
        var right = arr.length - 1;

        while(left <= right) {
            var middle = (right + left) / 2;

            if (target > arr[middle]) {
                left = middle + 1;
            } else if (target < arr[middle]){
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (right < left) {
            return - 1;
        }

        var middle = (left + right) / 2;

        if (target > arr[middle]) {
            return binarySearch(arr, middle + 1, right, target);
        } else if (target < arr[middle]) {
            return binarySearch(arr, left, middle - 1, target);
        } else {
            return middle;
        }
    }
}
