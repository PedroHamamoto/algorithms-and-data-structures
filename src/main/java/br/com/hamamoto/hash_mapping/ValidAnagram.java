package br.com.hamamoto.hash_mapping;

/**
 * <a href="https://leetcode.com/problems/valid-anagram> LeetCode problem </a>
 * - Valid Anagram
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        var frequencyArray = new int[26];

        for (var c : s.toCharArray()) {
            frequencyArray[c - 'a']++;
        }

        for (var c : t.toCharArray()) {
            frequencyArray[c - 'a']--;
        }

        for (int frequency : frequencyArray) {
            if (frequency != 0)
                return false;
        }

        return true;
    }

}
