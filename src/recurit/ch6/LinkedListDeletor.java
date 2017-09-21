package recurit.ch6;


import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListDeletor {
    public Node deleteIfEquals(Node head, int value) {
        Node virtual = new Node(0);
        virtual.setNext(head);
        Node prev = virtual;
        while (prev.getNext() != null) {
            if (prev.getNext().getValue() != value) {
                prev = prev.getNext();
            } else {
                prev.setNext(prev.getNext().getNext());
            }
        }

        return virtual.getNext();
    }


    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListDeletor deletor = new LinkedListDeletor();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));;
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 2, 4, 3, 5)));
        Node.printLinkedList(deletor.deleteIfEquals(creator.createLinkedList(Arrays.asList(2, 2, 2, 2, 2, 2, 2)), 2));
    }
}
