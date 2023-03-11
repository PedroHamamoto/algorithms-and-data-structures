package br.com.hamamoto.binary_search;

/**
 *<a href="https://leetcode.com/problems/search-a-2d-matrix"> LeetCode problem </a> - Search a 2D Matrix
 * */
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;

        for (int[] ints : matrix) {
            int first = ints[0];
            int last = ints[width - 1];
            if (target >= first && target <= last) {
                return binarySearch(ints, target);
            }
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        var left = 0;
        var right = arr.length - 1;

        while(left <= right) {
            var middle = (right + left) / 2;

            if (target > arr[middle]) {
                left = middle + 1;
            } else if (target < arr[middle]){
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}