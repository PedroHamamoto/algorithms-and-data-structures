package br.com.hamamoto.dynamic_programming;

import java.util.Arrays;

/**
 *<a href="https://leetcode.com/problems/longest-ideal-subsequence"> LeetCode problem </a> - Longest Ideal Subsequence
 * */
public class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        var dp = new int[26];

        for (var c : s.toCharArray()) {
            var current = c - 'a';
            int longest = 1;

            for (int previous = 0; previous < 26; previous++) {
                if (Math.abs(current - previous) <= k) {
                    longest = Math.max(longest, 1 + dp[previous]);
                }
            }

            dp[current] = Math.max(dp[current], longest);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
