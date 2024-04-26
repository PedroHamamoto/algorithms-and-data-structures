package br.com.hamamoto.two_pointers;

public class RemoveDuplicatesFromSortedArrayII {

    /**
     *<a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii"> LeetCode problem </a>
     * - Remove Duplicates  from Sorted Array II
     * */
    public int removeDuplicates(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (left <= 1 || nums[left - 2] != nums[right])
                nums[left++] = nums[right];
        }

        return left;
    }

}
