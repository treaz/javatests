package com.horiaconstantin.ctci.linkedlists;

import lombok.NonNull;

public class ReverseList {

    public LinkedListNode solution(@NonNull LinkedListNode head) {
        LinkedListNode tempHead = new LinkedListNode(0);
        LinkedListNode reverse = reverse(head, tempHead);
        tempHead.add(reverse.getData());
        return tempHead.getNext();
    }

    private LinkedListNode reverse(@NonNull LinkedListNode head, LinkedListNode reversed) {
        if (head.getNext() == null) {
            return head;
        }
        reversed.add(reverse(head.getNext(), reversed).getData());
        return head;
    }
}
