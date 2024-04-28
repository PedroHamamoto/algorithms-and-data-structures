package br.com.hamamoto.strings;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix"> LeetCode problem </a>
 * - Longest Common Prefix
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        var prefix = strs[0];

        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

}
