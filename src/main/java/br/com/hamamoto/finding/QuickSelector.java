package br.com.hamamoto.finding;

/**
 *<a href="https://leetcode.com/problems/kth-largest-element-in-an-array"> LeetCode problem </a>
 * - Kth largest element in an array
 * */
class QuickSelector {
    public int findKthLargest(int[] nums, int k) {
        int i = nums.length - k;        
        return quickSelect(nums, 0, nums.length - 1, i);
    }

    public int quickSelect(int[] arr, int start, int end, int k) {
        int pivot = arr[end];
        int left = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;

                left++;
            }
        }

               
        arr[end] = arr[left];
        arr[left] = pivot;

        if (left > k) {
            return quickSelect(arr, start, left -1, k);
        } else if (left < k) {
            return quickSelect(arr, left + 1, end, k);
        }

        return arr[left];

    }
}