package br.com.hamamoto.lists;

import java.util.Objects;

/**
 *<a href="https://leetcode.com/problems/design-linked-list/"> LeetCode problem </a> - Design a linked list.
 * I opted to design a doubly linked list
 * */
class MyLinkedList {

    private static class ListNode {
        ListNode next;
        ListNode previous;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Dummy nodes created to avoid edge cases
    private ListNode left;
    private ListNode right;


    public MyLinkedList() {
        left = new ListNode(0);
        right = new ListNode(0);

        left.next = right;
        right.previous = left;
    }
    
    public int get(int index) {
        ListNode current = left.next;

        while (Objects.nonNull(current) && index > 0) {
            current = current.next;
            index--;
        }

        if (index == 0 && Objects.nonNull(current) && current != right) {
            return current.val;
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode current = new ListNode(val);
        ListNode next = left.next;

        left.next = current;
        current.previous = left;
        current.next = next;
        next.previous = current;
        
    }
    
    public void addAtTail(int val) {
        ListNode current = new ListNode(val);
        ListNode previous = right.previous;

        right.previous = current;
        current.next = right;
        current.previous = previous;
        previous.next = current;
    }
    
    public void addAtIndex(int index, int val) {
        ListNode current = left.next;

        while (Objects.nonNull(current) && index > 0) {
            current = current.next;
            index--;
        }

        if (Objects.nonNull(current) && index == 0) {
            ListNode previous = current.previous;
            ListNode node = new ListNode(val);

            previous.next = node;
            node.previous = previous;
            node.next = current;
            current.previous = node;
        }
        
    }
    
    public void deleteAtIndex(int index) {
        ListNode current = left.next;

        while (Objects.nonNull(current) && index > 0) {
            current = current.next;
            index--;
        }

        if (index == 0 && Objects.nonNull(current) && current != right) {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
    }
}
