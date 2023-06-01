package br.com.hamamoto.dynamic_programming;

/**
 *<a href="https://leetcode.com/problems/house-robber"> LeetCode problem </a> - House Robber
 * */
public class HouseRobber {

    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int n : nums) {
            var temp = Math.max(rob2, n + rob1);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

}
