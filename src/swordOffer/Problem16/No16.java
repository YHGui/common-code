package swordOffer.Problem16;

import swordOffer.Problem5.ListNode;

public class No16 {
    public static void main(String[] args) {
        ListNode a = new ListNode("1");
        ListNode b = new ListNode("2");
        ListNode c = new ListNode("3");
        ListNode d = new ListNode("4");
        ListNode e = new ListNode("5");
        ListNode f = new ListNode("6");
        ListNode g = new ListNode("7");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);

        ListNode mid = getMid(a);
        System.out.println(mid.getData());
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
