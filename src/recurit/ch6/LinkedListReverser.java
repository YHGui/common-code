package recurit.ch6;


import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListReverser {

    /**
     * reverses a LinkedList
     * @param head
     * @return head of reversed linked list
     */
    public Node reverseLinkedList(Node head) {

        if(head == null || head.getNext() == null) {
            return head;
        }

        Node reversed = reverseLinkedList(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);

        return reversed;
    }

    public Node reverseLinkedListWithoutRecursive(Node head) {
        Node newHead = null;
        Node currentHead = head;
        while (currentHead != null) {
            Node next = currentHead.getNext();
            currentHead.setNext(newHead);
            newHead = currentHead;
            currentHead = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverser reverser = new LinkedListReverser();

        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1))));;
        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
        Node.printLinkedList(reverser.reverseLinkedListWithoutRecursive(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
    }
}
