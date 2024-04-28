package br.com.hamamoto.two_pointers;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted> LeetCode problem </a>
 * - Two Sum II - Input Array Is Sorted
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        var left = 0;
        var right = numbers.length - 1;
        var sum = numbers[left] + numbers[right];

        while (sum != target) {
            if (sum > target) {
                right--;
            } else {
                left++;
            }

            sum = numbers[left] + numbers[right];
        }

        return new int[] {left + 1, right + 1};
    }

}
