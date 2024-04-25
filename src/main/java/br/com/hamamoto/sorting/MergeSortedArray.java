package br.com.hamamoto.sorting;

/**
 *<a href="https://leetcode.com/problems/merge-sorted-array"> LeetCode problem </a> - Merge Sorted Array
 * */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        var last = nums1.length - 1;

        while (m >= 0 && n >= 0) {
            if (nums2[n] < nums1[m]) {
                nums1[last] = nums1[m--];
            } else {
                nums1[last] = nums2[n--];
            }
            last--;
        }

        while (n >= 0) {
            nums1[last--] = nums2[n--];
        }
    }

}
