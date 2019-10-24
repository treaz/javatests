package com.horiaconstantin.ctci.linkedlists;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class LinkedListNode {
    @Getter
    private int data;
    @Getter
    @Setter
    private LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public LinkedListNode add(@NonNull int value) {
        LinkedListNode linkedListNode = new LinkedListNode(value);
        LinkedListNode last = this;
        while (last.next != null) {
            last = last.next;
        }
        last.next = linkedListNode;
        return this;
    }

    public LinkedListNode remove(@NonNull LinkedListNode head, int value) {
        LinkedListNode current = head;
        if (current.data == value) {
            return current.next;
        }
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
}
