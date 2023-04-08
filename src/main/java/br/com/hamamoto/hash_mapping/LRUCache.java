package br.com.hamamoto.hash_mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache"> LeetCode problem </a> -
 * LRU Cache
 */
public class LRUCache {

    static class Node {
        Node previous;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Node left; // least recent
    private final Node right; // most recent
    private final Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.previous = left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            var node = cache.get(key);

            remove(node);
            append(node);

            return node.value;
        }

        return -1;
    }

    private void remove(Node node) {
        var previous = node.previous;
        var next = node.next;

        previous.next = next;
        next.previous = previous;
    }

    private void append(Node node) {
        var previous = right.previous;

        previous.next = node;
        node.previous = previous;
        node.next = right;
        right.previous = node;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key))
            remove(cache.get(key));

        cache.put(key, new Node(key, value));
        append(cache.get(key));

        if (cache.size() > capacity) {
            var node = left.next;
            remove(node);
            cache.remove(node.key);
        }
    }
}