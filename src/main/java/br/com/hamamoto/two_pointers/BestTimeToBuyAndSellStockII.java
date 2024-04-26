package br.com.hamamoto.two_pointers;

/**
 *<a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-II"> LeetCode problem </a>
 * - Best time to buy and sell stock
 * */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit += prices[right] - prices[left];
            }

            left = right;
            right++;
        }

        return maxProfit;
    }
}
