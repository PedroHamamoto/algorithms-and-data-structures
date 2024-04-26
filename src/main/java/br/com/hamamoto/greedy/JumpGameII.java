package br.com.hamamoto.greedy;

/**
 *<a href="https://leetcode.com/problems/jump-game-ii"> LeetCode problem </a>
 * - Jump Game II
 * */
public class JumpGameII {
    public int jump(int[] nums) {
        var minimumJumps = 0;
        var left = 0;
        var right = 0;

        while (right < nums.length - 1) {
            var farthest = 0;

            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1;
            right = farthest;
            minimumJumps++;
        }

        return minimumJumps;
    }
}
