package br.com.hamamoto.hash_mapping;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence> LeetCode problem </a>
 * - Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        var longest = 0;

        for (var n : nums) {
            set.add(n);
        }

        for (var n : nums) {
            if (!set.contains(n - 1)) {
                var currentSequence = 1;

                while (set.contains(n + currentSequence)) {
                    currentSequence++;
                }

                longest = Math.max(longest, currentSequence);
            }
        }

        return longest;
    }

}
