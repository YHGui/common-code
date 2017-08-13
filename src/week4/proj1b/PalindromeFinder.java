package week4.proj1b;

import week2.examples.In;
import week4.proj1b.katsura.OffByN;
import week4.proj1b.katsura.OffByOne;
import week4.proj1b.katsura.Palindrome;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("src/week4/proj1b/words.txt");
        OffByOne obo = new OffByOne();
        OffByN obn = new OffByN(3);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, obn)) {
                System.out.println(word);
            }
        }
    }
} 
