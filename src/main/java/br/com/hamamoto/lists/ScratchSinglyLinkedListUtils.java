package br.com.hamamoto.lists;

import java.util.Objects;

public class ScratchSinglyLinkedListUtils {

    /**
     *<a href="https://leetcode.com/problems/merge-two-sorted-lists/"> LeetCode problem </a> - Merge two sorted linked
     * lists
     * */
    public static ScratchSinglyLinkedList<Integer> mergeSorted(ScratchSinglyLinkedList<Integer> list1,
                                                               ScratchSinglyLinkedList<Integer> list2) {
        var l1 = list1.getHead();
        var l2 = list2.getHead();

        var current = new ScratchSinglyLinkedList.Node<Integer>();
        ScratchSinglyLinkedList.Node<Integer> head = current;

        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.getData() < l2.getData()) {
                current.setNext(new ScratchSinglyLinkedList.Node<>(l1.getData()));
                l1 = l1.getNext();
            } else {
                current.setNext(new ScratchSinglyLinkedList.Node<>(l2.getData()));
                l2 = l2.getNext();
            }

            current = current.getNext();
        }

        current.setNext(Objects.isNull(l1)? l2 : l1);

        return new ScratchSinglyLinkedList<>(head.getNext());
    }
}
