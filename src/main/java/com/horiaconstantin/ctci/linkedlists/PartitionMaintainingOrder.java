package com.horiaconstantin.ctci.linkedlists;

import lombok.NonNull;

public class PartitionMaintainingOrder {

    /**
     * Performance: O(n)
     */
    public LinkedListNode solution(@NonNull LinkedListNode head, int pivot) {
        LinkedListNode lower = null;
        LinkedListNode higher = null;
        LinkedListNode lowerStart = null;
        while (head != null) {
            int value = head.getData();
            if (value >= pivot) {
                higher = higher == null ? new LinkedListNode(value) : higher.add(value);
            } else {
                if (lower == null) {
                    lower = new LinkedListNode(value);
                    lowerStart = lower;
                } else {
                    lower.setNext(new LinkedListNode(value));
                    lower = lower.getNext();
                }
            }
            head = head.getNext();
        }
        if (lower == null) {
            return higher;
        }
        lower.setNext(higher);
        return lowerStart;
    }
}
