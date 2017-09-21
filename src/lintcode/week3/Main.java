package lintcode.week3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            int[] vx = new int[n];
            int[] vy = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                vx[i] = in.nextInt();
                vy[i] = in.nextInt();
            }

            int[] pair = new int[2];
            for (int i = 0; i < n; i++) {
                double max = Integer.MIN_VALUE;
                for (int j = 0; j < n; j++) {
                    double dist = dist(x[i],y[i], x[j], x[j]);
                    if (dist > max) {
                        max = dist;
                        pair[0] = i;
                        pair[1] = j;
                    }
                }
            }

            double  t = 0.0;
            double minNum = 0.0;
            double minDist = Integer.MAX_VALUE;
            while (t < 100) {
                double dist = (x[pair[0]] + t * vx[pair[0]] - x[pair[1]] - t * vx[pair[1]]) *
                        (x[pair[0]] + t * vx[pair[0]] - x[pair[1]] - t * vx[pair[1]]) +
                        (y[pair[0]] + t * vy[pair[0]] - y[pair[1]] - t * vy[pair[1]]) *
                        (y[pair[0]] + t * vy[pair[0]] - y[pair[1]] - t * vy[pair[1]]);
                if (dist < minDist) {
                    minNum = t;
                    minDist = dist;
                }
                t += 0.001;
            }

            System.out.print(String.format("%.2f", minNum));
            System.out.print(" ");
            System.out.println(String.format("%.2f",Math.sqrt(minDist)));
        }
    }

    private static double dist(double x1, double y1, double x2, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

}
