package br.com.hamamoto.dynamic_programming;

import java.util.Arrays;

/**
 *<a href="https://leetcode.com/problems/minimum-falling-path-sum-ii"> LeetCode problem </a>
 * - Minimum Falling Path Sum II
 * */
public class MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] grid) {
        var n = grid.length;

        for (int row = 1; row < n; row++) {
            for (int column = 0; column < n; column++) {
                var min = Integer.MAX_VALUE;
                for (int nextColumn = 0; nextColumn < n; nextColumn++) {
                    if (nextColumn != column)
                        min = Math.min(min, grid[row - 1][nextColumn]);
                }

                grid[row][column] += min;
            }
        }

        return Arrays.stream(grid[n - 1]).min().getAsInt();
    }
}
