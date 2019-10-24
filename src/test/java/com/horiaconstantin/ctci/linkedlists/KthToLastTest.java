package com.horiaconstantin.ctci.linkedlists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KthToLastTest {

    @ParameterizedTest
    @ValueSource(classes = {KthToLastWithRunner.class, KthToLastWithRecursion.class})
    void getLastElement(Class<KthToLast> clazz) throws Exception {
        KthToLast algo = clazz.getConstructor().newInstance();
        LinkedListNode head = new LinkedListNode(1).add(1).add(1).add(3);

        LinkedListNode result = algo.solution(head, 1);

        assertEquals(3, result.getData());
    }

    @ParameterizedTest
    @ValueSource(classes = {KthToLastWithRunner.class, KthToLastWithRecursion.class})
    void kIs3(Class<KthToLast> clazz) throws Exception {
        KthToLast algo = clazz.getConstructor().newInstance();
        LinkedListNode head = new LinkedListNode(1).add(2).add(1).add(3);

        LinkedListNode result = algo.solution(head, 3);

        assertEquals(2, result.getData());
    }

    @ParameterizedTest
    @ValueSource(classes = {KthToLastWithRunner.class, KthToLastWithRecursion.class})
    void kIsOutOfBounds(Class<KthToLast> clazz) throws Exception {
        KthToLast algo = clazz.getConstructor().newInstance();
        LinkedListNode head = new LinkedListNode(1).add(2).add(1).add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> algo.solution(head, 5));
    }

    @ParameterizedTest
    @ValueSource(classes = {KthToLastWithRunner.class, KthToLastWithRecursion.class})
    void listWithOneElement(Class<KthToLast> clazz) throws Exception {
        KthToLast algo = clazz.getConstructor().newInstance();
        LinkedListNode head = new LinkedListNode(100);

        LinkedListNode result = algo.solution(head, 1);

        assertEquals(100, result.getData());
    }

    @ParameterizedTest
    @ValueSource(classes = {KthToLastWithRunner.class, KthToLastWithRecursion.class})
    void kIs0(Class<KthToLast> clazz) throws Exception {
        KthToLast algo = clazz.getConstructor().newInstance();
        LinkedListNode head = new LinkedListNode(100);

        assertThrows(IndexOutOfBoundsException.class, () -> algo.solution(head, 0));
    }
}