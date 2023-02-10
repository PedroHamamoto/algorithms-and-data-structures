package br.com.hamamoto.lists;

import org.junit.jupiter.api.Test;

class ScratchVectorTest {

    @Test
    void shouldPerformCommonOperations() {
        ScratchListBaseTest.testList(new ScratchVector<>());
    }

}