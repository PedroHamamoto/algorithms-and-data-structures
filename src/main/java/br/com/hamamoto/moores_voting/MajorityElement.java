package br.com.hamamoto.moores_voting;

public class MajorityElement {

    /**
     *<a href="https://leetcode.com/problems/majority-element"> LeetCode problem </a>
     * - Majority Element
     * */
    public int majorityElement(int[] nums) {
        var count = 0;
        var candidate = 0;

        for (var n : nums) {
            if (count == 0)
                candidate = n;

            count += n == candidate? 1 : -1;
        }

        return candidate;
    }

}
