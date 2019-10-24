package com.horiaconstantin.ctci.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class LinkedListNodeTest {

    @Test
    void remove() {
        LinkedListNode head = new LinkedListNode(1).add(1).add(1);

        head = head.remove(head, 1);

        head = head.remove(head, 1);

        assertNull(head.getNext());
    }
}