package br.com.hamamoto.sorting;

/**
 *<a href="https://leetcode.com/problems/sort-colors"> LeetCode problem </a> - Sort Colors
 * */
class ColorSorter {
    public void sortColors(int[] nums) {
        int[] ranges = new int[3];

        for (int n : nums) {
            ranges[n]++;
        }

        int index = 0;
        for (int i = 0; i < ranges.length; i++) {
            for (int j = 0; j < ranges[i]; j++) {
                nums[index] = i;
                index++;
            }
        }
    }
}