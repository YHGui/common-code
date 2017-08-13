package week4.proj1b;

import week2.examples.StdRandom;

/** If you project is set up properly, this file should execute.
* One thing you might consider is to try printing out the sequence of
* operations */
public class StudentArrayDequeLauncher {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();

        for (int i = 0; i < 20; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
            } else {
                sad1.addFirst(i);
            }
        }

        sad1.printDeque();
        /* Helpful challenge: Modify this file so that it outputs the list of
           operations as a String. Use the OperationSequence class. */
    }
} 
