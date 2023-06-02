package br.com.hamamoto.graphs;

/**
 * <a href="https://leetcode.com/problems/number-of-islands"> LeetCode problem </a> - Number of Islands
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (isOutOfBounds(grid, r, c) || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }

    private boolean isOutOfBounds(char[][] grid, int r, int c) {
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length;
    }

}
