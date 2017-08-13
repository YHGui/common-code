package week10.hw2.hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int N;
    private final int T;
    private double[] thresholds;
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N or T is less than 0");
        }
        this.N = N;
        this.T = T;
        thresholds = new double[T];
        monteCarloSimulation();
    }
    public void monteCarloSimulation() {
        int totalNum = N * N;
        for (int i = 0; i < T; i++) {
            int numOfOpen = 0;
            Percolation percolation = new Percolation(N);
            while (!percolation.percolates()) {
                int randRow = StdRandom.uniform(N);
                int randCol = StdRandom.uniform(N);
                if (!percolation.isOpen(randRow, randCol)) {
                    percolation.open(randRow, randCol);
                    numOfOpen += 1;
                }
            }
            double threshold = numOfOpen * 1.0 / totalNum;
            thresholds[i] = threshold;
        }
    }

    public double mean() {
        double result = StdStats.mean(thresholds);
        return result;
    }

    public double stddev() {
        double result = StdStats.stddev(thresholds);
        return result;
    }

    public double confidenceLow() {
        double result = mean() - 1.96 * Math.sqrt(stddev() / T);
        return result;
    }

    public double confidenceHigh() {
        double result = mean() + 1.96 * Math.sqrt(stddev() / T);
        return result;
    }

}                       
