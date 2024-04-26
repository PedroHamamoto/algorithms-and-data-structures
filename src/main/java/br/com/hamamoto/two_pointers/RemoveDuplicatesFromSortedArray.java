package br.com.hamamoto.two_pointers;
public class RemoveDuplicatesFromSortedArray {

    /**
     *<a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array"> LeetCode problem </a>
     * - Remove Duplicates  from Sorted Array
     * */
    public int removeDuplicates(int[] nums) {
        int left = 1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) {
                nums[left++] = nums[right];
            }
        }

        return left;
    }

}
