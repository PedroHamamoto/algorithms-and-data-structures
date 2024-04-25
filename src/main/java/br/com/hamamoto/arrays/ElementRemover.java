package br.com.hamamoto.arrays;

/**
 *<a href="https://leetcode.com/problems/remove-element"> LeetCode problem </a> - Remove Element
 * */
public class ElementRemover {

    public int removeElement(int[] nums, int val) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[ans++] = nums[i];
        }

        return ans;
    }

}
