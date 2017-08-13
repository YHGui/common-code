package week4.proj1b.katsura;

import org.junit.Test;
import week2.examples.StdRandom;
import week4.proj1b.StudentArrayDeque;

/**
 * Created by Katsura on 2017/2/28.
 */
public class TestArrayDeque1B {

    @Test
    public void testAdd() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                System.out.println("after add last element" + i +" : ");
                sad1.printDeque();
            } else {
                sad1.addFirst(i);
                System.out.println("after add first element" + i +" : ");
                sad1.printDeque();
            }
        }

    }

    @Test
    public void testRemove() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            sad1.addFirst(i);
        }

        sad1.printDeque();

        for (int i = 0; i < 10; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.removeLast();
                System.out.println("after remove last element: ");
                sad1.printDeque();
            } else {
                sad1.removeFirst();
                System.out.println("after remove first element: ");
                sad1.printDeque();
            }
        }
    }
}
