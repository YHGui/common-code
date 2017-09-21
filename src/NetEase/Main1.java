package NetEase;

import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] tx = new int[n];
            int[] ty = new int[n];
            for (int i = 0; i < n; i++) {
                tx[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                ty[i] = sc.nextInt();
            }
            int gx = sc.nextInt();
            int gy = sc.nextInt();
            int walkTime = sc.nextInt();
            int taxiTime = sc.nextInt();
            int ans = (Math.abs(gx) + Math.abs(gy)) * walkTime;
            for (int i = 0; i < n; i++) {
                int dis = Math.abs(tx[i]) + Math.abs(ty[i]);
                int time1 = dis * walkTime;
                int dis2 = Math.abs(tx[i] - gx) + Math.abs(ty[i] - gy);
                int time2 = dis2 * taxiTime;
                ans = Math.min(ans, time1 + time2);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
