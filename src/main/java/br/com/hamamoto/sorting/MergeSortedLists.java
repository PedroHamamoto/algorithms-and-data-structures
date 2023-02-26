package br.com.hamamoto.sorting;

import java.util.Objects;

/**
 *<a href="https://leetcode.com/problems/merge-k-sorted-lists"> LeetCode problem </a> - Merge K Sorted Lists
 * */
public class MergeSortedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        while (lists.length > 1) {
            int size = lists.length % 2 == 0 ?
                    lists.length / 2 :
                    lists.length / 2 + 1;
            ListNode[] temp = new ListNode[size];
            int j = 0;

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                temp[j++] = merge(l1, l2);
            }

            lists = temp;
        }

        return lists[0];
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode head = result;

        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val > list2.val) {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            }

            result = result.next;
        }

        if (Objects.isNull(list1)) {
            result.next = list2;
        } else {
            result.next = list1;
        }

        return head.next;
    }
}
