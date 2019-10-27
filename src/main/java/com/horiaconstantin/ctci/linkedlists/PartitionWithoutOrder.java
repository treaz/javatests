package com.horiaconstantin.ctci.linkedlists;

public class PartitionWithoutOrder {

    /**
     * Performance: O(n^2)
     */
    public void solution(LinkedListNode head, LinkedListNode pivot) {
        while (head != null) {
            if (head.getData() >= pivot.getData()) {
                LinkedListNode runner = head.getNext();
                while (runner != null) {
                    if (runner.getData() >= pivot.getData()) {
                        runner = runner.getNext();
                    } else {
                        int tmp = runner.getData();
                        runner.setData(head.getData());
                        head.setData(tmp);
                        break;
                    }
                }
            }
            head = head.getNext();
        }
    }

    /**
     * Performance: O(n) can be acheived...
     */
}
