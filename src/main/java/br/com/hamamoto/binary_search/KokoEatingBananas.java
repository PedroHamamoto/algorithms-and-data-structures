package br.com.hamamoto.binary_search;

import java.util.Arrays;

/**
 *<a href="https://leetcode.com/problems/koko-eating-bananas"> LeetCode problem </a> - Koko Eating Bananas
 * */
class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (canEatAll(piles, h, middle)) {
                res = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return res;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += pile / k;

            if (pile % k > 0) {
                totalHours++;
            }
        }

        return totalHours <= h;
    }
}