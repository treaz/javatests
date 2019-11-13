package com.horiaconstantin.ctci.linkedlists;

public class SumListsReversed {

    /**
     * Solution assumes lists are of equals length
     */
    public LinkedListNode solution(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode result = null;
        int carry = 0;
        while (l1 != null) {
            int sum = l1.getData() + l2.getData() + carry;
            carry = 0;
            if (sum / 10 == 1) {
                carry = 1;
                result = result == null ? new LinkedListNode(sum % 10) : result.add(sum % 10);
            } else {
                result = result == null ? new LinkedListNode(sum) : result.add(sum);
            }
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        if (carry > 0) {
            result.add(carry);
        }
        return result;
    }
}
