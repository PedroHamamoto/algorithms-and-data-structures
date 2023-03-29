package br.com.hamamoto.backtracking;

import java.util.ArrayList;
import java.util.List;

class SubsetsGenerator {

    /**
     * <a href="https://leetcode.com/problems/subsets"> LeetCode problem </a> - Subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);

        return subsets;    
    }

    void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        if (index >= nums.length) {
            subsets.add(new ArrayList<>(current));
        } else {
            current.add(nums[index]);

            generateSubsets(index + 1, nums, current, subsets);
            current.remove(current.size() - 1);
            generateSubsets(index + 1, nums, current, subsets);
        }

    }

    
}