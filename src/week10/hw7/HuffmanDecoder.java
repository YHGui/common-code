package week10.hw7;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Katsura on 2017/5/10.
 */
public class HuffmanDecoder {
    public static void main(String[] args) {
        ObjectReader or = new ObjectReader(args[0]);
        BinaryTrie trie = (BinaryTrie) or.readObject();
        Integer num = (Integer) or.readObject();
        BitSequence bitSequence = (BitSequence) or.readObject();
        PriorityQueue heap = (PriorityQueue) trie.heap;
        ArrayList<Character> list = new ArrayList<>();
        while (bitSequence.length() > 0) {
            Match match = trie.longestPrefixMatch(bitSequence);
            char ch = match.getSymbol();
            list.add(ch);
            int bitNum = match.getSequence().length();
            bitSequence = bitSequence.allButFirstNBits(bitNum);
        }
        int size = list.size();
        char[] charArr = new char[size];
        for (int i = 0; i < size; i++) {
            charArr[i] = list.get(i);
        }
        FileUtils.writeCharArray(args[1], charArr);

    }
}
