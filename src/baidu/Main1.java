package baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            //for (int j = 0; j < 4; j++) {
                char ch = sc.next().charAt(0);
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                Point point = new Point(x, y, z, ch);
                points[i] = point;
                //System.out.println(ch);
        }
        //System.out.println(points[0].color);
        List<Point> pointsR = new ArrayList<>();
        List<Point> pointsG = new ArrayList<>();
        List<Point> pointsB = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (points[i].color == 'R') {
                pointsR.add(points[i]);
            }
            if (points[i].color == 'G') {
                pointsG.add(points[i]);
            }
            if (points[i].color == 'B') {
                pointsB.add(points[i]);
            }
        }
        double max = Double.MIN_VALUE;
        if (pointsR.size() >= 3) {
            for (int i = 0; i < pointsR.size(); i++) {
                for (int j = i + 1; j < pointsR.size(); j++) {
                    for (int k = j + 1; k < pointsR.size(); k++) {
                        max = Math.max(max, countTriangleArea(pointsR.get(i), pointsR.get(j), pointsR.get(k)));
                    }
                }
            }
        }
        if (pointsG.size() >= 3) {
            for (int i = 0; i < pointsG.size(); i++) {
                for (int j = i + 1; j < pointsG.size(); j++) {
                    for (int k = j + 1; k < pointsG.size(); k++) {
                        max = Math.max(max, countTriangleArea(pointsG.get(i), pointsG.get(j), pointsG.get(k)));
                    }
                }
            }
        }
        if (pointsB.size() >= 3) {
            for (int i = 0; i < pointsB.size(); i++) {
                for (int j = i + 1; j < pointsB.size(); j++) {
                    for (int k = j + 1; k < pointsB.size(); k++) {
                        max = Math.max(max, countTriangleArea(pointsB.get(i), pointsB.get(j), pointsB.get(k)));
                    }
                }
            }
        }
        for (int i = 0; i < pointsR.size(); i++) {
            for (int j = 0; j < pointsG.size(); j++) {
                for (int k = 0; k < pointsB.size(); k++) {
                    max = Math.max(max, countTriangleArea(pointsR.get(i), pointsG.get(j), pointsB.get(k)));
                }
            }
        }
        //System.out.println((double)(Math.round(max*100000)/100000.00000000000));
        System.out.println(String.format("%.5f", max));

    }
    private static double countTriangleArea(Point a,Point b,Point c){
        double area = -1;

        double[] side = new double[3];//存储三条边的长度;

        side[0] = sqrt(pow(a.x - b.x,2)+pow(a.y - b.y,2) + pow(a.z - b.z,2));
        side[1] = sqrt(pow(a.x - c.x,2)+pow(a.y - c.y,2) + pow(a.z - c.z,2));
        side[2] = sqrt(pow(c.x - b.x,2)+pow(c.y - b.y,2) + pow(c.z - b.z,2));

        //不能构成三角形;
        if(side[0]+side[1]<=side[2] || side[0]+side[2]<=side[1] || side[1]+side[2]<=side[0]) {
            return area;
        }

        //利用海伦公式。s=sqr(p*(p-a)(p-b)(p-c));
        double p = (side[0]+side[1]+side[2])/2; //半周长;
        area = sqrt(p*(p-side[0])*(p-side[1])*(p-side[2]));

        return area;
    }
}
