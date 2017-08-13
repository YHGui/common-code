package week10.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katsura on 2017/5/10.
 */
public class HuffmanEncoder {
    public static Map<Character, Integer> buildFrequencyTable(char[] inputSymbols) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < inputSymbols.length; i++) {
            if (!hash.containsKey(inputSymbols[i])) {
                hash.put(inputSymbols[i], 1);
            } else {
                int count = hash.get(inputSymbols[i]);
                hash.put(inputSymbols[i], count + 1);
            }
        }
        return hash;
    }

    public static void main(String[] args) {
        char[] inputSymbols = FileUtils.readFile(args[0]);
        Map<Character, Integer> hashFreq = buildFrequencyTable(inputSymbols);
        BinaryTrie trie = new BinaryTrie(hashFreq);
        Map<Character, BitSequence> hash = trie.buildLookupTable();
        ObjectWriter ow = new ObjectWriter(args[0] + ".huf");
        int num = hash.size();
//        Iterator iterator = hash.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            char ch = (char) entry.getKey();
//            BitSequence bitSequence = (BitSequence) entry.getValue();
//        }
        ArrayList<BitSequence> result = new ArrayList<>();
        for (char ch : inputSymbols) {
            BitSequence bitSequence = hash.get(ch);
            result.add(bitSequence);
        }
        BitSequence results = BitSequence.assemble(result);
        ow.writeObject(trie);
        ow.writeObject(num);
        ow.writeObject(results);

        ObjectReader or = new ObjectReader(args[0] + ".huf");
        BinaryTrie trieOut = (BinaryTrie) or.readObject();
        Integer count = (Integer) or.readObject();
        BitSequence bitSequence = (BitSequence) or.readObject();
        System.out.println(trieOut);
        System.out.println(count);
        System.out.println(bitSequence);
        System.out.println(bitSequence.length());
    }

}
