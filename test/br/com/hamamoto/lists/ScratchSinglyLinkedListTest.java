package br.com.hamamoto.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScratchSinglyLinkedListTest {

    @Test
    void shouldPerformCommonOperations() {
        ScratchListBaseTest.testList(new ScratchSinglyLinkedList<>());
    }

    @Test
    void shouldReverse() {
        var list = new ScratchSinglyLinkedList<Integer>();
        ScratchListBaseTest.populate(list);

        assertEquals(11, list.size());
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", list.toString());

        list.reverse();
        assertEquals("[10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", list.toString());
    }

    @Test
    void shouldReverseWithASingleElement() {
        var list = new ScratchSinglyLinkedList<Integer>();
        list.add(10);
        list.reverse();

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        assertEquals("[10]", list.toString());

    }

    @Test
    void shouldReverseAnEmptyList() {
        var list = new ScratchSinglyLinkedList<Integer>();
        list.reverse();

        assertEquals("[]", list.toString());

    }

}