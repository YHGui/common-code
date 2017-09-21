package NetEase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taxiPoint = sc.nextInt();
        int[] pointX = new int[taxiPoint];
        int[] pointY = new int[taxiPoint];
        for (int i = 0; i < taxiPoint; i++) {
            pointX[i] = sc.nextInt();
        }
        for (int j = 0; j < taxiPoint; j++) {
            pointY[j] = sc.nextInt();
        }
        int locationX = sc.nextInt();
        int locationY = sc.nextInt();
        //分别移动到相邻(横向或者纵向)的时间
        int walkTime = sc.nextInt();
        int taxiTime = sc.nextInt();
        int[] walkToTaxi = new int[taxiPoint];
        for (int m = 0; m < taxiPoint; m++) {
            walkToTaxi[m] = moveToPoint(0, 0, pointX[m], pointY[m]);
        }
        int walkTotal = moveToPoint(0, 0, locationX, locationY) * walkTime;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < taxiPoint; k++) {
            int timeTotal = walkToTaxi[k] * walkTime +
                    taxiTime * moveToPoint(pointX[k], pointY[k], locationX, locationY);
            min = Math.min(min, timeTotal);
        }
        if (min > walkTotal) {
            min = walkTotal;
        }
        System.out.println(min);
    }
    public static int moveToPoint(int sorPointX, int sorPointY, int desPointX, int desPointY) {
        return Math.abs(desPointX - sorPointX) + Math.abs(desPointY - sorPointY);
    }
}
