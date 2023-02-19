package br.com.hamamoto.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScratchSinglyLinkedListUtilsTest {

    @Test
    void shouldMergeEvenSizeSortedLists() {
        var l1 = new ScratchSinglyLinkedList<Integer>();
        var l2 = new ScratchSinglyLinkedList<Integer>();

        l1.add(1);
        l1.add(4);
        l1.add(100);

        l2.add(2);
        l2.add(77);
        l2.add(1917);


        var merged = ScratchSinglyLinkedListUtils.mergeSorted(l1, l2);

        assertEquals(6, merged.size());
        assertEquals("[1, 2, 4, 77, 100, 1917]", merged.toString());
    }

}