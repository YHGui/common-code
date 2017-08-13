package week10.hw5;

import edu.princeton.cs.algs4.Picture;

import java.awt.*;

/**
 * Created by Katsura on 2017/5/6.
 */
public class SeamCarver {
    private Picture picture;
    double[][] e = null;

    public SeamCarver(Picture picture) {
        this.picture = picture;
        e = energyMatrix();
    }

    // current picture
    public Picture picture(){
        return picture;
    }
    // width of current picture
    public int width() {
        return picture.width();
    }
    // height of current picture
    public int height() {
        return picture.height();
    }
    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        double totalEnergy = 0.0;
        int width = width();
        int height = height();
        int leftCol, rightCol, upRow, downRow;
        if (x - 1 < 0) {
            leftCol = x - 1 + width;
        } else {
            leftCol = x - 1;
        }
        if (x + 1 > width - 1) {
            rightCol = x + 1 - width;
        } else {
            rightCol = x + 1;
        }
        if (y - 1 < 0) {
            upRow = y - 1 + height;
        } else {
            upRow = y - 1;
        }
        if (y + 1 > height - 1) {
            downRow = y + 1 - height;
        } else {
            downRow = y + 1;
        }
        Color left = picture.get(leftCol, y);
        Color right = picture.get(rightCol, y);
        Color up = picture.get(x, upRow);
        Color down = picture.get(x, downRow);
        int deltaXR, deltaXG, deltaXB, deltaYR, deltaYG, deltaYB;
        deltaXR = left.getRed() - right.getRed();
        deltaXG = left.getGreen() - right.getGreen();
        deltaXB = left.getBlue() - right.getBlue();
        deltaYR = up.getRed() - down.getRed();
        deltaYG = up.getGreen() - down.getGreen();
        deltaYB = up.getBlue() - down.getBlue();
        double deltaX = deltaXR * deltaXR + deltaXG * deltaXG + deltaXB * deltaXB;
        double deltaY = deltaYR * deltaYR + deltaYG * deltaYG + deltaYB * deltaYB;
        totalEnergy = deltaX + deltaY;
        return totalEnergy;
    }
    private double[][] energyMatrix() {
        int col = width();
        int row = height();
        e = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                e[i][j] = energy(j, i);
            }
        }
        return e;
    }

    private double[][] transpose(double[][] e) {
        double[][] transposeE = new double[e[0].length][e.length];
        for (int i = 0; i < e[0].length; i++) {
            for (int j = 0; j < e.length; j++) {
                transposeE[i][j] = e[j][i];
            }
        }
        return transposeE;
    }
    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
//        e = transpose(e);
//        int[] result = findVerticalSeam();
//        e = transpose(e);
//        return result;
        int row = e.length;
        int col = e[0].length;
        int[][] parent = new int[row][col];
        double[][] M = new double[row][col];
        for (int i = 0; i < row; i++) {
            M[i][0] = e[i][0];
        }
        double min = 0.0;
        double minSum = Double.MAX_VALUE;
        int minNum = 0;
        for (int j = 1; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (i == 0) {
                    min = Math.min(M[i + 1][j - 1], M[i][j - 1]);
                    if (min == M[i + 1][j - 1]) {
                        parent[i][j] = 1;
                    } else {
                        parent[i][j] = 0;
                    }
                } else if (i == (row - 1)) {
                    min = Math.min(M[i][j - 1], M[i - 1][j - 1]);
                    if (min == M[i][j - 1]) {
                        parent[i][j] = 0;
                    } else {
                        parent[i][j] = -1;
                    }
                } else {
                    min = Math.min(Math.min(M[i + 1][j - 1], M[i][j - 1]), M[i - 1][j - 1]);
                    if (min == M[i + 1][j - 1]) {
                        parent[i][j] = 1;
                    } else if(min == M[i][j - 1]){
                        parent[i][j] = 0;
                    } else {
                        parent[i][j] = -1;
                    }
                }
                M[i][j] = e[i][j] + min;
            }
        }
        for (int i = 0; i < row; i++) {
            if (M[i][col - 1] < minSum) {
                minSum = M[i][col - 1];
                minNum = i;
            }
        }
        int[] result = new int[col];
        for (int i = col - 1; i >= 0; i--) {
            result[i] = minNum;
            minNum = minNum + parent[minNum][i];
        }
        return result;
    }
    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        //M -> cost of minimum cost path ending at (i, j)
        int row = e.length;
        int col = e[0].length;
        int[][] parent = new int[row][col];
        double[][] M = new double[row][col];
        for (int i = 0; i < col; i++) {
            M[0][i] = e[0][i];
        }
        double min = 0.0;
        int minNum = 0;
        double minSum = Double.MAX_VALUE;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    if (M[i - 1][j] < M[i - 1][j + 1]) {
                        parent[i][j] = 0;
                        min = M[i - 1][j];
                    } else {
                        parent[i][j] = 1;
                        min = M[i - 1][j + 1];
                    }
                } else if (j == (col - 1)){
                    if (M[i - 1][j - 1] < M[i - 1][j]) {
                        parent[i][j] = -1;
                        min = M[i - 1][j - 1];
                    } else {
                        parent[i][j] = 0;
                        min = M[i - 1][j];
                    }
                } else {
                        if (M[i - 1][j] < M[i - 1][j + 1]) {
                            parent[i][j] = 0;
                            min = M[i - 1][j];
                        } else {
                            parent[i][j] = 1;
                            min = M[i - 1][j + 1];
                        }
                        if (M[i - 1][j - 1] < min) {
                            parent[i][j] = -1;
                            min = M[i - 1][j - 1];
                        }
                }
                M[i][j] = e[i][j] + min;
            }
        }
        for (int i = 0; i < col; i++) {
            if (M[row - 1][i] < minSum) {
                minSum = M[row - 1][i];
                minNum = i;
            }
        }
        int[] result = new int[row];
        for (int i = row - 1; i >= 0; i--) {
           result[i] = minNum;
           minNum = minNum + parent[i][minNum];
        }
        return result;
    }
    // remove horizontal seam from picture
    public void removeHorizontalSeam(int[] seam) {
        SeamRemover.removeHorizontalSeam(picture, seam);

    }
    // remove vertical seam from picture
    public void removeVerticalSeam(int[] seam) {
        SeamRemover.removeVerticalSeam(picture, seam);
    }
}
