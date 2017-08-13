package week10.lab12;

import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>>
            makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> queues = new Queue<>();
        while (!items.isEmpty()) {
            Queue<Item> queue = new Queue<Item>();
            queue.enqueue(items.dequeue());
            queues.enqueue(queue);
        }
        return queues;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> queues = new Queue<Item>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Item item = getMin(q1,q2);
            queues.enqueue(item);
        }
        while (!q1.isEmpty()) {
            queues.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            queues.enqueue(q2.dequeue());
        }
        return queues;
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        Queue<Queue<Item>> queues = makeSingleItemQueues(items);
        while (queues.size() > 1){
            Queue<Item> q1 = queues.dequeue();
            Queue<Item> q2 = queues.dequeue();
            Queue<Item> doubleQ = mergeSortedQueues(q1, q2);
            queues.enqueue(doubleQ);
        }
        return queues.dequeue();
    }

    @Test
    public void testMergeSort() {
        Queue<String> students = new Queue<>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        Queue<String> actual = mergeSort(students);
        Queue<String> expect = new Queue<>();
        expect.enqueue("Alice");
        expect.enqueue("Ethan");
        expect.enqueue("Vanessa");
        assertEquals(expect.dequeue(), actual.dequeue());
        assertEquals(expect.dequeue(), actual.dequeue());
        assertEquals(expect.dequeue(), actual.dequeue());
    }
}
