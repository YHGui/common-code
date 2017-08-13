package week3.discussion;

/**
 * Created by Katsura on 2017/2/25.
 */
public class SLList {
    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode (int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst (int x) {
        first = new IntNode(x, first);
    }

    public void insert (int item, int position) {
        if (first == null || position == 0) {
            addFirst(item);
            return;
        }

        IntNode currentNode = first;
        while (position > 1 && currentNode.next != null) {
            position--;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;

    }

    public void reverse () {
        //思路一：对于每个节点，首先将其插入到新链表的首端。
        // 作法：使用两个指针，一个指向新链表的首端(frontOfReversed)，另一个指向旧链表中要翻转的节点(nextNodeToAdd)
        IntNode frontOfReversed = null;
        IntNode nextNodeToAdd = first;

        while (nextNodeToAdd != null) {
            IntNode remainderOfOriginal = nextNodeToAdd.next;
            nextNodeToAdd.next = frontOfReversed;
            frontOfReversed = nextNodeToAdd;
            nextNodeToAdd = remainderOfOriginal;
        }

        first = frontOfReversed;
    }

    public void reverseRecursive() {
        first = reverseRecursiveHelper(first);
        //递归思路：对每一个链表的首端节点进行翻转，同时首端节点往后移
    }

    private IntNode reverseRecursiveHelper (IntNode front) {
        if (front == null || front.next == null) {
            return front;
        } else {
            //翻转除首端节点外的所有节点
            IntNode reversed = reverseRecursiveHelper(front.next);
            //将front首端节点放置于翻转后节点的末端
            //由于首端节点外所节点已经翻转好了，那么原首端节点后一个节点是最近被翻转的。
            //将最后一个被翻转的节点指向(连接)首端节点，因此首端节点成了最后被翻转的
            front.next.next = front;
            //由于首端节点如今是最后一个节点，它应该指向null
            front.next = null;
            return reversed;
        }
    }
}
