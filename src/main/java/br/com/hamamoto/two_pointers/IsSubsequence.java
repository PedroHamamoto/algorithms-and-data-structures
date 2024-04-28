package br.com.hamamoto.two_pointers;

/**
 * <a href="https://leetcode.com/problems/is-subsequence> LeetCode problem </a>
 * - Is Subsequence
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;

        var sIndex = 0;
        var tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }

            tIndex++;
        }

        return sIndex == s.length();

    }

}
