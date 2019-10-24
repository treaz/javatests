package com.horiaconstantin.ctci.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RemoveDupsTest {

    RemoveDups dups;

    @BeforeEach
    void setup() {
        dups = new RemoveDups();
    }

    @ParameterizedTest(name = "{index} => duplicateElements=''{0}''")
    @ValueSource(ints = {1, 2, 3})
    void solutionWithBuffer(int repeated) {
        LinkedListNode node = getListWithSameElement(repeated);

        LinkedListNode linkedListNode = dups.solutionWithBuffer(node);

        assertNull(linkedListNode.getNext());
    }

    @ParameterizedTest(name = "{index} => duplicateElements=''{0}''")
    @ValueSource(ints = {1, 2, 3})
    void solutionWithoutBuffer(int repeated) {
        LinkedListNode node = getListWithSameElement(repeated);

        dups.solutionWithoutBuffer(node);

        assertNull(node.getNext());
    }

    @ParameterizedTest(name = "{index} => duplicateElements=''{0}''")
    @ValueSource(ints = {1, 2, 3})
    void solutionWithPrevious(int repeated) {
        LinkedListNode node = getListWithSameElement(repeated);

        dups.solutionWithPrevious(node);

        assertNull(node.getNext());
    }

    private LinkedListNode getListWithSameElement(int repeated) {
        LinkedListNode node = new LinkedListNode(1);
        for (int i = 1; i < repeated; i++) {
            node.add(1);
        }
        return node;
    }

    @Test
    void solutionWithBuffer() {
        LinkedListNode node = new LinkedListNode(1).add(1).add(1).add(3);

        LinkedListNode result = dups.solutionWithBuffer(node);

        assertEquals(3, result.getNext().getData());
    }

    @Test
    void solutionWithBuffer1() {
        LinkedListNode node = new LinkedListNode(1).add(0).add(2).add(1).add(3);

        LinkedListNode result = dups.solutionWithBuffer(node);

        assertEquals(3, result.getNext().getNext().getNext().getData());
    }

    @Test
    void solutionWithBuffer3() {
        LinkedListNode node = new LinkedListNode(1).add(2);

        LinkedListNode result = dups.solutionWithBuffer(node);

        assertEquals(2, result.getNext().getData());
    }

    @Test
    void solutionWithoutBuffer() {
        LinkedListNode node = new LinkedListNode(1).add(1).add(1).add(3);

        dups.solutionWithoutBuffer(node);

        assertEquals(3, node.getNext().getData());
    }

    @Test
    void solutionWithoutBuffer1() {
        LinkedListNode node = new LinkedListNode(1).add(0).add(2).add(1).add(3);

        dups.solutionWithoutBuffer(node);

        assertEquals(3, node.getNext().getNext().getNext().getData());
    }

    @Test
    void solutionWithoutBuffer3() {
        LinkedListNode node = new LinkedListNode(1).add(2);

        dups.solutionWithoutBuffer(node);

        assertEquals(2, node.getNext().getData());
    }
}