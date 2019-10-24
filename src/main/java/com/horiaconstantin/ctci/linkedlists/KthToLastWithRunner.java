package com.horiaconstantin.ctci.linkedlists;

import lombok.NonNull;

/**
 * Returns the Kth to last element of a linkedlist.
 * k=1 -> last element
 * Performance: O(n)
 * Space: O(1)
 */
public class KthToLastWithRunner implements KthToLast {

    public LinkedListNode solution(@NonNull LinkedListNode head, int k) {
        if (k < 1) {
            throw new IndexOutOfBoundsException("K must be at least 1");
        }
        LinkedListNode current = head;
        LinkedListNode runner = head;
        for (int i = 1; i < k; i++) {
            if (runner.getNext() == null)
                throw new IndexOutOfBoundsException("List is smaller than k.");
            runner = runner.getNext();
        }
        while (runner.getNext() != null) {
            current = current.getNext();
            runner = runner.getNext();
        }

        return current;
    }

}