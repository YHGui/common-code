package week9.hw3.hw3.puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState{
    public static final int BLANK = 0;
    private int[][] tiles;
    //不能直接操作数组tiles，因为他指向null
    public Board(int[][] x) {
        tiles = copy(x);
    }
    private int[][] copy(int[][] blocks) {
        int[][] copy = new int[blocks.length][blocks.length];
        for (int row = 0; row < blocks.length; row++)
            for (int col = 0; col < blocks.length; col++)
                copy[row][col] = blocks[row][col];

        return copy;
    }
    public int tileAt(int i, int j) {
        if (i >= tiles.length || j >= tiles.length) {
            throw new IndexOutOfBoundsException("i or j is out of bounds");
        }
        return tiles[i][j];
    }

    public int size() {
        return tiles.length;
    }

    //将其邻居都加入到其中
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        //找到空格的位置
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        //复制数组
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        //它的邻居为上下左右四个位置的值，注意需要恢复
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }
    public int hamming() {
        int len = size();
        int num = 1;
        int hamming = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (tileAt(i, j) != num) {
                    hamming++;
                }
                num++;
            }
        }
        return hamming;
    }
    public int manhattan() {
        int len = size();
        int manhattan = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (tileAt(i, j) != 0) {
                    manhattan += Math.abs((tileAt(i, j) - 1) / len - i) + Math.abs((tileAt(i, j) - 1) % len - j);
                }
            }
        }
        return manhattan;
    }
    public int estimatedDistanceToGoal() {
        return manhattan();
    }
    public boolean equals(Object y) {
        if (this == y) {
            return true;
        }
        if (y == null || getClass() != y.getClass()) {
            return false;
        }
        Board board = (Board)y;
        if (size() != board.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (tileAt(i, j) != board.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        if (tiles == null ) {
            result = 0;
        } else {
            for (int i = 0; i < size(); i++) {
                for (int j = 0; j < size(); j++) {
                    result = result * 31 + tileAt(i, j);
                }
            }
        }
        return result;
    }

    /** Returns the string representation of the board.
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
