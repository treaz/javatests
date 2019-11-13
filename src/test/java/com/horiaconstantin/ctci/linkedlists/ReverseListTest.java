package com.horiaconstantin.ctci.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseListTest {

    @Test
    void solution() {
        LinkedListNode head = new LinkedListNode(1).add(2).add(3);
        LinkedListNode reversed = new ReverseList().solution(head);
        Integer[] integers = reversed.toArray();

        assertArrayEquals(new Integer[]{3, 2, 1}, integers);

    }

    @Test
    void solutionOneElement() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode reversed = new ReverseList().solution(head);
        Integer[] integers = reversed.toArray();

        assertArrayEquals(new Integer[]{1}, integers);

    }
}