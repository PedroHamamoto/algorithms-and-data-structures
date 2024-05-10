package br.com.hamamoto.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/relative-ranks> LeetCode problem </a>
 * - Maximize Happiness of Selected Children
 */
public class MaximizeHappinessOfSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        var ans = 0L;

        for (int i = 0; i < k; i++) {
            var selected = happiness[happiness.length - i - 1] - i;
            if (selected > 0) {
                ans += selected;
            } else {
                break;
            }
        }

        return ans;
    }

}
