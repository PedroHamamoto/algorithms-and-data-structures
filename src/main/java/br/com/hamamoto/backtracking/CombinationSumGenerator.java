package br.com.hamamoto.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum"> LeetCode problem </a> - Combination Sum
 */
class CombinationSumGenerator {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();

        dfs(candidates, 0, new ArrayList<Integer>(), combinations, 0, target);

        return combinations;    
    }

    void dfs(int[] candidates, int index, List<Integer> current, List<List<Integer>> combinations, 
        int sum, int target) {
        if (sum == target) {
            combinations.add(new ArrayList<>(current));
        } else if (index < candidates.length && sum < target) {
            current.add(candidates[index]);
            dfs(candidates, index, current, combinations, sum + candidates[index], target);
            current.remove(current.size() - 1);
            dfs(candidates, index + 1, current, combinations, sum, target);
        }
    }


}