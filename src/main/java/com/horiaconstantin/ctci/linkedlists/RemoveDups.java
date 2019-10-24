package com.horiaconstantin.ctci.linkedlists;

import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    private Set<Integer> set = new HashSet<>();

    /**
     * creates a new list with unique elements.
     * Does not change the structure of the head argument
     */
    public LinkedListNode solutionWithBuffer(@NonNull LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode newHead = new LinkedListNode(current.getData());
        set.add(current.getData());
        current = current.getNext();

        while (current != null) {
            int data = current.getData();
            if (set.add(data)) {
                newHead.add(data);
            }
            current = current.getNext();
        }
        return newHead;
    }

    /**
     * Uses no buffer. Uses a set to keep track of unique elements.
     * Changes the structure of the head argument
     */
    public void solutionWithPrevious(@NonNull LinkedListNode head) {
        LinkedListNode previous = null;

        while (head != null) {
            int data = head.getData();
            if (set.add(data)) {
                previous = head;
            } else {
                previous.setNext(head.getNext());
            }
            head = head.getNext();
        }
    }

    /**
     * Uses no buffer. Doesn't use a set, instead uses a runner pointer
     * Changes the structure of the head argument
     */
    public void solutionWithoutBuffer(@NonNull LinkedListNode head) {
        if (head.getNext() == null) {
            return;
        }
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();

                }
            }
            current = current.getNext();

        }
    }
}
