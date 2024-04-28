package br.com.hamamoto.hash_mapping;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/word-pattern> LeetCode problem </a>
 * - Container With Most Water
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        var patternToWordMap = new HashMap<Character, String>();
        var wordToPatternMap = new HashMap<String, Character>();
        var words = s.split(" ");
        var i = 0;

        if (words.length != pattern.length())
            return false;

        for (var word : words) {
            if (wordToPatternMap.containsKey(word)) {
                if (!word.equals(patternToWordMap.get(pattern.charAt(i)))) {
                    return false;
                }
            } else if (patternToWordMap.containsKey(pattern.charAt(i))) {
                return false;
            } else {
                patternToWordMap.put(pattern.charAt(i), word);
                wordToPatternMap.put(word, pattern.charAt(i));
            }

            i++;
        }

        return true;
    }

}
