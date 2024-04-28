package br.com.hamamoto.hash_mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/group-anagrams> LeetCode problem </a>
 * - Group Anagrams
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (var word : strs) {
            var wordChars = word.toCharArray();
            Arrays.sort(wordChars);

            var sorted = new String(wordChars);

            List<String> anagramList;
            anagramList = map.getOrDefault(sorted, new ArrayList<>());
            anagramList.add(word);

            map.put(sorted, anagramList);
        }

        return map.values().stream().toList();
    }

}
