package br.com.hamamoto.dynamic_programming;

import java.util.Arrays;

/**
 *<a href="https://leetcode.com/problems/minimum-falling-path-sum"> LeetCode problem </a>
 * - Minimum Falling Path Sum
 * */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        var n = matrix.length;

        for (int row = 1; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                var min = column > 0? matrix[row -1][column - 1] : Integer.MAX_VALUE;
                min = Math.min(min, matrix[row - 1][column]);
                min = Math.min(min, column < n - 1? matrix[row - 1][column + 1] : Integer.MAX_VALUE);

                matrix[row][column] = matrix[row][column] + min;
            }
        }

        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }
}
