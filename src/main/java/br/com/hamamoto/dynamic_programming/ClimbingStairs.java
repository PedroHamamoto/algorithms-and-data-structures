package br.com.hamamoto.dynamic_programming;

/**
 *<a href="https://leetcode.com/problems/climbing-stairs"> LeetCode problem </a> - Climbing Stairs
 * */
class ClimbingStairs {
    public int climbStairs(int n) {
        int n1 = 1;
        int n2 = 1;

        for (int i = 0; i < n - 1; i++) {
            n1 += n2;
            n2 = n1 - n2;
        }

        return n1;
    }
}