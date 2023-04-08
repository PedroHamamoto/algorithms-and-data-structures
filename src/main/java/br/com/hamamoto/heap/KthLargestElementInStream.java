package br.com.hamamoto.heap;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream"> LeetCode problem </a> -
 * Kth Largest Element in a Stream
 */
public class KthLargestElementInStream {

    private final int k;
    private PriorityQueue<Integer> heap = new PriorityQueue<>();

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;

        for (int n : nums)
            heap.offer(n);

        while (heap.size() > k)
            heap.poll();
    }

    public int add(int val) {
        heap.offer(val);

        if (heap.size() > k)
            heap.poll();

        return heap.peek();
    }
}
