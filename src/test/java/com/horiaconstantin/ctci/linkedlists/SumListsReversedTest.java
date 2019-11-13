package com.horiaconstantin.ctci.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SumListsReversedTest {

    @Test
    void solution() {
        LinkedListNode l1 = new LinkedListNode(7).add(1).add(6);
        LinkedListNode l2 = new LinkedListNode(5).add(9).add(2);

        LinkedListNode solution = new SumListsReversed().solution(l1, l2);
        Integer[] integers = solution.toArray();

        assertArrayEquals(new Integer[]{2, 1, 9}, integers);
    }

    @Test
    void solution2() {
        LinkedListNode l1 = new LinkedListNode(9).add(9).add(9);
        LinkedListNode l2 = new LinkedListNode(5).add(9).add(2);

        LinkedListNode solution = new SumListsReversed().solution(l1, l2);
        Integer[] integers = solution.toArray();

        assertArrayEquals(new Integer[]{4, 9, 2, 1}, integers);
    }
}