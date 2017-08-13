package ctrip;

/**
 * Created by Katsura on 2017/3/24.
 */
public class Ctrip1 {
    public static class ListNode {
        int value;
        ListNode next;
    }
    public static ListNode findKthToTail(ListNode head, int k) {
        if (k < 0 || head == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;
        head.next = new ListNode();
        head.next.value = 2;
        head.next.next = new ListNode();
        head.next.next.value = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;
        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;
        System.out.println(findKthToTail(head, 0).value); // 倒数第一个
        System.out.println(findKthToTail(head, 4).value); // 中间的一个
        System.out.println(findKthToTail(head, 8).value); // 倒数最后一个就是顺数第一个
        System.out.println(findKthToTail(head, 9));
    }
}
