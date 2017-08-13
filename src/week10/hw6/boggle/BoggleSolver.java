package week10.hw6.boggle;

import edu.princeton.cs.algs4.*;

/**
 * Created by Katsura on 2017/5/8.
 */
public class BoggleSolver {
    private final TrieSET dict;
    private SET<String> validWords;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        dict = new TrieSET();
        for (String word : dictionary)
            dict.add(word);
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        validWords = new SET<>();
        int M = board.rows(), N = board.cols();

        // construct boggle board graph
        Graph G = toGraph(board);

        // search word path with depth first search
        for (int v = 0; v < G.V(); v++) {
            dict.resetSearch();
            dfs(board, G, v, new boolean[M*N]);
        }
        return validWords;
    }

    private void dfs(BoggleBoard board, Graph G, int v, boolean[] marked) {
        int N = board.cols();
        char c = board.getLetter(v / N, v % N);

        if (!dict.oneStepForward(c)) return;

        if (c == 'Q')
            if (!dict.oneStepForward('U')) {
                dict.oneStepBackward();
                return;
            }

        marked[v] = true;

        String word = dict.pathToString();
        if (word.length() > 2 && dict.isWord()) validWords.add(word);

        // get into v's neighbors
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(board, G, w, marked);

        // step backward
        dict.oneStepBackward();
        if (c == 'Q') {
            dict.oneStepBackward();
        }
        marked[v] = false;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (!dict.contains(word)) return 0;
        if (word.length() <= 2) return 0;
        if (word.length() == 3 || word.length() == 4) return 1;
        if (word.length() == 5) return 2;
        if (word.length() == 6) return 3;
        if (word.length() == 7) return 5;
        return 11;
    }

    /**
     *  Helper Methods
     */
    private Graph toGraph(BoggleBoard board) {
        int M = board.rows(), N = board.cols();
        Graph G = new Graph(M*N);
        boolean[] marked = new boolean[M*N];
        for (int i = 0; i < M*N; i++) {
            marked[i] = true;
            for (int adj : getAdjacent(board, i))
                if (!marked[adj]) G.addEdge(i, adj);
        }
        return G;
    }

    private int xyTo1D(BoggleBoard board, int x, int y) {
        return x + y*board.cols();
    }

    private Iterable<Integer> getAdjacent(BoggleBoard board, int i) {
        Bag<Integer> neighbors = new Bag<>();
        int M = board.rows(), N = board.cols();
        int x = i % N, y = i / N;

        for (int p = x-1; p <= x+1; p++)
            for (int q = y-1; q <= y+1; q++)
                if (p >= 0 && p < N && q >= 0 && q < M) {
                    if (p == x && q == y) continue;
                    int v = xyTo1D(board, p, q);
                    neighbors.add(v);
                }
        return neighbors;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        int score = 0;
        int cnt = 0;
        for (String word : solver.getAllValidWords(board))
        {
            cnt++;
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.printf("Count:%d    Score = %d\n", cnt, score);
    }
}
