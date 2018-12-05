package swordOffer.Problem5;

public class No5 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode("A");
        ListNode node2 = new ListNode("B");
        ListNode node3 = new ListNode("C");
        ListNode node4 = new ListNode("D");
        ListNode node5 = new ListNode("E");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        ListNode newNode = reverse2(node1);
        while (newNode != null) {
            System.out.println(newNode.data + " ");
            newNode = newNode.getNext();
        }

    }

    /**
     * 递归形式：
     * 递归三要素：
     * 1、递归的定义： 接受参数，返回什么值，做了什么事，在这里反转链表reverse接受链表，返回新的链表，
     * 并将当前节点设为反转后的next节点的next节点
     * 递归的拆解：当前节点和反转后链表
     * 递归的出口：当链表只有一个节点时，直接返回该节点
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode reverseHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reverseHead;

    }

    /**
     * 非递归形式
     * prev和curr节点，temp节点，首先保留curr节点的next节点，然后将curr节点的next节点设为prev节点，
     * 然后将prev节点和curr节点同时往前平移
     * 直到curr节点为null
     * 最后将head节点的next节点设为null
     * 最后的prev节点变成第一个节点
     * @param head
     * @return
     */
    private static ListNode reverse2(ListNode head) {

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode temp;
        while (curr != null) {
            temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }

        head.setNext(null);

        return prev;

    }
}
