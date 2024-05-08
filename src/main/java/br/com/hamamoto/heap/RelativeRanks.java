package br.com.hamamoto.heap;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/relative-ranks> LeetCode problem </a>
 * - Relative Ranks
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        var heap = new PriorityQueue<Map.Entry<Integer, Integer>>((p1, p2) -> (p2.getValue() - p1.getValue()));

        for (int i = 0; i < score.length; i++) {
            heap.offer(new AbstractMap.SimpleEntry<>(i, score[i]));
        }

        var ranks = new String[score.length];

        for (var i = 0; i < score.length; i++) {
            var top = heap.poll();
            var index = top.getKey();

            if (i == 0) {
                ranks[index] = "Gold Medal";
            } else if (i == 1) {
                ranks[index] = "Silver Medal";
            } else if (i == 2) {
                ranks[index] = "Bronze Medal";
            } else {
                ranks[index] = String.valueOf(i + 1);
            }
        }

        return ranks;
    }

}
