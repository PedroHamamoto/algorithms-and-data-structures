package br.com.hamamoto.sliding_window;

public class LongestStringWithoutRepeatingCharacters {

    /**
     * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">
     * LeetCode problem </a> - Longest String Without Repeating Characters
     * */
   public int lengthOfLongestSubstring(String s) {
        var appeared  = new boolean[128];
        int left = 0;
        int right = 0;

        int longest = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (appeared[c]) {
                appeared[s.charAt(left)] = false;
                left++;
            } else {
                appeared[c] = true;
                right++;
                longest = Math.max(longest, right - left);
            }


        }

        return longest;
    }
}
