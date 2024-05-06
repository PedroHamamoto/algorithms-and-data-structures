package br.com.hamamoto.lists.linked_list;

/**
 * <a href="https://leetcode.com/problems/remove-nodes-from-linked-list/> LeetCode problem </a>
 * - Remove Nodes From Linked List
 */
public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        head = reverse(head);

        var current = head;
        var currentMax = current.val;

        while (current.next != null) {
            if (current.next.val < currentMax) {
                current.next = current.next.next;
            } else {
                current = current.next;
                currentMax = current.val;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;

        while (head != null ) {
            var next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
    }

}
