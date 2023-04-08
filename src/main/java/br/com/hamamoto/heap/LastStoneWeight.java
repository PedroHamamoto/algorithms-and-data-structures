package br.com.hamamoto.heap;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight"> LeetCode problem </a> - Last Stone Weight
 */
class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (int s : stones)
            heap.offer(s);

        while (heap.size() > 1) {
            var y = heap.poll();
            var x = heap.poll();

            if (!Objects.equals(x, y)) {
                heap.offer(y - x);
            }
        }

        return heap.size() > 0? heap.peek() : 0;
        
    }
}