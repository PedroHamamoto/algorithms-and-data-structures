package br.com.hamamoto.greedy;

/**
 *<a href="https://leetcode.com/problems/jump-game"> LeetCode problem </a>
 * - Jump Game
 * */
public class JumpGame {
    public boolean canJump(int[] nums) {
        var goal = nums.length - 1;

        for (var i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= goal)
                goal = i;
        }

        return goal == 0;
    }
}
