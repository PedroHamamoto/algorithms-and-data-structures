package br.com.hamamoto.lists.linked_list;

/**
 * <a href="https://leetcode.com/problems/double-a-number-represented-as-a-linked-list> LeetCode problem </a>
 * - Double a Number Represented as a Linked List
 */
public class DoubleANumberRepresentedAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        var current = head;
        ListNode previous = null;

        while (current != null) {
            var valueTwice = current.val * 2;

            if (valueTwice < 10) {
                current.val = valueTwice;
            } else if (previous != null) {
                previous.val += 1;
                current.val = valueTwice % 10;
            } else {
                head = new ListNode(1, current);
                current.val = valueTwice % 10;
            }

            previous = current;
            current = current.next;
        }

        return head;
    }
}
