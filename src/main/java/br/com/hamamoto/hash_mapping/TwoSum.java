package br.com.hamamoto.hash_mapping;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted> LeetCode problem </a>
 * - Two Sum II - Input Array Is Sorted
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }

            map.put(target - nums[i], i);
        }

        return new int[2];
    }

}
