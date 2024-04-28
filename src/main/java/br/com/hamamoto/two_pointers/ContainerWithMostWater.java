package br.com.hamamoto.two_pointers;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/description> LeetCode problem </a>
 * - Container With Most Water
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        var maxArea = 0;
        var left = 0;
        var right = height.length - 1;

        while (left <= right) {
            var min = Math.min(height[left], height[right]);
            var distance = right - left;

            maxArea = Math.max(maxArea, distance * min);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
