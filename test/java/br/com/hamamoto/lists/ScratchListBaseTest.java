package br.com.hamamoto.lists;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScratchListBaseTest {
    
    static void testList(ScratchList<Integer> list) {
        populate(list);
        assertEquals(11, list.size());
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", list.toString());

        list.remove(10);
        assertEquals(10, list.size());
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());

        list.remove(4);
        assertEquals(9, list.size());
        assertEquals("[0, 1, 2, 3, 5, 6, 7, 8, 9]", list.toString());

        assertEquals(0, list.get(0));
        assertEquals(8, list.get(7));
    }

    public static void populate(ScratchList<Integer> list) {
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
    }

}