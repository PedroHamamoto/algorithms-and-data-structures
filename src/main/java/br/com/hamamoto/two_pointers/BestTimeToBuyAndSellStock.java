package br.com.hamamoto.two_pointers;

/**
 *<a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock"> LeetCode problem </a>
 * - Best time to buy and sell stock
 * */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            int currentProfit = prices[right] - prices[left];

            if (currentProfit > 0) {
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                left = right;
            }

            right++;
        }

        return maxProfit;
    }
}
