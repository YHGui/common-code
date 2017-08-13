package week8.lab;

import edu.princeton.cs.algs4.Stopwatch;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/** Performs a timing test on three different set implementations.
 *  For BSTMap purposes assumes that <K,V> are <String, Integer> pairs.
 *  @author Josh Hug 
 *  @author Brendan Hu
 */
public class InsertInOrderSpeedTest {
    /*
        Requests user input and performs tests of three different set
        implementations. ARGS is unused. 
    */
    public static void main(String[] args) throws IOException {
        int N;
        Scanner input = new Scanner(System.in);

        // borrow waitForPositiveInt(testScanner input) from InsertRandomSpeedTest
        InsertRandomSpeedTest i = new InsertRandomSpeedTest();

        System.out.println("\n This program inserts lexicographically increasing Strings"
                           + "into Maps as <String, Integer> pairs.");

        String repeat = "y";
        do {
            System.out.print("\nEnter # strings to insert into ULLMap: ");
            timeInOrderMap61B(new ULLMap<String, Integer>(),
                              i.waitForPositiveInt(input));
       
            System.out.print("\nEnter # strings to insert into BSTMap: ");
            timeInOrderMap61B(new BSTMap<String, Integer>(),
                              i.waitForPositiveInt(input));
    
            System.out.print("\nEnter # strings to insert into Java's TreeMap: ");
            timeInOrderTreeMap(new TreeMap<String, Integer>(), 
                              i.waitForPositiveInt(input));                        

            System.out.print("\nWould you like to try more timed-tests? (y/n): ");
            repeat = input.nextLine();
        } while (!repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("no"));
        input.close();
    }

    /* 
        Returns time needed to put N strings into a Map61B in increasing order.
        makes use of StringUtils.nextString(String s)
     */
    public static double insertInOrder(Map61B<String, Integer> map61B, int N) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.nextString(s);
            map61B.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }
    
    /** Returns time needed to put N strings into TreeMap in increasing order.
     */
    public static double insertInOrder(TreeMap<String, Integer> ts, int N) {
        Stopwatch sw = new Stopwatch();
        String s = "cat";
        for (int i = 0; i < N; i++) {
            s = StringUtils.nextString(s);
            ts.put(s, new Integer(i));
        }
        return sw.elapsedTime();
    }

    /*
        Attempts to insert N in-order strings of length L into map,
        Prints time of the N insert calls, otherwise
        Prints a nice message about the error
    */
    public static void timeInOrderMap61B(Map61B<String, Integer> map, int N) {        
        try {
            double mapTime = insertInOrder(map, N);
            System.out.printf(map.getClass() + ": %.2f sec\n", mapTime);
        } catch (StackOverflowError e) { 
            printInfoOnStackOverflow(N); 
        } catch (RuntimeException e) { 
            e.printStackTrace(); 
        }
    }

    /*
        Attempts to insert N in-order strings of length L into TreeMap,
        Prints time of the N insert calls, otherwise
        Prints a nice message about the error
    */
    public static void timeInOrderTreeMap(TreeMap<String, Integer> treeMap, int N) {        
        try {
            double javaTime = insertInOrder(treeMap, N);
            System.out.printf("Java's Built-in TreeMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) { 
            printInfoOnStackOverflow(N); 
        } catch (RuntimeException e) { 
            e.printStackTrace(); 
        }
    }

    /* ------------------------------- Private methods ------------------------------- */

    /*
        To be called after catching a StackOverflowError
        Prints the error with corresponding N and L
    */
    private static void printInfoOnStackOverflow(int N) {
        System.out.println("--Stack Overflow -- couldn't add " + N + " strings.");
    }
}
