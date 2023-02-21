package br.com.hamamoto.lists;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *<a href="https://leetcode.com/problems/implement-stack-using-queues/"> LeetCode problem </a>
 * - Implement Stack using Queues.
 * */
public class QueueStack {

    private Queue<Integer> queue;

    public QueueStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.offer(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}