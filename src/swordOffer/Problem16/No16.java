package swordOffer.Problem16;

import swordOffer.Problem5.ListNode;

public class No16 {
    public static void main(String[] args) {

    }

    private static ListNode getMid(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
}
