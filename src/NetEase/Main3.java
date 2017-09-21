package NetEase;

import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        int[] magic = new int[num];
        for (int i = 0; i < num; i++) {
            magic[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int temp = magic[0];
            for (int j = 0; j < num; j++) {
                if (j == (num - 1)) {
                    magic[j] = (magic[j] + temp) % 100;
                    break;
                }
                magic[j] = (magic[j] + magic[j + 1]) % 100;
            }

        }
        for (int i = 0; i < num; i++) {
            if (i == (num - 1)) {
                System.out.println(magic[i]);
                break;
            }
            System.out.println(magic[i] + " ");
        }
    }
}
