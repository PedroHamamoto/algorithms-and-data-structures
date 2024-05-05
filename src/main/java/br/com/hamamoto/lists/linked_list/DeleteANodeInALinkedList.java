package br.com.hamamoto.lists.linked_list;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-linked-list> LeetCode problem </a>
 * - Delete a Node in a Linked List
 */
public class DeleteANodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
