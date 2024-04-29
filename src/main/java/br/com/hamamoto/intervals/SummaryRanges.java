package br.com.hamamoto.intervals;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/summary-ranges> LeetCode problem </a>
 * - Summary Ranges
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        var ans = new LinkedList<String>();

        if (nums.length == 0)
            return ans;

        var start = nums[0];
        var end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end + 1) {
                ans.add(getRangeString(start, end));
                start = nums[i];
            }

            end = nums[i];
        }

        ans.add(getRangeString(start, end));

        return ans;
    }

    private String getRangeString(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }
}
