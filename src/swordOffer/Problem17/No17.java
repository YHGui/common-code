package swordOffer.Problem17;

import lintcode.week9.ListNode;

public class No17 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(13);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(3);
        ListNode h = new ListNode(9);
        a.next = c;
        c.next = d;
        e.next = g;
        g.next = f;
        f.next = h;
        h.next = b;


        ListNode finalNode = mergeTwoLists2(a, e);
        while (finalNode != null) {
            System.out.println(finalNode.val);
            finalNode = finalNode.next;
        }

    }

    private static ListNode mergeTwoLists(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                tail = left;
                left = left.next;
            } else {
                tail.next = right;
                tail = right;
                right = right.next;
            }

        }

        if (left != null) {
            tail.next = left;
        }

        if (right != null) {
            tail.next = right;
        }

        return dummy.next;
    }

    private static ListNode mergeTwoLists2(ListNode left, ListNode right) {
        if (null == left) {
            return right;
        } else if (null == right) {
            return left;
        }

        ListNode newHead = null;
        if (left.val < right.val) {
            newHead = left;
            newHead.next = mergeTwoLists2(left.next, right);
        } else {
            newHead = right;
            newHead.next = mergeTwoLists2(left, right.next);
        }

        return newHead;
    }
}
