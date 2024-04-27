package br.com.hamamoto.arrays;

import java.util.Arrays;

/**
 *<a href="https://leetcode.com/problems/product-of-array-except-self"> LeetCode problem </a>
 * - Product of Array Except Self
 * */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        var ans = new int[nums.length];
        Arrays.fill(ans, 1);

        var prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }

        var postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= postfix;
            postfix *= nums[i];
        }

        return ans;
    }
}
