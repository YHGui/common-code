package week10.hw7;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Katsura on 2017/5/10.
 */
public class BinaryTrie implements Serializable{
    Queue<Node> heap = new PriorityQueue<>();
    private static class Node implements Comparable<Node>, Serializable{
        private final char ch;
        private final int freq;
        private final Node left, right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            return (left == null) && (right == null);
        }

        public char getCh() {
            return ch;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }
    public BinaryTrie(Map<Character, Integer> frequencyTable) {
        Iterator iterator = frequencyTable.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            Node newNode = new Node(key, val, null, null);
            heap.offer(newNode);
        }
        while (heap.size() > 1) {
            Node left = heap.poll();
            Node right = heap.poll();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            heap.offer(parent);
        }
    }
    public Match longestPrefixMatch(BitSequence querySequence) {
        Node huffNode = heap.peek();
        int len = querySequence.length();
        String str = "";
        for (int i = 0; i < len; i++) {
            int bit = querySequence.bitAt(i);
            if (bit == 0) {
                if (huffNode.left != null) {
                    huffNode = huffNode.left;
                    str = str + bit;
                } else {
                    break;
                }
            } else {
                if (huffNode.right != null) {
                    huffNode = huffNode.right;
                    str = str + bit;
                } else {
                    break;
                }
            }
        }
        char ch = huffNode.getCh();
        BitSequence bitSequence = new BitSequence(str);
        return new Match(bitSequence, ch);
    }
    public Map<Character, BitSequence> buildLookupTable() {
        Map<Character, BitSequence>  hufMap = new HashMap<>();
        Node hufNode= heap.peek();
        getHufmanCode(hufNode, "", hufMap);
        return hufMap;
    }

    private void getHufmanCode(Node hufNode, String code, Map<Character, BitSequence> hfmMap) {
        if (!hufNode.isLeaf()) {
            getHufmanCode(hufNode.left, code + '0', hfmMap);
            getHufmanCode(hufNode.right, code + '1', hfmMap);
        } else {
            hfmMap.put(hufNode.getCh(), new BitSequence(code));
        }
    }
}
