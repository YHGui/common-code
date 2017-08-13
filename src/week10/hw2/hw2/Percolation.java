package week10.hw2.hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Katsura on 2017/5/10.
 */
public class Percolation {
    private final int N;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF uf;
    private final int virtualBottom;
    private final int virtualTop;
    private int sizeOfOpen;

    public Percolation(int n) {
        N = n;
        grid = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N + 2);
        virtualBottom = N * N + 1;
        virtualTop = N * N;
        for (int i = 0; i < N; i++) {
            uf.union(virtualTop, xyTo1D(0, i));
        }
        for (int i = 0; i < N; i++) {
            uf.union(virtualBottom, xyTo1D(N - 1, i));
        }
    }

    private int xyTo1D(int row, int col) {
        return row * N + col;
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            grid[row][col] = true;
            sizeOfOpen += 1;

            int current = xyTo1D(row, col);

            int leftRow = row - 1;
            int left = xyTo1D(leftRow, col);
            if (isBoundAndOpen(leftRow, col)) {
                uf.union(current, left);
            }

            int rightRow = row + 1;
            int right = xyTo1D(rightRow, col);
            if (isBoundAndOpen(rightRow, col)) {
                uf.union(current, right);
            }

            int upCol = col + 1;
            int up = xyTo1D(row, upCol);
            if (isBoundAndOpen(row, upCol)) {
                uf.union(current, up);
            }

            int downCol = col - 1;
            int down = xyTo1D(row, downCol);
            if (isBoundAndOpen(row, downCol)) {
                uf.union(current, down);
            }
        }
    }

    private boolean isBoundAndOpen(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N && isOpen(row, col);
    }

    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        if (!isOpen(row, col)) {
            return false;
        }

        return uf.connected(xyTo1D(row, col), virtualTop);
    }

    public boolean percolates() {
        return uf.connected(virtualBottom, virtualTop);
    }

    public int numberOfOpenSites() {
        return sizeOfOpen;
    }
}
