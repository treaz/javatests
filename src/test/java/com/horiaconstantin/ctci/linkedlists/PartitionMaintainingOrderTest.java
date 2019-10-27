package com.horiaconstantin.ctci.linkedlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PartitionMaintainingOrderTest {

    private PartitionMaintainingOrder algo;

    @BeforeEach
    void setup() {
        algo = new PartitionMaintainingOrder();
    }

    @Test
    void solution() {
        LinkedListNode head = new LinkedListNode(3).add(5).add(8).add(5).add(10).add(2).add(1);

        LinkedListNode actual = algo.solution(head, 5);
        Integer[] array = actual.toArray();

        assertArrayEquals(new Integer[]{3, 2, 1, 5, 8, 5, 10}, array);
    }

    @Test
    void solutionAbovePivot() {
        LinkedListNode head = new LinkedListNode(30).add(5).add(8).add(5).add(10).add(20).add(10);

        LinkedListNode actual = algo.solution(head, 5);
        Integer[] array = actual.toArray();

        assertArrayEquals(new Integer[]{30, 5, 8, 5, 10, 20, 10}, array);
    }

    @Test
    void solutionUnderPivot() {
        LinkedListNode head = new LinkedListNode(30).add(5).add(8).add(5).add(10).add(20).add(10);

        LinkedListNode actual = algo.solution(head, 50);
        Integer[] array = actual.toArray();

        assertArrayEquals(new Integer[]{30, 5, 8, 5, 10, 20, 10}, array);
    }

    @Test
    void solutionPivotNotInList() {
        LinkedListNode head = new LinkedListNode(3).add(5).add(8).add(5).add(10).add(20).add(1);

        LinkedListNode actual = algo.solution(head, 6);
        Integer[] array = actual.toArray();

        assertArrayEquals(new Integer[]{3, 5, 5, 1, 8, 10, 20}, array);
    }

    @Test
    void solutionOneElement() {
        LinkedListNode head = new LinkedListNode(1);

        LinkedListNode actual = algo.solution(head, 6);
        Integer[] array = actual.toArray();

        assertArrayEquals(new Integer[]{1}, array);
    }
}