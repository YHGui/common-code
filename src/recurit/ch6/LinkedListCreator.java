package recurit.ch6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCreator {

    /**
     * creates a linked list
     * @param data
     * @return head of the linkedList
     */
    public Node createLinkedList(List<Integer> data) {

        if(data.isEmpty()) {
            return null;
        }

        Node firstNode = new Node(data.get(0));
        Node headOfSublist = createLinkedList(data.subList(1, data.size()));
        firstNode.setNext(headOfSublist);

        return firstNode;
    }
    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));;
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
