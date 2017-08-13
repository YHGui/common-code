package week4.proj1b.katsura;


import week3.proj1a.ArrayDeque;

/**
 * Created by Katsura on 2017/3/1.
 */
public class Palindrome {

    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            result.addLast(word.charAt(i));
        }

        return result;
    }

    //不考虑使用Deque时检测回文
    public static boolean isPalindromeWithoutDeque(String word) {
        boolean result = false;
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            //当有一个回文检测不对，跳出循环，否则为true，继续循环
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                result = false;
                break;
            } else {
                result = true;
            }
        }

        return result;
    }

    //使用Deque检测回环
    //helper recursion
    private static boolean isPalindromeUsingDeque(Deque<Character> deque, int index) {
        char a_char = (char)deque.get(index);
        char b_char = (char)deque.get(deque.size() - 1 - index);
        if (a_char != b_char || index > deque.size() / 2) {
            return false;
        }
        if (index == (deque.size() / 2) - 1) {
            return true;
        }

        return isPalindromeUsingDeque(deque, index + 1);
    }

    public static boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);

        return isPalindromeUsingDeque(deque, 0);
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        Deque<Character> thisDeque = wordToDeque(word);
        return isPalindromeHelperCC(thisDeque, 0, cc);
    }

    private static boolean isPalindromeHelperCC(Deque<Character> thisDeque, int index, CharacterComparator cc) {
        char a_char = (char) thisDeque.get(index);
        char b_char = (char) thisDeque.get(thisDeque.size() - 1 - index);
        if ((!cc.equalChars(a_char, b_char)) || (index > (thisDeque.size() / 2))) {
            return false;
        }
        if (index == (thisDeque.size()/2)-1) {
            return true;
        }
        return isPalindromeHelperCC(thisDeque, index+1, cc);
    }


    public static void main(String[] args) {
        Deque<Character> wordList =  wordToDeque("ashdfsdkk");

        wordList.printDeque();
    }
}
