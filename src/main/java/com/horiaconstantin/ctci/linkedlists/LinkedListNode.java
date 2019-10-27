package com.horiaconstantin.ctci.linkedlists;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
public class LinkedListNode {
    @Getter
    @Setter
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

    public Integer[] toArray() {
        List<Integer> list = new ArrayList<>();
        list.add(data);
        LinkedListNode next = this.getNext();
        while (next != null) {

            list.add(next.getData());
            next = next.getNext();
        }
        return list.toArray(Integer[]::new);
    }
}
