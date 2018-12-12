package swordOffer.Problem15;

import swordOffer.Problem5.ListNode;

public class No15 {
    public static void main(String[] args) {
    }

    private static ListNode findKthOfTail(ListNode head, int k) {
        if (null == head || k <= 0) {
            return null;
        }

        ListNode p = head;

        for (int i = 0; i < k - 1; i++) {
            if (p.getNext() != null) {
                p = p.getNext();
            } else {
                return null;
            }
        }

        ListNode q = head;
        while (p.getNext() != null) {
            p = p.getNext();
            q = q.getNext();
        }

        return q;
    }
}
