package br.com.hamamoto.graphs;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island"> LeetCode problem </a> - Max area of island
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int islandArea = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, islandArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (isOutOfBounds(grid, r, c) || grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;

        return 1 + dfs(grid, r + 1, c) + dfs(grid, r, c + 1) + dfs(grid, r - 1, c) + dfs(grid, r, c - 1);

    }

    private boolean isOutOfBounds(int[][] grid, int r, int c) {
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length;
    }
}