package br.com.hamamoto.dynamic_programming;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-repeated-subarray"> LeetCode problem </a>
 * - Maximum Length of Repeated Subarray
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 2];
        int ans = 0;

        for (int r = nums1.length - 1; r >= 0; r--) {
            for (int c = nums2.length - 1; c >= 0; c--) {
                if (nums1[r] == nums2[c]) {
                    dp[r][c] = 1 + dp[r + 1][c + 1];
                }
                ans = Math.max(ans, dp[r][c]);
            }

        }

        return ans;
    }
}
