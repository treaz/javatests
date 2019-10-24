package com.horiaconstantin.ctci.linkedlists;

import lombok.NonNull;

/**
 * Returns the Kth to last element of a linkedlist.
 * k=1 -> last element
 * Performance: O(n)
 * Space: O(n)
 */
public class KthToLastWithRecursion implements KthToLast {

    public LinkedListNode solution(@NonNull LinkedListNode head, int k) {
        if (k < 1) {
            throw new IndexOutOfBoundsException("K must be at least 1");
        }
        IndexNode wrapper = new IndexNode();
        solutionWithRecursion(head, k, wrapper);
        if (k > wrapper.size) {
            throw new IndexOutOfBoundsException("List is smaller than k.");
        }
        return wrapper.node;
    }

    private int solutionWithRecursion(LinkedListNode head, int k, IndexNode result) {
        if (head == null) {
            return 0;
        }
        int index = solutionWithRecursion(head.getNext(), k, result) + 1;
        if (k == index) {
            result.node = head;
        }
        result.size = result.size + 1;
        return index;
    }

    private static class IndexNode {
        private LinkedListNode node;
        private int size;
    }
}


