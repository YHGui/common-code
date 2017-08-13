package week10.trie;

/**
 * Created by Katsura on 2017/5/8.
 */
public class Trie<T> {
    protected static final int CHAR_OFFSET = 97;
    protected static final int ALPHABET_COUNT = 26;

    protected TrieNode<T> root;

    public Trie() {
        this.root = new TrieNode<T>(ALPHABET_COUNT);
    }

    public void put(String word, T value) throws IllegalArgumentException{
        if (word == null) {
            throw new IllegalArgumentException();
        }
        word = word.toLowerCase();
        TrieNode<T> current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = charIndexAt(word, i);
            TrieNode<T> child = current.getChild(index);
            if (child == null) {
                child = new TrieNode<T>(ALPHABET_COUNT);
                current.setChildren(index, child);
            }
            current = child;
        }
        current.setValue(value);
    }

    public void remove(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        removeWorker(word, this.root, 0);
    }

    private void removeWorker(String word, TrieNode<T> node, int i) {
        if (i >= word.length()) {
            return;
        }
        int charIndex = charIndexAt(word, i);
        if (node.getChild(charIndex) == null) {
            return;
        }
        removeWorker(word, node.getChild(charIndex), i + 1);
        if (i == word.length() - 1) {
            node.getChild(charIndex).setValue(null);
        }
        if (node.getChild(charIndex).isEmpty()) {
            node.setChild(charIndex, null);
        }
    }

    public T get(String word) {
        TrieNode<T> result = getNodeAtLast(word);
        return result != null ? result.getValue() : null;
    }

    private TrieNode<T> getNodeAtLast(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return null;
        }
        prefix = prefix.toLowerCase();
        TrieNode<T> current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = charIndexAt(prefix, i);
            TrieNode<T> child = current.getChild(index);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }

    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    public void clear() {
        this.root = new TrieNode<T>(ALPHABET_COUNT);
    }
    private int charIndexAt(String word, int index) {
        return (int) word.charAt(index) - CHAR_OFFSET;
    }
}
