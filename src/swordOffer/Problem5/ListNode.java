package swordOffer.Problem5;

public class ListNode {
    String data;
    ListNode next;

    public ListNode(String data) {
        super();
        this.data = data;
    }

    public ListNode(String data, ListNode next) {
        super();
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
