package swordOffer.Problem13;

import swordOffer.Problem5.ListNode;

public class No13 {
    public static void main(String[] args) {

    }

    private static ListNode deleteNode(ListNode head, ListNode node) {
        if (null == node || head == null) {
            return head;
        }

        if (head == node) {
            ListNode next = head.getNext();
            head = null;
            return next;
        } else {
            if (node.getNext() == null) {
                while (head.getNext() != node) {
                    head = head.getNext();
                }
                head.setNext(null);
            } else {
                node.setNext(node.getNext().getNext());
                node.setData(node.getNext().getData());
            }

            return head;
        }
    }
}
