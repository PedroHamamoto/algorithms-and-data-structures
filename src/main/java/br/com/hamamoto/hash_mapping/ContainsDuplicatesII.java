package br.com.hamamoto.hash_mapping;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii> LeetCode problem </a>
 * - Contains Duplicates II
 */
public class ContainsDuplicatesII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var value = map.get(nums[i]);

            if (value != null && i - value <= k) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

}
