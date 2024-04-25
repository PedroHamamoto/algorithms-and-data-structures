package br.com.hamamoto.arrays;
public class RemoveDuplicatesFromSortedArray {

    /**
     *<a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array"> LeetCode problem </a>
     * - Remove Duplicates  from Sorted Array
     * */
    public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

}
